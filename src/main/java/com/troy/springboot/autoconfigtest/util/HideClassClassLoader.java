package com.troy.springboot.autoconfigtest.util;

import java.net.URL;
import java.net.URLClassLoader;

public class HideClassClassLoader extends URLClassLoader {
  private final Class<?>[] hideClasses;

  public HideClassClassLoader(Class<?>... hideClasses) {
    super(new URL[0], HideClassClassLoader.class.getClassLoader());
    this.hideClasses = hideClasses;
  }

  @Override
  protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

    if (hideClasses != null && hideClasses.length > 0) {
      for (Class<?> hideClass : hideClasses) {
        checkHideClass(name, hideClass);
      }
    }

    return super.loadClass(name, resolve);
  }

  private void checkHideClass(String name, Class<?> hideClass) throws ClassNotFoundException {
    if (hideClass.getName().equals(name)) {
      throw new ClassNotFoundException();
    }
  }
}
