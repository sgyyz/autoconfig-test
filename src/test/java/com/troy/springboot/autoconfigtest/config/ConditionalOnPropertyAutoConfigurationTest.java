package com.troy.springboot.autoconfigtest.config;

import static org.assertj.core.api.Assertions.assertThat;

import com.troy.springboot.autoconfigtest.bean.ActuallyBean;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalOnPropertyAutoConfigurationTest {
  private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testConditionalOnPropertyCreateBeanSuccess() {
    EnvironmentTestUtils.addEnvironment(this.context, "enable.actuallyBean: true");
    this.context.register(ConditionalOnPropertyAutoConfiguration.class);
    this.context.refresh();

    ActuallyBean bean = this.context.getBean(ActuallyBean.class);
    assertThat(bean).isNotNull();
  }

  @Test
  public void testConditionalOnPropertyCreateBeanFailed() {
    this.thrown.expect(NoSuchBeanDefinitionException.class);

    EnvironmentTestUtils.addEnvironment(this.context, "enable.actuallyBean: false");
    this.context.register(ConditionalOnPropertyAutoConfiguration.class);
    this.context.refresh();

    this.context.getBean(ActuallyBean.class);
  }
}
