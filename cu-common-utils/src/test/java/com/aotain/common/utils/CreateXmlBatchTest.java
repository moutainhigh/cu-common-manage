package com.aotain.common.utils;

import java.math.BigInteger;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aotain.common.utils.model.smmsupload.ActiveResources;
import com.aotain.common.utils.model.smmsupload.ActiveResources.FindDomainList;
import com.aotain.common.utils.tools.CreateXmlTools;
import com.aotain.common.utils.tools.CreateXmlTools.CacheDirManager;
import com.aotain.common.utils.tools.CreateXmlTools.Result;
import com.aotain.common.utils.tools.Tools;

/**
 * 批量创建Xml测试
 * 
 * @author liuz@aotian.com
 * @date 2017年12月4日 下午1:30:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-base.xml" })
public class CreateXmlBatchTest {
	
	@Test
	public void testCreateBatchXmls(){
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
		try {
			// 1. 创建一个CacheDirManager:文件名保证同一时刻，两个不同的使用者唯一，推荐用Tools.getBatchId()创建
			CacheDirManager manager = CreateXmlTools.createCacheDirManager(Tools.getBatchId(), 0L);
			if(manager.createDirs()){ // createDirs - 可以省略，不存在会自动创建
				for(int i = 0 ; i < 10; i++){
					// 2. 循环调用创建xml文件
					Result r = CreateXmlTools.validateAndCreateXmlToCacheDir(8, "test_idc_name_"+i, bi,manager);
					System.out.println("=============8 DT_ACTIVE_RESOURCES================");
					if (StringUtils.isBlank(r.getError())) {
						System.out.println("上报文件创建成功:");
						System.out.println(r.getXmlPath());
					} else {
						System.out.println("上报文件创建失败:" + r.getError());
					}
				}
				
				int count = manager.count(); // 查询缓存下上报文件个数
				System.out.println("总共创建了"+count+"个文件");
				// 3. 提交缓存文件到正式目录
				int countTest = CreateXmlTools.submitCacheFiles(8, manager); // 提交缓存文件到正式目录
				System.out.println("提交了"+countTest+"个文件");
				
				// 4. 删除缓存delete:删掉整个目录；clear-删掉所有上报文件，目录和不相干文件保留
				/*boolean df = manager.delete();
				System.out.println(df ? "目录删除成功" : "目录删除失败");*/
				
				boolean cf = manager.clear();
				System.out.println(cf ? "目录清空成功" : "目录清空失败");
			}else{
				System.out.println("目录创建失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
