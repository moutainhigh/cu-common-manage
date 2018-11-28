package com.aotain.common.utils;

import java.math.BigInteger;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aotain.common.utils.model.smmsupload.ActiveResources;
import com.aotain.common.utils.model.smmsupload.ActiveResources.FindDomainList;
import com.aotain.common.utils.model.smmsupload.ActiveState;
import com.aotain.common.utils.model.smmsupload.BasicInfo;
import com.aotain.common.utils.model.smmsupload.BasicInfo.NewInfo;
import com.aotain.common.utils.model.smmsupload.CommandQueryResult;
import com.aotain.common.utils.model.smmsupload.CommandQueryResult.Command;
import com.aotain.common.utils.model.smmsupload.CommandQueryResult.Command.Action;
import com.aotain.common.utils.model.smmsupload.CommandQueryResult.Command.Privilege;
import com.aotain.common.utils.model.smmsupload.CommandQueryResult.Command.Range;
import com.aotain.common.utils.model.smmsupload.CommandQueryResult.Command.Rule;
import com.aotain.common.utils.model.smmsupload.CommandQueryResult.Command.Time;
import com.aotain.common.utils.model.smmsupload.FilterResult;
import com.aotain.common.utils.model.smmsupload.IdcMonitor;
import com.aotain.common.utils.model.smmsupload.IllegalWeb;
import com.aotain.common.utils.model.smmsupload.LogQueryResult;
import com.aotain.common.utils.model.smmsupload.MonitorResult;
import com.aotain.common.utils.model.smmsupload.MonitorResult.Log;
import com.aotain.common.utils.tools.CreateXmlTools;
import com.aotain.common.utils.tools.CreateXmlTools.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-base.xml" })
public class CreateXmlTest {

	@Test
	public void testBasicInfo() {
		BasicInfo bi = new BasicInfo();
		NewInfo ni = new NewInfo();
		ni.setIdcId("1k2jk123");
		bi.setNewInfo(ni);
		bi.setTimeStamp("2017-11-18 11:37:22");
		Result r = CreateXmlTools.validateAndCreateXml(1, "12312kjlklk", bi,0L,null);
		System.out.println("=============1 基础数据上报================");
		if (StringUtils.isBlank(r.getError())) {
			System.out.println("上报文件创建成功:");
			System.out.println(r.getXmlPath());
		} else {
			System.out.println("上报文件创建失败:" + r.getError());
		}
	}

	@Test
	public void testMonitor() {
		IdcMonitor bi = new IdcMonitor();
		bi.setCommandId(12312321L);
		bi.setIdcId("123123123kkjk");
		bi.setTimeStamp("2017-11-18 11:37:22");
		Result r = CreateXmlTools.validateAndCreateXml(2, "12312kjlklk", bi,0L,null);
		System.out.println("=============2 IdcMonitor================");
		if (StringUtils.isBlank(r.getError())) {
			System.out.println("上报文件创建成功:");
			System.out.println(r.getXmlPath());
		} else {
			System.out.println("上报文件创建失败:" + r.getError());
		}
	}

	@Test
	public void testLogquery() {
		LogQueryResult bi = new LogQueryResult();
		bi.setCommandId(12312321L);
		bi.setIdcId("123123123kkjk");
		com.aotain.common.utils.model.smmsupload.LogQueryResult.Result sr = new com.aotain.common.utils.model.smmsupload.LogQueryResult.Result();
		sr.setLogAmount(111l);
		sr.setEndFlag(BigInteger.ONE);
		bi.setResult(sr);

		bi.setTimeStamp("2017-11-18 11:37:22");
		Result r = CreateXmlTools.validateAndCreateXml(3, "12312kjlklk", bi,0L,null);
		System.out.println("=============3 DT_LOG_QUERY================");
		if (StringUtils.isBlank(r.getError())) {
			System.out.println("上报文件创建成功:");
			System.out.println(r.getXmlPath());
		} else {
			System.out.println("上报文件创建失败:" + r.getError());
		}
	}

	@Test
	public void testMonitorQuery() {
		MonitorResult bi = new MonitorResult();
		Log l = new Log();
		l.setCommandId(123232L);
		l.setSrcIp("12313213");
		l.setDestIp("123123132");
		l.setDomain("www.baidu.com");
		l.setGatherTime("1231231");
		bi.getLog().add(l);
		bi.setIdcId("123123123kkjk");

		bi.setTimeStamp("2017-11-18 11:37:22");
		Result r = CreateXmlTools.validateAndCreateXml(4, "12312kjlklk", bi,0L,null);
		System.out.println("=============4 DT_MONITOR_QUERY================");
		if (StringUtils.isBlank(r.getError())) {
			System.out.println("上报文件创建成功:");
			System.out.println(r.getXmlPath());
		} else {
			System.out.println("上报文件创建失败:" + r.getError());
		}
	}

	@Test
	public void testFilterQuery() {
		FilterResult bi = new FilterResult();
		FilterResult.Log l = new FilterResult.Log();
		l.setCommandId(123232L);
		l.setSrcIp("12313213");
		l.setDestIp("123123132");
		l.setDomain("www.baidu.com");
		l.setGatherTime("1231231");
		bi.getLog().add(l);
		bi.setIdcId("123123123kkjk");

		bi.setTimeStamp("2017-11-18 11:37:22");
		Result r = CreateXmlTools.validateAndCreateXml(5, "12312kjlklk", bi,0L,null);
		System.out.println("=============5 FilterResult================");
		if (StringUtils.isBlank(r.getError())) {
			System.out.println("上报文件创建成功:");
			System.out.println(r.getXmlPath());
		} else {
			System.out.println("上报文件创建失败:" + r.getError());
		}
	}

	@Test
	public void testCommandQuery() {
		CommandQueryResult bi = new CommandQueryResult();
		bi.setIdcId("123123123kkjk");
		Command c = new Command();
		c.setCommandId(123123L);
		c.setType(BigInteger.ONE);
		Privilege pi = new Privilege();
		pi.setOwner("sadfafasd");
		pi.setVisible(BigInteger.TEN);
		c.setPrivilege(pi);
		Range rg = new Range();
		rg.setHouseId(1231231L);
		rg.setIdcId("123123123kjkjk");
		c.setRange(rg);
		Rule r1 = new Rule();
		r1.setSubtype(BigInteger.ONE);
		r1.setValueStart("www.baidu.com");
		c.getRule().add(r1);
		Action a = new Action();
		a.setReason("hhhhh");
		a.setLog(BigInteger.ONE);
		a.setReport(BigInteger.ONE);
		c.setAction(a);
		Time t1 = new Time();
		t1.setEffectTime("2017");
		t1.setExpiredTime("yyyy");
		c.setTime(t1);
		bi.getCommand().add(c);
		bi.setTimeStamp("2017-11-18 11:37:22");
		Result r = CreateXmlTools.validateAndCreateXml(6, "12312kjlklk", bi,0L,null);
		System.out.println("=============6 DT_COMMAND_QUERY================");
		if (StringUtils.isBlank(r.getError())) {
			System.out.println("上报文件创建成功:");
			System.out.println(r.getXmlPath());
		} else {
			System.out.println("上报文件创建失败:" + r.getError());
		}
	}

	@Test
	public void testActiveState() {
		ActiveState bi = new ActiveState();
		bi.setIdcId("123123123kkjk");
		bi.setHouseAmount(BigInteger.TEN);
		bi.setErrHouseAmount(BigInteger.ZERO);

		bi.setTimeStamp("2017-11-18 11:37:22");
		Result r = CreateXmlTools.validateAndCreateXml(7, "12312kjlklk", bi,0L,null);
		System.out.println("=============7 DT_ACTIVE_STATE================");
		if (StringUtils.isBlank(r.getError())) {
			System.out.println("上报文件创建成功:");
			System.out.println(r.getXmlPath());
		} else {
			System.out.println("上报文件创建失败:" + r.getError());
		}
	}

	@Test
	public void testActiveResources() {
		ActiveResources bi = new ActiveResources();
		FindDomainList a = new FindDomainList();
		a.setBlock(BigInteger.ONE);
		a.setFindDomainListDomain("dsafdsafasd");
		a.setFindDomainListFirstTime("12312kjkasjdfkl");
		a.setFindDomainListLastTime("12312kjkasjdfkl");
		a.setHouseId(1111L);
		a.setIdcId("kkkklllll");
		a.setTopDomain("www.baidu.com");
		a.setIp("182.2342343");
		a.setTopDomainflag(BigInteger.ONE);
		bi.getFindDomainList().add(a);
		Result r = CreateXmlTools.validateAndCreateXml(8, "12312kjlklk", bi,0L,null);
		System.out.println("=============8 DT_ACTIVE_RESOURCES================");
		if (StringUtils.isBlank(r.getError())) {
			System.out.println("上报文件创建成功:");
			System.out.println(r.getXmlPath());
		} else {
			System.out.println("上报文件创建失败:" + r.getError());
		}
	}

	@Test
	public void testIllegalWeb() {
		IllegalWeb bi = new IllegalWeb();
		bi.setBlock(BigInteger.ONE);
		bi.setDomain("www.baidu.com");
		bi.setIdcId("123123131");
		bi.setIllegalType(BigInteger.ONE);
		bi.setIp("1123123312");
		Result r = CreateXmlTools.validateAndCreateXml(9, "12312kjlklk", bi,0L,null);
		System.out.println("=============9 DT_ILLEGAL_WEB================");
		if (StringUtils.isBlank(r.getError())) {
			System.out.println("上报文件创建成功:");
			System.out.println(r.getXmlPath());
		} else {
			System.out.println("上报文件创建失败:" + r.getError());
		}
	}
}
