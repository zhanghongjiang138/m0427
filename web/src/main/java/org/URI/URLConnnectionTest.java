package org.URI;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConnnectionTest {
  private static final String url1="http://www.baidu.com";
  private static final String url="http://127.0.0.1:8088/ime/manage/index#WAIT_TASK";
  public static void main(String[] args) throws IOException {
    URL u=new URL(url);
    
    URLConnection uc=u.openConnection();
    uc.setRequestProperty("Cookie", "jsessionid=ih16wouzlfm4"); 
    uc.connect();
    BufferedInputStream bis=new BufferedInputStream(uc.getInputStream());
    for(int i=1;;i++)
    {
      String header=uc.getHeaderField(i);
      if(header==null) break;
      System.out.println(uc.getHeaderFieldKey(i)+":"+header);
    }
    System.out.println();
    byte[] b=new byte[bis.available()];
    int start=0;
    bis.read(b, start, bis.available());
    for(byte bb:b)
    {
      System.out.print(Integer.toHexString((int)(bb))+" ");
    }
    
    BufferedReader reader=new BufferedReader(new InputStreamReader(uc.getInputStream()));
    StringBuilder sb=new StringBuilder();
    String s=null;
    while((s=reader.readLine())!=null)
    {
      sb.append(s+"\n");
    }
    System.out.println();
    System.out.println(sb.toString());
    
    
  }

}
