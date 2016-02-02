package org.swing.toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Stack;

public class DBConnection {
  
  private static final String DRIVERNAME="oracle.jdbc.driver.OracleDriver";  
  private static final String URL="jdbc:oracle:thin:@10.86.87.135:1521:srm";  //test为数据库名称，1521为连接数据库的默认端口  
  private static final String USER="ime2";  
  private static final String PASSWORD="geelyime2";  
    
  private static final int CONNECTINOSIZE=3; 
  
  
  private static Stack<Connection> conn = new Stack<Connection>();
  
  static{
    
    try {
      Class.forName(DRIVERNAME);
      for(int i=0;i<CONNECTINOSIZE;i++)
      {
        conn.push(DriverManager.getConnection(URL, USER, PASSWORD));  
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }  
    
  }
    
  static Connection getConnection()
  {
    if(conn.isEmpty())
    {
      try {  
        conn.push(DriverManager.getConnection(URL, USER, PASSWORD));  
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    return conn.pop();
   
  }
  
  public static String execute(Connection con,String sql,String...params) throws SQLException
  {
    PreparedStatement pstmt = null;  
    ResultSet rs = null;
    StringBuilder sb=new StringBuilder();
    try 
    {
        pstmt = con.prepareStatement(sql);  
        
        if(params!=null&&params.length>0)
        {
          for(int i=0;i<params.length;i++)
          {
            pstmt.setString(i+1, params[i]);  
          }
        }
        pstmt.execute(); 
        
    } 
    catch (SQLException e) 
    {  
          e.printStackTrace();  
    }
    finally
    {  
      if(rs != null){  
          rs.close();  
      }  
      if(pstmt != null){  
          pstmt.close();  
      }  
    }
    conn.push(con);
    
    return new String(sb);
  }
  
  public static String executeQuery(Connection con,String sql,String...params) throws SQLException
  {
    PreparedStatement pstmt = null;  
    ResultSet rs = null;
    StringBuilder sb=new StringBuilder();
    try 
    {
        pstmt = con.prepareStatement(sql);  
        
        if(params!=null&&params.length>0)
        {
          for(int i=0;i<params.length;i++)
          {
            pstmt.setString(i+1, params[i]);  
          }
        }
        rs=pstmt.executeQuery(); 
        while(rs.next())
        {
          sb.append(rs.getInt(1));
        }
        
    } 
    catch (SQLException e) 
    {  
          e.printStackTrace();  
    }
    finally
    {  
      if(rs != null){  
          rs.close();  
      }  
      if(pstmt != null){  
          pstmt.close();  
      }  
    }
    conn.push(con);
    
    return new String(sb);
  }

  public static void main(String[] args) {
    Connection con=getConnection();
    String sql="select * from test";
    ThreadLocal a;
    try {
      String str=DBConnection.execute(con, sql);
      System.out.println(str);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    conn.push(con);

  }

}
