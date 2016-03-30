package org.BASE64;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

public interface Model {
    public static final String GRID="grid";
    
    public static final String PICTURE="picture";
    
    public String type();
    
    public void setExcel(Excel excel);


    public void insert(Point start); 

}
