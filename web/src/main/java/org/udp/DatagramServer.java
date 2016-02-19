package org.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {

  public static void main(String[] args) throws IOException {
    int max=1000;
    int count=0;
    DatagramSocket socket=new DatagramSocket(DatagramClient.port);
    byte[] bytes=new byte[1024];
    DatagramPacket receivePacket=new DatagramPacket(bytes,bytes.length);
    while(true)
    {
      socket.receive(receivePacket);
      if(receivePacket.getLength()>0)
      {
        byte[] data=receivePacket.getData();
        String receiveFromClient=new String(data,"utf-8");
        System.out.println("server receives:"+receiveFromClient);
        
        byte[]  serverResponse=("server has got your message  "+receiveFromClient).getBytes(DatagramClient.defaultEncoding);
        DatagramPacket packetToSend=new DatagramPacket(serverResponse,serverResponse.length,receivePacket.getAddress(),receivePacket.getPort());
        socket.send(packetToSend);
        if(++count>max)
        {
          break;
        }
      }
    }
    socket.close();
  }

}
