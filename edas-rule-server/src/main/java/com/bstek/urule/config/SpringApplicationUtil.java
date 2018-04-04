package com.bstek.urule.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringApplicationUtil.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	/**
	 * 获取服务Bean
	 * @param name String 服务Bean名称
	 * @return Object
	 */
	public static Object getBean(String name) {
		if (applicationContext == null)
			throw new RuntimeException("ApplicationContext为空");
		else
			return applicationContext.getBean(name);			
	}
	
	/**
	 * 获取服务接口
	 * @param impClz Class 实现类
	 * @return bean
	 */	
	public static <T> T getBean(Class<T> impClz){
		return applicationContext.getBean(impClz);
	}

}
