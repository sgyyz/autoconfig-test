package com.troy.springboot.autoconfigtest.config;

import static org.assertj.core.api.Assertions.assertThat;

import com.troy.springboot.autoconfigtest.config.ConditionalOnClassAutoConfiguration.ActuallyBean;
import com.troy.springboot.autoconfigtest.config.ConditionalOnClassAutoConfiguration.ConditionalClass;
import com.troy.springboot.autoconfigtest.util.HideClassClassLoader;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalOnClassAutoConfigurationTest {

  private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testConditionalOnClassCreateBeanSuccess() {
    this.context.register(ConditionalOnClassAutoConfiguration.class);
    this.context.refresh();

    ActuallyBean bean = this.context.getBean(ActuallyBean.class);
    assertThat(bean).isNotNull();
  }

  @Test
  public void testConditionalOnClassCreateBeanFailed() {
    this.thrown.expect(NoSuchBeanDefinitionException.class);

    this.context.setClassLoader(new HideClassClassLoader(ConditionalClass.class));
    this.context.register(ConditionalOnClassAutoConfiguration.class);
    this.context.refresh();

    this.context.getBean(ActuallyBean.class);
  }
}
