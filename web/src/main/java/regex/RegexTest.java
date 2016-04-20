/**   
 * Copyright © 2016 NetEase. All rights reserved.
 * 
 * @Title: RegexTest.java 
 * @Prject: web
 * @Package: regex 
 * @Description: TODO
 * @author: hzzhanghongjiang   
 * @date: 2016年4月14日 下午7:10:22 
 * @version: V1.0   
 */
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @ClassName: RegexTest 
 * @Description: TODO
 * @author: hzzhanghongjiang
 * @date: 2016年4月14日 下午7:10:22  
 */
public class RegexTest {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		
		String queryResult="CN=hzheqi,OU=信息技术部,OU=正式员工,DC=网易杭州,DC=hz,DC=ntes,DC=domain";
		String cmd="dsmod 成功:CN=leihuo,OU=测试,OU=网易杭州,DC=hz,DC=ntes,DC=domain";
		Pattern p1=Pattern.compile("CN=(.+),OU=(.+),OU=(.+),DC=(.+),DC=(.+),DC=(.+),DC=(.+)"); 
		Pattern p2=Pattern.compile("dsmod 成功");
		Matcher m1=p1.matcher(queryResult);
		if(m1.find())
		{
			for(int i=1;i<m1.groupCount();i++)
			{
				String g=m1.group(i);
				System.out.println(g);
			}
		}
		if(p2.matcher(cmd).find())
		{
			System.out.println("修改成功");

		}
	}

}
