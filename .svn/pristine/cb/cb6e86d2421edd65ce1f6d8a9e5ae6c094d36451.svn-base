package com.aotain.common.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;

import org.apache.derby.iapi.services.cache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aotain.common.utils.ismi.validate.UploadFileXsdValidator;
import com.aotain.common.utils.model.smmsupload.ActiveResources;
import com.aotain.common.utils.model.smmsupload.FileLoad;
import com.aotain.common.utils.tools.CreateXmlTools;
import com.aotain.common.utils.tools.CreateXmlTools.CacheDirManager;
import com.aotain.common.utils.tools.CreateXmlTools.Result;
import com.aotain.common.utils.tools.FileLoadDecode;
import com.aotain.common.utils.tools.FileUtils;
import com.aotain.common.utils.tools.XmlUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-base.xml" })
public class ActiveResourceValidataTest {
	
	private void validateFile(InputStream is){
		try {
			ActiveResources ar = XmlUtils.createBean(is, ActiveResources.class);
			CreateXmlTools.validateAndCreateXml(8, "aaaaa", ar, 0L, 101);
			//UploadFileXsdValidator.getInstance().doValidate(8,is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void validateFile(InputStream is,CacheDirManager cm){
		try {
			ActiveResources ar = XmlUtils.createBean(is, ActiveResources.class);
//			CreateXmlTools.validateAndCreateXml(8, "aaaaa", ar, 0L, 101);
			Result r = CreateXmlTools.validateAndCreateXmlToCacheDir(8, "aaaaa", ar,cm, 101);
			System.out.println(r.toString());
			//UploadFileXsdValidator.getInstance().doValidate(8,is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void  test() throws Exception {
		File root = new File("test");
		File[] files = root.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
//				return name.endsWith("15233467240002419789_data.xml");
				return name.matches(".*\\d.xml$");
			}
		});
		
		if(files == null || files.length == 0){
			System.err.println("无xml文件");
			return;
		}
		
		System.out.println("开始校验...");
		CacheDirManager cm = CreateXmlTools.createCacheDirManager("cache", 1000L);
		for(File file : files) {
			byte[] data = FileUtils.read2Bytes(file.getAbsolutePath());
			FileLoad fload = null;
			try {
				fload = XmlUtils.createBean(new ByteArrayInputStream(data), FileLoad.class);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

			if (fload == null) {
				System.out.println("解析文件成xml对象失败:" + file.getName());
				return;
			}
			InputStream is = FileLoadDecode.decodeXml(fload);
			if (is == null) {
				return;
			}
			System.out.println("开始校验:" + file.getName());
			long stime = System.currentTimeMillis();
			validateFile(is,cm);
			long takes = System.currentTimeMillis()-stime;
			System.out.println("耗时："+(takes)+" ms, 文件："+file.getName());
		}
	}
}
