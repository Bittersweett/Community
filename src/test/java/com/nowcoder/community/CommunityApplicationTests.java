package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class) //以它测试
public class CommunityApplicationTests implements ApplicationContextAware {

//	@Test
//	public void contextLoads() {
//
//	}
//

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

//	@Test
//	public void testApplicationContext() {
//		System.out.println(applicationContext);
//
//		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
//		System.out.println(alphaDao.select());
//
//		alphaDao = applicationContext.getBean("alphaHibernate", AlphaDao.class);
//		System.out.println(alphaDao.select());
//	}

//	@Test
//	public void testBeanManagement() {
//		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
//		System.out.println(alphaService);
//
//		alphaService = applicationContext.getBean(AlphaService.class);
//		System.out.println(alphaService);
//	}


//	@Test
//	public void testBeanConfig() {
//		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
//		System.out.println("date:" + simpleDateFormat.format(new Date()));
//	}

	@Autowired
	@Qualifier("alphaHibernate")
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI() {
		System.out.println("testDI " + alphaDao);
		System.out.println("testService" + alphaService);
		System.out.println("simpleDateFormat" + simpleDateFormat);
	}
}
