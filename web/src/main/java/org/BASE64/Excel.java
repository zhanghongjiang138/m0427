package org.BASE64;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

public class Excel {
  
  private HSSFWorkbook workwork;
  private Sheet sheet;
  public Excel(HSSFWorkbook workwork,Sheet sheet)
  {
    this.workwork=workwork;
    this.sheet=sheet;
  }
  
  //记录两个坐标 左上角(col0,row0)，右下角(col1,row1)
  private int row0=0;  
  private int col0=0;  
  private int row1=0;
  private int col1=0;
  private int  defaultDir=-1;
  
  public void setDir(int dir)
  {
    this.defaultDir=dir;
  }
  
  public void add(Model m)
  {
    this.add(m, defaultDir);
  }
 
  public void add(Model m,int dir)
  {
    if(dir == 1)
    {
      addToRight(m);
    }
    else if (dir == -1)
    {
      addToBelow(m);
    }
  }
  
  private void addToBelow(Model m) {
    addModel(m,new Point(col1+1,row0));
  }

  public void addToRight(Model m)
  {
    addModel(m,new Point(col0,row1+1));
  }
  
  public void addModel(Model m,Point start)
  {
     m.setExcel(this);
     m.insert(start);
  }

  /** 
  * @return workwork
  */
  public HSSFWorkbook getWorkwork() {
    return workwork;
  }

  /** 
  * @param workwork 要设置的 workwork
  */
  public void setWorkwork(HSSFWorkbook workwork) {
    this.workwork = workwork;
  }

  /** 
  * @return sheet
  */
  public Sheet getSheet() {
    return sheet;
  }

  /** 
  * @param sheet 要设置的 sheet
  */
  public void setSheet(Sheet sheet) {
    this.sheet = sheet;
  }

  /** 
  * @return row0
  */
  public int getRow0() {
    return row0;
  }

  /** 
  * @param row0 要设置的 row0
  */
  public void setRow0(int row0) {
    this.row0 = row0;
  }

  /** 
  * @return col0
  */
  public int getCol0() {
    return col0;
  }

  /** 
  * @param col0 要设置的 col0
  */
  public void setCol0(int col0) {
    this.col0 = col0;
  }

  /** 
  * @return row1
  */
  public int getRow1() {
    return row1;
  }

  /** 
  * @param row1 要设置的 row1
  */
  public void setRow1(int row1) {
    this.row1 = row1;
  }

  /** 
  * @return col1
  */
  public int getCol1() {
    return col1;
  }

  /** 
  * @param col1 要设置的 col1
  */
  public void setCol1(int col1) {
    this.col1 = col1;
  }

  /** 
  * @return defaultDir
  */
  public int getDefaultDir() {
    return defaultDir;
  }

  /** 
  * @param defaultDir 要设置的 defaultDir
  */
  public void setDefaultDir(int defaultDir) {
    this.defaultDir = defaultDir;
  }
  
  
  
  
}
