package org.exception;

public class Test1 {
  
  public static int  calcute(int a,int b) throws Exception
  {
    int result=1;
    try
    {
      result=a/b;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      throw e;
    }
    finally
    {
      return result;
    }
  }
  
  public static void main(String[] args) throws Exception {
    int i=calcute(1,0);
    System.out.println(i);
  }

}
