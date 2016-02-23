package org.file;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class recurseFileSize {
  private static HashMap<String,Long> map=new HashMap<String,Long>(1000);
  public static void recurseFile(File file) throws IOException
  {
    if(file.isDirectory())
    {
      File[] children=file.listFiles();
      for(File f:children)
      {
        if(f.isFile())
        {
          //map.put(f.getCanonicalPath(), file.length());//完整路径
          map.put(f.getName(), file.length());//完整路径
        }
        else
        {
          recurseFile(f);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    String dir="E:\\temp\\3\\ime.platform.parent";
    File file=new File(dir);
    recurseFile(file);
    long max=0;
    for(Entry<String,Long> entry:map.entrySet())
    {
      long value=entry.getValue();
      if(value>max)
      {
        max=value;
      }
      System.out.println(entry.getKey()+":"+value);
    }
    System.out.println(map.size());
    System.out.println(max);
    
  }

}
