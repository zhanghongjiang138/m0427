package org.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class FileChannelTest {
  
  static void bufferedReaderFile(String filePath) throws IOException{
    File file=new File(filePath);
    System.out.print(file.exists());
    BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
    String line="";
    while((line=reader.readLine())!=null)
    {
      System.out.println(line);
    }
  }
  
  static void channelFile(String filePath) throws IOException{
    RandomAccessFile file=null;
    file =new RandomAccessFile (new File(filePath), "rw");
    FileChannel channel=file.getChannel();//FileChannel不能切换到非阻塞模式
    ByteBuffer buffer=ByteBuffer.allocate(88);
    int byteReads=channel.read(buffer);
    StringBuilder sb=new StringBuilder(1000000);
    while(byteReads!=-1)
    {
      buffer.flip();
      while(buffer.hasRemaining())
      {
        sb.append((char)buffer.get());
      }
      buffer.clear();
      //buffer.compact();压缩缓冲区
      byteReads=channel.read(buffer);
    }
    file.close();
    System.out.print(sb.toString());
  }

  public static void main(String[] args) throws IOException {
    String filePath="C:\\Users\\zhanghongjiang\\Desktop\\file\\URL.txt";

    //bufferedReaderFile(filePath);
    channelFile(filePath);
    InetSocketAddress a;
    InetAddress b;
    SocketChannel c;//SocketChannel的读写操作都是异步的，如果没有可读写的数据它不会同步等待，直接返回，这样IO通信线程就可以处理其它的链路，不需要同步等待这个链路可用；
  }

}
