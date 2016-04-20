package org.runtime;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunTimeTest {  
    public static void main(String[] args) {  
        //windows  
//      String cmd = "F:\\apache-tomcat-6.0.20.exe";  
//      String cmd = "D:\\Program Files\\Microsoft Office\\OFFICE11\\WINWORD.EXE F:\\test.doc";  
//      String cmd = "cmd.exe /c start F:\\test.doc";  
        String cmd = "dsquery user -name leihuo";  
   
        Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象  
        try {  
        	
            Process p = run.exec(cmd);// 启动另一个进程来执行命令  
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in,"gbk"));  
            String outputStr="";  
            String lineStr="";  
            while ((lineStr = inBr.readLine()) != null){
            	outputStr=outputStr+lineStr;
            }
            //获得命令执行后在控制台的输出信息  
            System.out.println(outputStr);// 打印输出信息  
            //检查命令是否执行失败。  
            if (p.waitFor() != 0) {  
                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束  
                    System.err.println("命令执行失败!");  
            }  
            inBr.close();  
            in.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  
