package com.miracle.myrule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.apache.tomcat.util.descriptor.tld.ImplicitTldRuleSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zjm
 * @Date 2020/11/17
 * @Description
 */
@Configuration
public class MyRandomRule {
    @Bean
    public IRule getRule() {
        return new RandomRule();
    }

}
