package com.troy.springboot.autoconfigtest.config;

import com.troy.springboot.autoconfigtest.bean.ActuallyBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnPropertyAutoConfiguration {

  @Bean
  @ConditionalOnProperty(name = "enable.actuallyBean")
  public ActuallyBean actuallyBean() {
    return new ActuallyBean();
  }
}
