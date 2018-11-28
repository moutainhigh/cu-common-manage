package com.aotain.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.aotain.common.utils.model.push.PushMessage;
import com.aotain.common.utils.model.push.SendData;
import com.aotain.common.utils.model.smmscmd.IdcInfoManage;
import com.aotain.common.utils.model.smmscmd.IdcInfoManage.CommandInfo;
import com.aotain.common.utils.push.PushClient;
import com.aotain.common.utils.push.dao.PushMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-base.xml" })
public class PushTest {

	@Autowired
	private PushMapper pmap;
	
	@Autowired
	private PushClient client;
	
	private PushMessage msg = new PushMessage();

	@Test
	public void testDBQuery() {
		System.err.println(pmap.getPushParams());
		System.err.println(pmap.getNextId());
		System.err.println(pmap.getHouseNameById(823L));
		System.err.println(pmap.getUserNameById(621L));
	}

	@Test
	@Transactional   // 标明此方法需使用事务
	@Rollback(true)  // 标明使用完此方法后事务不回滚,true时为回滚
	public void testDBInsert() {
		msg.setPushType(1);
		msg.setSendData("sdfasdfasdfasfas");
		msg.setStatus(1);
		int count = pmap.insertPushMessage(msg);
		System.err.println("insert row count = "+count+",pushId = "+msg.getPushId());
	}
	
	@Test
	@Transactional   
	@Rollback(true)  
	public void testDBUpdate() {
		int count = pmap.updatePushMessageStatus(429420L, 1);
		System.err.println("update row count = "+count+",pushId = "+429420L);
	}
	
	@Test
	@Transactional   
	@Rollback(true)  
	public void testPushMessage(){
		SendData sendData = new SendData();
		sendData.setAlarmHouse("[机房1,机房2]");
		sendData.setContent("系统告警推送测试");
		client.pushMessage(sendData,3);
	}

	@Test
	@Transactional   
	@Rollback(true)  
	public void testPushCommand(){
		IdcInfoManage data = new IdcInfoManage();
		data.setCommandId(123434544L);
		data.setTimestamp("2018-01-12 17:03:22");
		data.setType(BigInteger.ONE);
		
		CommandInfo info = new CommandInfo();
		info.setIdcId("129888888");
		info.getId().add(621L);
		info.setQueryMonitorDayFrom("2018-01-11 17:03:22");
		info.setQueryMonitorDayTo("2018-01-12 17:03:22");
		data.setCommandInfo(info);
		client.pushCommand(1000, JSON.toJSONString(data));
	}
	
	public static byte[] getBytes(String key) {
		byte[] bytes = new byte[16];
		for(int  i = 0 ;i <  key.length() ;i++){
			bytes[i/2] =   (byte) (bytes[i/2] | ((key.charAt(i) & 0xff) << (8 - (i%2) *8 )));
		}
		// [81, 116, 79, 118, 77, 89, 80, 106, 113, 52, 55, 97, 54, 78, 50, 71]
		
		// 原算法： 5QTtRO3vQMaYnPajQqc4d7eaF6BNS2dG => 894522484,1380922230,1364025689,1850761578,1366385460,1681352033,1177961038,1395811399
		int[] array = new int[8];
		for(int  i = 0 ;i <  key.length() ;i++){
			array[i/4] = array[i/4] | ((key.charAt(i) & 0xff) << (24 -(i%4)*8)) ;
			if(i%4 == 3){
				System.out.println(array[i/4]);
			}
		}
		return bytes;
//		return new WordArray.init(words, latin1StrLength);
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		String srcStr = "0b40704191f9f2bdb42f44493c57e6647f50bacb6ba76088d98485e751de78fdc35b3d3b34502a11bd1ec26dae1e9f40";
		byte[] src = srcStr.getBytes("UTF-8");
		String sKey = "5QTtRO3vQMaYnPajQqc4d7eaF6BNS2dG";
		String sIv = "5QTtRO3vQMaYnPajQqc4d7eaF6BNS2dG";
		//原始key ，i字符串值 ： "5QTtRO3vQMaYnPajQqc4d7eaF6BNS2dG";
//		
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		byte[] raw = getBytes(sKey);//.getBytes("ASCII");
//		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES"); // DESede
//		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS7Padding");
		byte[] org = getBytes(sIv);
		byte[] newOrg = Arrays.copyOfRange(org, 8, 16);
		IvParameterSpec iv = new IvParameterSpec(org);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		byte[] encrypted1 = src;
		try {
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original,"UTF-8");
			System.out.println( originalString);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
			
	}
}
