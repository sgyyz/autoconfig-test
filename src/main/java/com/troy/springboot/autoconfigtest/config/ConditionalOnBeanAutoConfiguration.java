package com.troy.springboot.autoconfigtest.config;

import com.troy.springboot.autoconfigtest.bean.ActuallyBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ConditionalOnBeanAutoConfiguration {

  @Bean
  @ConditionalOnBean(ConditionalBean.class)
  public ActuallyBean actuallyBean() {
    return new ActuallyBean();
  }

  public static class ConditionalBean {

  }

}
