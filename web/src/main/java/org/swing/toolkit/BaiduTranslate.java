/**
 * <strong>Title : BaiduTranslate.java<br></strong>
 * <strong>Package : com<br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月25日 上午9:56:53<br></strong>
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
package org.swing.toolkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.net.www.http.HttpClient;

public class BaiduTranslate {
  
  private static final String httpHeader="http://api.fanyi.baidu.com/api/trans/vip/translate";
  private static final String sign="YAt7cGhZM7rWMccPZKFl";
  private static final String appid="20160125000009299";
  
  
//  http://api.fanyi.baidu.com/api/trans/vip/translate?q=apple&from=en&to=zh&appid=2015063000000001&salt=1435660288&sign=f89f9594663708c1605f3d736d01d2d4

  public static String translate(String from,String to,String query) throws NoSuchAlgorithmException, IOException
  {
    int salt=(int)(Math.random()*100000);
    String s=appid+query+salt+sign;
    MessageDigest md=MessageDigest.getInstance("md5");
    byte[] md5=md.digest(s.getBytes("utf-8"));
    String url=httpHeader+"?q="+query+"&from="+from+"&to="+to+ "&appid="+appid+"&salt="+salt+"&sign="+bytesToHexString(md5);
    return sendGetRequest(url);
  }
  
  public static String analysis(String result)
  {
    int start=result.indexOf("\"dst\":\"");
    int end=result.indexOf("\"}]}");
    return result.substring(start+7, end);
  }
  
  public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException, IOException {
    System.out.println(analysis(translate("zh","en","我的名字")));
  }
  
  public static String sendGetRequest(String reqURL) throws IOException{
    String path =reqURL;
    URL url =new URL(path);
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    conn.setConnectTimeout(5*1000);
    conn.setRequestMethod("GET");
    InputStream inStream = conn.getInputStream();    
    StringBuilder sb=new StringBuilder();
    BufferedReader reader=new BufferedReader(new InputStreamReader(inStream));
    String str="";
    while((str=reader.readLine())!=null)
    {
      sb.append(str);
    }
    return sb.toString();
  }
  
  public static String bytesToHexString(byte[] src){  
    StringBuilder stringBuilder = new StringBuilder("");  
    if (src == null || src.length <= 0) {  
        return null;  
    }  
    for (int i = 0; i < src.length; i++) {  
        int v = src[i] & 0xFF;  
        String hv = Integer.toHexString(v);  
        if (hv.length() < 2) {  
            stringBuilder.append(0);  
        }  
        stringBuilder.append(hv);  
    }  
    return stringBuilder.toString();  
}  

}
