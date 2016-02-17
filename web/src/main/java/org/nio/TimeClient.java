package org.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClient implements Runnable {
  public static final int port=1031;
  private volatile boolean stop;

  public static void main(String[] args) {
    new Thread(new TimeClient()).start();
  }
  @Override
  public void run() {
    SocketChannel client=null;
    try
    {
      SocketAddress socketAddress=new InetSocketAddress("localhost",port);
      client =SocketChannel.open(socketAddress);
      ByteBuffer buffer=ByteBuffer.allocate(1024);
      /*client.configureBlocking(false);
      Selector selector=Selector.open();
      client.register(selector, SelectionKey.OP_READ);*/
      WritableByteChannel out=Channels.newChannel(System.out);
      while(client.read(buffer)!=-1)
      {
        buffer.flip();
        out.write(buffer);
        buffer.clear();
      }
      
      /*while(true)
      {
        selector.select();
        Set<SelectionKey> keys=selector.keys();
        Iterator<SelectionKey> iterator=keys.iterator();
        while(iterator.hasNext())
        {
          SelectionKey key=iterator.next();
          if(key.isReadable())
          {
            ByteBuffer bytes=ByteBuffer.allocate(1024);
            SocketChannel channel=(SocketChannel)key.channel();
            channel.read(bytes);
            if(bytes.hasRemaining())
            {
              bytes.flip();
              System.out.println(bytes.array().toString());
              bytes.clear();
            }
          }
        }
        
      }*/
    }
    catch(Exception e)
    {
      try {
        if(client!=null)
        {
          client.close();
        }
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      e.printStackTrace();
    }
    
  }

}
