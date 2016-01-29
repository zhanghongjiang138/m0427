/**
 * <strong>Title : Matcher.java<br></strong>
 * <strong>Package : com<br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年1月25日 下午2:19:07<br></strong>
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatcherPattern {
  
  public static void main(String[] args) {
    String str="154 asdf4trew34gf";
    String regex="[0-9]";
    String regex1="4";
    Pattern p =Pattern.compile(regex);
    Pattern p1 =Pattern.compile(regex1);
    Matcher m=p.matcher(str);
    String[] arr=p1.split(str);
    /*for(String s:arr){
      
      System.out.println(s);
    }*/
    while(m.find())
    {
      System.out.println(m.start());
      System.out.println(m.group());
      System.out.println(m.groupCount());
      System.out.println(m.end());
    }
   }

}
