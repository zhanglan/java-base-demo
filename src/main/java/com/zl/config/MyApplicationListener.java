package com.zl.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/13
 */
@Component
public class MyApplicationListener implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("MyApplicationListener  onApplicationEvent:" + event);
	}
}
