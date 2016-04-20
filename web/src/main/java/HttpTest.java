/**
 * <strong>Title : HttpTest.java<br></strong>
 * <strong>Package : <br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月6日 下午4:44:42<br></strong>
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

/**
 * <strong>Title : HttpTest.java<br></strong>
 * <strong>Package : <br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月6日 下午4:44:42<br></strong>
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
public class HttpTest {

  public static void main(String[] args) {  
    try {       
        HttpRequester request = new HttpRequester();  
        request.setDefaultContentEncoding("utf-8");  
        String url="http://127.0.0.1:8088/ime/manage/index#QUALITY_MONTHREPORT";
        	
        /*HttpRespons hr = request.sendGet(url);       
    
        System.out.println(hr.getUrlString());       
        System.out.println(hr.getProtocol());       
        System.out.println(hr.getHost());       
        System.out.println(hr.getPort());       
        System.out.println(hr.getContentEncoding());       
        System.out.println(hr.getMethod());       */
        System.out.println(url.substring(url.length()-4));       
               
    
    } catch (Exception e) {       
        e.printStackTrace();       
    }   
}  

}
