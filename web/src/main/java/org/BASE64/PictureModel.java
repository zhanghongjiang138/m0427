package org.BASE64;

/**
 * 
 * <strong>Title : PicModel.java<br></strong>
 * <strong>Package : org.BASE64<br></strong>
 * <strong>Description : </strong>图片模型，计算该图片占据了多少行多少列<br> 
 * <strong>Create on : 2016年3月22日 上午10:08:38<br></strong>
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
public class PictureModel implements Model{
  //一英寸=72磅=25.4毫米=1440缇
  //一磅=0.353毫米=20缇
  //excel行高单位为磅
  private float dpi=96f;//dpi：一英寸可显示的像素点个数  通常电脑 dpi=96
  private float width;//图片宽度（像素）
  private float height;//图片高度（像素）
  
  private Excel excel;
  public PictureModel(float width,float height)
  {
    this.width=width;
    this.height=height;
  }
  
 /**
  * 
  * <strong>Title : getColCount<br></strong>
  * <strong>Description : </strong>计算该图片占据了多少列<br> 
  * <strong>Create on : 2016年3月22日 上午10:10:54<br></strong>
  * <p>
  * @param characters 列宽，单位：字符数
  * @return
  * float
  * @throws 
  * @author zhanghongjiang<br>
  * @version <strong>v1.0.0</strong><br>
  * <br>
  * <strong>修改历史:</strong><br>
  * 修改人	|	修改日期	|	修改描述<br>
  * -------------------------------------------<br>
  * <br>
  * <br>
  */
  public float getColCount(int characters)
  {
    //列像素=5+（字符个数*7）
    return  this.width/(5+7*characters);
  }
  
  /**
   * 
   * <strong>Title : getRowCount<br></strong>
   * <strong>Description : </strong>计算该图片占据了多少行<br> 
   * <strong>Create on : 2016年3月22日 上午10:10:14<br></strong>
   * <p>
   * @param rowHeight 行高，单位：磅
   * @return
   * float
   * @throws 
   * @author zhanghongjiang<br>
   * @version <strong>v1.0.0</strong><br>
   * <br>
   * <strong>修改历史:</strong><br>
   * 修改人	|	修改日期	|	修改描述<br>
   * -------------------------------------------<br>
   * <br>
   * <br>
   */
  public float getRowCount(int rowHeight)
  {
    float twips=this.height/dpi*72; //占据多少磅
    return twips/rowHeight;
  }


  /** 
  * @return dpi
  */
  public float getDpi() {
    return dpi;
  }


  /** 
  * @param dpi 要设置的 dpi
  */
  public void setDpi(float dpi) {
    this.dpi = dpi;
  }


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


  @Override
  public String type() {
    return Model.PICTURE;
  }

 
  @Override
  public void setExcel(Excel excel) {
    this.excel=excel;
    
  }



@Override
public void insert(Point start) {
	// TODO Auto-generated method stub
	
}
  
  

  
 

}
