package com.zl.config;

import com.zl.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/22
 */
@Configuration
public class MainConfig implements WebMvcConfigurer {

//	@Bean
//	public ServerEndpointExporter serverEndpointExporter() {
//		return new ServerEndpointExporter();
//	}

	@Bean
	public Person person(){
		return new Person("张三", "男");
	}

}
