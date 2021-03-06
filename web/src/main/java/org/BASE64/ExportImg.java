package org.BASE64;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;

import com.alibaba.druid.pool.GetConnectionTimeoutException;

public class ExportImg extends JFrame{
  
  public ExportImg()
  {
    Container c=getContentPane();
    c.setLayout(new FlowLayout());
    c.add(new JButton());
  }
  
  private static final String imgData ="data:image/png;base64,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";
  public static void main(String[] args) throws FileNotFoundException {
    
 
    String encodingPrefix = "base64,";
    int contentStartIndex = imgData.indexOf(encodingPrefix) + encodingPrefix.length();
    byte[] buffer = Base64.decodeBase64(imgData.substring(contentStartIndex));
    FileOutputStream out=new FileOutputStream(new File("C:\\Users\\zhanghongjiang\\Desktop\\excel.xls"));
    BufferedImage bufferImg = null;     
   //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray    
   try {  
       ByteArrayInputStream byteArrayIn=new ByteArrayInputStream(buffer);
       ByteArrayOutputStream byteArrayOut=new ByteArrayOutputStream();
       bufferImg = ImageIO.read(byteArrayIn);     
       ImageIO.write(bufferImg, "png", byteArrayOut);  
         
       HSSFWorkbook wb = new HSSFWorkbook();     
       HSSFSheet sheet1 = wb.createSheet("test picture");    
  /*     sheet1.setColumnWidth(0, 8*256);*/
       //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）  
       HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();     
       //anchor主要用于设置图片的属性  
       HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 1, 2, (short) 101, 10);     
       HSSFClientAnchor anchor1 = new HSSFClientAnchor(0, 0, 0, 0,(short) 10, 20, (short) 101, 10);     
       anchor.setAnchorType(0);     
       //插入图片    
       HSSFPicture picture=patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));   
       HSSFPicture picture1=patriarch.createPicture(anchor1, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));   
       double width=picture.getImageDimension().getWidth();
       double height=picture.getImageDimension().getHeight();
       System.out.println(width);
       System.out.println(height);
       picture.resize();
       picture1.resize();
       
       System.out.println("--------------------------");
       System.out.println(anchor.getDx1());
       System.out.println(anchor.getDy1());
       System.out.println(anchor.getDx2());
       System.out.println(anchor.getDy2());
       System.out.println(anchor.getCol1());
       System.out.println(anchor.getRow1());
       System.out.println(anchor.getCol2());
       System.out.println(anchor.getRow2());
       System.out.println("--------------------------");
       System.out.println(anchor1.getDx1());
       System.out.println(anchor1.getDy1());
       System.out.println(anchor1.getDx2());
       System.out.println(anchor1.getDy2());
       System.out.println(anchor1.getCol1());
       System.out.println(anchor1.getRow1());
       System.out.println(anchor1.getCol2());
       System.out.println(anchor1.getRow2());
       System.out.println("--------------------------");

       HSSFRow row=sheet1.createRow(1);
       System.out.println(sheet1.getColumnWidth(0)/256);//列宽
       System.out.println(row.getHeight()/20); //行高
       //一英寸=72磅=25.4毫米=1440缇
       //一磅=0.353毫米=20缇
       //excel行高单位为磅
       //dpi：一英寸可显示的像素点个数  通常电脑 dpi=96
       float pix=500;
       float dpi=96f;
       float pounds=pix/dpi*72; //占据多少磅
       float twips=pix/dpi*1440; //占据多少缇
       float rowCount=twips/row.getHeight();
       System.out.println("缇"+row.getHeight()); //占据多少缇
       System.out.println(rowCount); //占据多少行
       //列像素=5+（字符个数*7）
       float colCount=450/(5+7*8);
       System.out.println(colCount); //占据多少列
       wb.write(out);
        
        
        

   }
   catch(Exception e)
   {
     e.printStackTrace();
   }
   
  }
  
  
  
  

}
