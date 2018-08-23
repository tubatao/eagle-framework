/**
 * Copyright(c) tubatao Technology Co.,Ltd.
 * All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * project: eagle-authorization-server
 * <p>
 * Revision History:
 * Date		    Version		Name				Description
 * 7/18/2017	1.0			liuzhiheng			Creation File
 */
package com.tubatao.eagle.authorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

/**
 * Description:
 * 
 * 
 * @author liuzhiheng
 * @date Jul 10, 2015 4:02:11 PM
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.tubatao.eagle.authorization","com.tubatao.eagle.core"})
public class Application{
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) throws Throwable {

		ConfigurableEnvironment env = new StandardEnvironment();

		String externalConfigLocation = env.getProperty("spring.config.location");
		String defaultProfile = env.getProperty("spring.profiles.active");
		if (defaultProfile == null) {
			defaultProfile = "development";
		}
		if (externalConfigLocation != null){
			logger.debug("Found external configuration file [" + externalConfigLocation + "]. This will override the default redis.");
		}

		String user = env.getProperty("user.name");
		logger.debug("Current user is " + env.getProperty("user.name") + ". This will been used as the active profile. Please make sure file [application-" + user + ".yml] can be loaded on the classpath.");


		SpringApplication app = new SpringApplication(Application.class);
		app.setAdditionalProfiles("default",defaultProfile, user);

		//Add active profile to environment.
		ApplicationContext ctx = app.run(args);
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
		logger.debug("There are " + activeProfiles.length + " profiles.");
		if (activeProfiles.length>0){
			for (String activeProfile : activeProfiles) {
				logger.debug("Profile will be applied : " + activeProfile);
			}
		}
		logger.info("Application started.");
    }
}
