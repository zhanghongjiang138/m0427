package org.BASE64;

public enum ExcelLayout 
{
  
  VERTICAL("vertical"),
  
  HORIZONTAL("horizontal");
  
  private String value;
  private ExcelLayout(String code)
  {
    this.value = code;
  }

  public String getValue()
  {
    return value;
  }

}