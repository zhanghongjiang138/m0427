package org.BASE64;

import java.util.List;
import java.util.Map;

public class Component {
  private float width;
  private float height;
  private Object model;
  List<Map> columnMaps; List<Map<String,Object>> dataList;
  
  /** 
  * @return width
  */
  public float getWidth() {
    return width;
  }
  /** 
  * @param width 要设置的 width
  */
  public void setWidth(float width) {
    this.width = width;
  }
  /** 
  * @return height
  */
  public float getHeight() {
    return height;
  }
  /** 
  * @param height 要设置的 height
  */
  public void setHeight(float height) {
    this.height = height;
  }
  
}
