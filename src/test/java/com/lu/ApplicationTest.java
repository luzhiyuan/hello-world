package com.lu;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application.xml" })
public class ApplicationTest {
	
	@Test
	public void test(){
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("application.xml");
		App app = (App) cxac.getBean("app");
		app.checkOrder();
	}
	
	@Test  
	public void testListInEasyMock() {  
	    List list = EasyMock.createMock(List.class);  
	    // 录制过程  
	   
	    // 期望方法list.set(0,1)执行2次，返回null，不抛出异常  
	    expect1: EasyMock.expect(list.set(0, 1)).andReturn(null).times(2);  
	    // 期望方法list.set(0,1)执行1次，返回null，不抛出异常  
	    expect2: EasyMock.expect(list.set(0, 1)).andReturn(1);  
	   
	    // 执行测试代码  
	    EasyMock.replay(list);  
	        // 执行list.set(0,1)，匹配expect1期望，会返回null  
	    Assert.assertNull(list.set(0, 1));  
	        // 执行list.set(0,1)，匹配expect1（因为expect1期望执行此方法2次），会返回null  
	    Assert.assertNull(list.set(0, 1));  
	        // 执行list.set(0,1)，匹配expect2，会返回1  
	    Assert.assertEquals(1, list.set(0, 1));  
	   
	    // 验证期望  
	    EasyMock.verify(list);  
	}  
}
