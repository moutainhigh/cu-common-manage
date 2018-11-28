package com.aotain.common.config;

import java.util.List;

//import com.aotain.common.config.service.IdcService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.aotain.common.config.dao.IdcJcdmJkcsMapper;
import com.aotain.common.config.model.IdcJcdmJkcs;

/**
 * Demo class
 * 
 * @author daiyh@aotain.com
 * @date 2017/11/14
 */
public class IdcJcdmJkcsMapperTest extends BaseTest {
	@Autowired
	private IdcJcdmJkcsMapper idcJcdmJkcsMapper;

//	@Autowired
//	private IdcService idcService;
	

	@Test
//	@Rollback(false)
	public void test() {
		IdcJcdmJkcs idcJcdmJkcs = new IdcJcdmJkcs();
		idcJcdmJkcs.setId(1001);
		idcJcdmJkcs.setCsKey("test");
		idcJcdmJkcs.setCsValue("are you ok");
		idcJcdmJkcsMapper.insert(idcJcdmJkcs);
	}

	@Test
	public void test2() {
		List<IdcJcdmJkcs> result = idcJcdmJkcsMapper.selectConfig();
		System.out.println(result);
		for (IdcJcdmJkcs idcJcdmJkcs : result) {
			System.out.println("key=====" + idcJcdmJkcs.getCsKey());
			System.out.println("value=====" + idcJcdmJkcs.getCsValue());
		}

	}
}
