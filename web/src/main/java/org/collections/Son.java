package org.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class Son extends Parent implements Implementable2 {

  @Override
  public void do2() {
    
  }
  
  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException
  {
    Son son=new Son();
    Field[] fields=son.getClass().getSuperclass().getDeclaredFields();
    Field[] superFields=son.getClass().getSuperclass().getSuperclass().getDeclaredFields();
    StringBuilder builder=new StringBuilder(30);
    StringBuilder superBuilder=new StringBuilder(30);
    Class clz=son.getClass();
    ArrayList<Field> all=new ArrayList<Field>(20);
    while(clz!=null)
    {
      System.out.println(clz.getName());
      all.addAll(Arrays.asList(clz.getDeclaredFields()));
      clz=clz.getSuperclass();
    }
    for(Field f:all)
    {
      f.setAccessible(true);
      System.out.println(f.getClass().getName()+" "+f.getName()+":"+f.get(son));
    }
  }
  
}
