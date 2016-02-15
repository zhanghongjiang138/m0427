package org.nio;

public class SocketChannelTest {

  public static void main(String[] args) {
    TimeClientHandler handler=new TimeClientHandler(null,0);
    new Thread(handler).start();
  }
}
