/**
 * <strong>Title : gridModel.java<br></strong>
 * <strong>Package : org.BASE64<br></strong>
 * <strong>Description : </strong>TODO@类注释说明写在此处@<br> 
 * <strong>Create on : 2016年3月22日 下午12:56:39<br></strong>
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
package org.BASE64;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * <strong>Title : gridModel.java<br></strong>
 * <strong>Package : org.BASE64<br></strong>
 * <strong>Description : </strong>数据表格模型<br> 
 * <strong>Create on : 2016年3月22日 下午12:56:39<br></strong>
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
public class gridModel implements Model{
  
  //表头映射
  private List<Map> columnMaps; 
  
  //数据列表
  private List<Map<String,Object>> dataList;
  
  private Excel excel;
  
  /** 
  * @return columnMaps
  */
  public List<Map> getColumnMaps() {
    return columnMaps;
  }
  /** 
  * @param columnMaps 要设置的 columnMaps
  */
  public void setColumnMaps(List<Map> columnMaps) {
    this.columnMaps = columnMaps;
  }
  /** 
  * @return dataList
  */
  public List<Map<String, Object>> getDataList() {
    return dataList;
  }
  /** 
  * @param dataList 要设置的 dataList
  */
  public void setDataList(List<Map<String, Object>> dataList) {
    this.dataList = dataList;
  }

  @Override
  public String type() {
    return Model.GRID;
  }

  @Override
  public void setExcel(Excel excel) {
    this.excel=excel;
  }

  @Override
  public void insert(Point start) {
    
    HSSFWorkbook workBook=excel.getWorkwork();
    Sheet sheet=excel.getSheet();
    Row row = null;
    CellStyle cs = workBook.createCellStyle();
    cs.setAlignment((short) 0x2);

    String fields[] = new String[columnMaps.size()];
    
    int colIndex = 0;
    row = sheet.createRow(start.getRow()+1);
    //表头
    for (Map<String,Object> map : columnMaps) {
      Cell cell = row.createCell(colIndex);
      cell.setCellValue(map.get("").toString());
      String ss=map.get(COLUMN_WIDTH).toString();
      sheet.setColumnWidth(colIndex, COLUMN_WIDTH_FACTOR*Float.valueOf(ss).intValue());
      fields[colIndex]=map.get(COLUMN_NAME).toString();
      colIndex++;
    }

    //表内容
    for (Map<String,Object> model : dataList) {
      row = sheet.createRow(++rownum);

      for (colIndex = 0; colIndex < fields.length; colIndex++) {
            Cell cell = row.createCell(colIndex);
            Object value = model.get(fields[colIndex].toUpperCase());
            setCellValue(cell, value);
      }
    }
  }
  
}
