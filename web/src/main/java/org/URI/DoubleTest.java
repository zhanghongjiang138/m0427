package org.URI;

import java.math.BigDecimal;

public class DoubleTest {

  public static void main(String[] args) {
    Double a=new Double(0.003);
    double b=new Double(0.01);
    double o=(b - a);
//    System.out.println(o instanceof Double);
    System.out.println(b-a==0.007);
    System.out.println(o==0.007);
    System.out.println(o==0007d);
    System.out.println(b-a);
    
    BigDecimal bi;
    
  }

}
