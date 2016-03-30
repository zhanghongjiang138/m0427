package org;

import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

public class Utils {
  
  public static void print(Object o )
  {
    System.out.print(o);
    Hashtable t;
  }
  
  public static void println(Object o )
  {
    System.out.print(o);
  }
  
  
  public static void main(String[] args)
  {
    String modelPosition="(10,10)";
    Pattern p=Pattern.compile("^[a-zA-Z]+$");
    Matcher m=p.matcher("asd1");
  
    
    String str="right";
    boolean flag=str.matches("^[a-zA-Z]+$");
    boolean flag1=modelPosition.matches("^\\(\\d+,\\d+\\)$");
    System.out.println(m.find());
    System.out.println(flag1);
    System.out.println(modelPosition.replaceAll("\\(|\\)",""));
    
    

    double a=Double.parseDouble("0.5");
    System.out.println("0.5".matches("^\\(\\d+,\\d+\\)$"));
  }
}
