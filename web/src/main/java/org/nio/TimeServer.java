package org.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeServer {
  
  public static void startServer(int port) {
    ServerSocketChannel channel=null;
    Selector selector = null;
    try {
      channel=ServerSocketChannel.open();
      ServerSocket serverSocket=channel.socket();
      serverSocket.bind(new InetSocketAddress(port));
      channel.configureBlocking(false);
      selector=Selector.open();
      channel.register(selector, SelectionKey.OP_ACCEPT);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    
    while(true)
    {
      try{
        selector.select();
      }
      catch(Exception e)
      {
        e.printStackTrace();
        break;
      }
      
      Set<SelectionKey> keys=selector.keys();
      Iterator<SelectionKey> iterator=keys.iterator();
      while(iterator.hasNext())
      {
        SelectionKey key=iterator.next();
        
        try {
          if(key.isAcceptable())
          {
            ServerSocketChannel serverChannel=(ServerSocketChannel) key.channel();
            SocketChannel client=serverChannel.accept();
            System.out.println("accepting connection from server :"+client);
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
            System.out.println("Accepted new connection from client: " + client);
          }
          else if (key.isReadable())
          {
            // Read the data from client
            SocketChannel client = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(256);
            client.read(buffer);
            String output = new String(buffer.array()).trim();
            System.out.println("Message read from client: " + output);
            if (output.equals("Bye.")) {
                client.close();
                System.out.println("Client messages are complete; close.");
            }
          }
          iterator.remove();
         } catch (IOException e) {
           key.cancel();//请求取消此键的通道到其选择器的注册
           if(key.channel()!=null)
           {
             try 
             {
               key.channel().close();
             } catch (IOException e1) 
             {
               e1.printStackTrace();
             }
           }
         }
        }
      }
      
    }
  
  
  public static void main(String[] args) {
    TimeServer.startServer(TimeClient.port);
  }

}
