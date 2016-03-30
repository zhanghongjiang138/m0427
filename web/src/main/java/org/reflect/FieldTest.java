package org.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FieldTest {

  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    List<HashMap<String,String>> a ;
    
    Set<Field> all=new HashSet<Field>(20);
    Class<?> clz=Man.class;
    while(clz!=null)
    {
      Field[] fields=clz.getDeclaredFields();
      all.addAll(Arrays.asList(fields));
      clz=clz.getSuperclass();
    }
    Man man=new Man();
    for(Field field:all)
    {
      //System.out.println(field.getName());
      System.out.println(field.get(man));
    }

  }

}
