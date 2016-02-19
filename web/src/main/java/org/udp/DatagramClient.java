package org.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;

public class DatagramClient implements Runnable {
  
  public static final int port=2048;
  
  public static final int byteLength=1024;
  
  public static final String defaultEncoding="utf-8";

  public static final AtomicInteger num=new AtomicInteger(0);
  
  public static void main(String[] args) throws IOException, InterruptedException {
    for(int i=0;i<2;i++)
    {
      new Thread(new DatagramClient()).start();
    }
  }

  @Override
  public void run() {
    byte[] sent;
    byte[] get=new byte[byteLength];
    DatagramSocket socket=null;
    try {
      while(true)
      {
        sent = ("client:"+num.addAndGet(1)).getBytes(defaultEncoding);
        DatagramPacket packetToSend=new DatagramPacket(sent, sent.length, InetAddress.getByName("localhost"),port );
        DatagramPacket packetToReceive=new DatagramPacket(get, get.length);
        socket=new DatagramSocket();
        socket.send(packetToSend);
        socket.receive(packetToReceive);
        if(packetToReceive.getLength()>0)
        {
          System.out.println("client receive:"+new String (packetToReceive.getData(),defaultEncoding));
        }
        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    
  }

}
