package com.troy.springboot.autoconfigtest.config;

import static org.assertj.core.api.Assertions.assertThat;

import com.troy.springboot.autoconfigtest.bean.ActuallyBean;
import com.troy.springboot.autoconfigtest.config.ConditionalOnBeanAutoConfiguration.ConditionalBean;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalOnBeanAutoConfigurationTest {
  private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testConditionalOnBeanCreateBeanSuccess() {
    this.context.register(ConditionalOnBeanAutoConfiguration.class, ConditionalBean.class);
    this.context.refresh();

    ActuallyBean bean = this.context.getBean(ActuallyBean.class);
    assertThat(bean).isNotNull();
  }

  @Test
  public void testConditionalOnBeanCreateBeanFailedMissBean() {
    this.thrown.expect(NoSuchBeanDefinitionException.class);

    this.context.register(ConditionalOnBeanAutoConfiguration.class);
    this.context.refresh();

    this.context.getBean(ActuallyBean.class);
  }
}
