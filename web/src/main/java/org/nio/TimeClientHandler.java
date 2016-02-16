package org.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TimeClientHandler implements Runnable {
  private String host;
  private int port;
  private SocketChannel socketChannel;
  private Selector selector;
  private volatile boolean stop;
  
  public TimeClientHandler(String host,int port)
  {
    this.host=(host==null?"127.0.0.1":host);
    this.port=port;
    stop=false;
    try
    {
      selector = Selector.open();
      socketChannel=SocketChannel.open();
      socketChannel.configureBlocking(false);
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    AtomicInteger a;
  }
  @Override
  public void run() {
    try
    {
      doConnect();
      while(!this.stop)
      {
        this.selector.select(1000);
        Set<SelectionKey> keys=selector.keys();
        Iterator<SelectionKey> iterator=keys.iterator();
        SelectionKey key=null;
        while(iterator.hasNext())
        {
          key=iterator.next();
          try
          {
            handleInput(key);
          }
          catch(Exception e)
          {
            key.cancel();
            if(key.channel()!=null)
            {
              key.channel().close();
            }
          }
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  private void handleInput(SelectionKey key) throws IOException {
    if(key.isValid())
    {
      SocketChannel channel=(SocketChannel)key.channel();
      if(key.isConnectable())
      {
        if(channel.finishConnect())
        {
          channel.register(this.selector, SelectionKey.OP_READ);
          doWrite(channel);
        }
        else
        {
          System.exit(1);
        }
        if(key.isReadable())
        {
          ByteBuffer bf=ByteBuffer.allocate(1024);
          int readBytes=channel.read(bf);
          if(readBytes>0)
          {
            byte[] bytes=new byte[readBytes];
            bf.flip();
            bf.get(bytes);
            System.out.println(new String(bytes,"utf-8"));
            this.stop=true;
          }
          else if(readBytes<0)
          {
            key.cancel();
            channel.close();
          }
          else
          {
            ;
          }
        }
      }
       
      
    }
    
    
  }

  private void doConnect() throws IOException {
    if(socketChannel.connect(new InetSocketAddress(this.host,this.port)))
    {
      socketChannel.register(this.selector, SelectionKey.OP_READ);
      doWrite(socketChannel);
    }
    else
    {
      socketChannel.register(this.selector, SelectionKey.OP_CONNECT);
    }
  }

  private void doWrite(SocketChannel socketChannel) throws IOException {
    ByteBuffer buffer=ByteBuffer.allocate(1024);
    buffer.put(new String("hello").getBytes("utf-8"));
    buffer.flip();
    socketChannel.write(buffer);
  }

}
