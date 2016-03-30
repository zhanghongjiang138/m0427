package org.BASE64;

public class Point {
  private int row=0;  
  
  private int col=0;
  

  public Point(int row, int col) {
    this.row=row;
    this.col=col;
  }
  /** 
  * @return row
  */
  public int getRow() {
    return row;
  }
  /** 
  * @param row 要设置的 row
  */
  public void setRow(int row) {
    this.row = row;
  }
  /** 
  * @return col
  */
  public int getCol() {
    return col;
  }
  /** 
  * @param col 要设置的 col
  */
  public void setCol(int col) {
    this.col = col;
  }
  
  
  
}
