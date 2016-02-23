package org.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * <strong>Title : SeperateFile.java<br></strong>
 * <strong>Package : org.file<br></strong>
 * <strong>Description : </strong>大文件分割成10M大小@<br> 
 * <strong>Create on : 2016年2月23日 上午10:27:03<br></strong>
 * <p>
 * @author zhanghongjiang<br>
 * @version <strong>v1.0.0</strong><br>
 * <br>
 * <strong>修改历史:</strong><br>
 * 修改人	|	修改日期	|	修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public class SeperateFile {
  
  static void seperate(File file,String destDir) throws IOException
  {
    if(!file.exists()) return;
    
    System.out.println(String.valueOf(file.length()));//file size
    
    BufferedInputStream stream=new BufferedInputStream(new FileInputStream(file));
    
    System.out.println(stream.available());//file available 返回int,只能到达int最大值
    System.out.println(Integer.MAX_VALUE);
    BufferedOutputStream out=null;
    int len=10*1024*1024; //10M
    byte[] bytes=new byte[len];
    

    long start=System.currentTimeMillis();
    int fileNum=100;
    try {
      int byteRead=0;
      while((byteRead=stream.read(bytes))!=-1)
      {
        if(fileNum>110)
        {
          break;
        }
        File newFile=new File(destDir+File.separatorChar+String.valueOf(fileNum++));
        //File newFile=destFile.createTempFile(String.valueOf(fileNum++), ".txt", destFile);
        out=new BufferedOutputStream(new FileOutputStream(newFile));
        out.write(bytes,0,byteRead);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally{
      if(stream!=null){
        try {
          stream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if(out!=null){
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    long end=System.currentTimeMillis();
    System.out.println("耗时："+(end-start));
  }
  
  public static void main(String[] args) throws IOException {
      try {
        seperate(new File("D:\\chrome downloads\\vs2015.com_chs.iso"),"D:\\chrome downloads\\seperate\\inner");
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
  }

}
