package org.proxy.cglib;
import net.sf.cglib.proxy.Enhancer;


public class TestCglibProxy {

  public static void main(String[] args) {
    TestCglibProxy proxy=new TestCglibProxy();
    Target tt=(Target)proxy.createProxy(Target.class);
    tt.execute();
    tt.say();
  }
  
  public Object createProxy(Class c)
  {
    Enhancer e=new Enhancer();
    e.setSuperclass(c);
    e.setCallback(new MyMethodIntercepter());
    return e.create();
  }

}
