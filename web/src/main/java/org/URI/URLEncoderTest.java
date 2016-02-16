package org.URI;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class URLEncoderTest {

  public static void main(String[] args) throws UnsupportedEncodingException, UnknownHostException {
    String URL="http://baidu.com";
    String str="aaa%+我";
    String encoder=URLEncoder.encode(str,"utf-8");
    System.out.println(encoder);
    System.out.println(URLDecoder.decode(encoder,"utf-8"));
    Double d;
    InetSocketAddress address=InetSocketAddress.createUnresolved(URL, 80);
    SocketAddress sa; 
    InetAddress ia=InetAddress.getLoopbackAddress();
    InetAddress ia1=InetAddress.getByName("baidu.com");
    byte[] bytes={112,21,31,2};
    InetAddress ia2=InetAddress.getByAddress(bytes);
    System.out.println(ia.getHostName()+"_"+ia.getCanonicalHostName());
    System.out.println(ia1.getHostName()+"_"+ia1.getCanonicalHostName());
    System.out.println(ia2.getHostName()+"_"+ia2.getCanonicalHostName());
  }

}
