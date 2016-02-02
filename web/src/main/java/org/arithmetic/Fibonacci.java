package org.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;

public class Fibonacci {

  public static int f0(int n)
  {
    if(n==1||n==2)
    {
      return 1;
    }
    else
    {
      return f0(n-1)+f0(n-2);
    }
  }
  
  
  private static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(10);
  
  
  public static int f1(int n)
  {
    if(n==1||n==2)
    {
      return 1;
    }
    else if(map.get(n)!=null)
    {
      return map.get(n);
    }
    else
    {
      int i= f0(n-1)+f0(n-2);
      map.put(n,i);
      return i;
    }
  }
  
  private static ArrayList<Integer> list=new ArrayList<Integer>(10);
  
  public static int f2(int n)
  {
    list.add(1);
    list.add(1);
    for(int i=2;i<n;i++)
    {
      list.add(list.get(i-2)+list.get(i-1));
    }
    return list.get(n-1);
  }
  
  public static void main(String[] args) {
      System.out.println(f2(10));
  }

}
