package org.proxy.cglib;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class MyMethodIntercepter implements MethodInterceptor {

  @Override
  public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy methodProxy) throws Throwable {
    System.out.println("start");
    Object result=methodProxy.invokeSuper(arg0, arg2);
    System.out.println("end");
    return result;
  }

}
