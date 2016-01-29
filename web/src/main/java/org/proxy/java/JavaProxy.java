package org.proxy.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class JavaProxy implements InvocationHandler {
  
  private Object target;
  

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("start");
    Object o=method.invoke(target, args);
    System.out.println("end");
    System.out.println("method return:"+o);
    return null;
  }
  
  public Object getProxyInstance(Object target)
  {
    this.target=target;
    return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
  }
  
  public static void main(String[] args)
  {
    JavaProxy jp=new JavaProxy();
    SayA a=new SayA();
    Say aa=(Say)jp.getProxyInstance(a);
    aa.sayWords();
  }

}
