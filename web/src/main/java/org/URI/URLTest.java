package org.URI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
  private static final String URL1="http://127.0.0.1:8088/ime/manage/index#QUALITY_MONTHREPORT";
  
  private static final String URL2="http://www.baidu.com";
  
  private static final String fileDir="C:\\Users\\zhanghongjiang\\Desktop\\f";
  
  private static final String charSet="utf-8";
  public static void main(String[] args) throws IOException {
    URL url=new URL(URL2);
    StringBuilder sb=new StringBuilder();
    String s="";
    String fileName="\\URL.txt";
    File dir=new File(fileDir);
    if(!dir.exists())
    {
      dir.mkdirs();
    }
  /*  try
   * 
    (
        BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream(),charSet));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir),charSet));
    )
    {
      while((s=reader.readLine())!=null)
      {
        sb.append(s);
      }
      writer.write(new String(sb));
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }*/
  }

}
