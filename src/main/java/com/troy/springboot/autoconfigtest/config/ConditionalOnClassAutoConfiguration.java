package com.troy.springboot.autoconfigtest.config;

import com.troy.springboot.autoconfigtest.config.ConditionalOnClassAutoConfiguration.ConditionalClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ConditionalClass.class)
public class ConditionalOnClassAutoConfiguration {

  @Bean
  public ActuallyBean actuallyBean() {
    return new ActuallyBean();
  }


  public static class ConditionalClass {

  }

  public static class ActuallyBean {

  }
}
