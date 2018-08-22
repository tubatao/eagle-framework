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
 * Date         Version     Name                Description
 * 7/17/18  1.0         liuzhiheng         Creation File
 */
package com.tubatao.eagle.core.config.redis;

import com.tubatao.eagle.core.config.CacheKeyGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * Description:
 *
 *
 * @author liuzhiheng
 * @date 7/17/18 2:11 PM
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
    @Value("${cache.expireTime:7200}")
    private int expireTime;

    @Bean
    public KeyGenerator keyGenerator(){
        return new CacheKeyGenerator();
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(expireTime);// Sets the default expire time (in seconds)
        return cacheManager;
    }


    /*@Bean
    GemfireCacheManager cacheManager(Cache gemfireCache) {
        GemfireCacheManager cacheManager = new GemfireCacheManager();
        cacheManager.setCache(gemfireCache);
        return cacheManager;
    }
    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireCachingApplication");
        gemfireProperties.setProperty("mcast-port", "10334");
        gemfireProperties.setProperty("log-level", "config");
        gemfireProperties.setProperty("locators","database-server[10334]");
        return gemfireProperties;
    }
    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }*/


    /*@Bean
    CacheFactoryBean cacheFactoryBean() {
        return new CacheFactoryBean();
    }
    @Bean
    GenericRegionFactoryBean genericRegionFactoryBean(final GemFireCache cache) {
        return new GenericRegionFactoryBean() {
            {
                setCache(cache);
                setName("User");
                setClose(false);
            }
        };
    }*/
}