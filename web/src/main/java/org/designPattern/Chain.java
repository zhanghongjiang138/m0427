package org.designPattern;

import java.util.Date;

public class Chain implements FilterChain {
  private FilterChain chain; 
  @Override
  public FilterChain getChain() {
    return this.chain;
  }
  @Override
  public void setChain(FilterChain chain) {
    this.chain=chain;
  }

  @Override
  public void doFilter() { //传参若为 httprequest ，httpresponse 模拟web filterchain 
    if(this.getChain()==null)
    {
      System.out.println("处理请求");
    }
    else
    {
      System.out.println("放过请求");
      chain.doFilter();
      System.out.println("放过请求后");
    }
  }
  public static void main(String[] args) {
    FilterChain chain1=new Chain();
    FilterChain chain2=new Chain();
    chain1.setChain(chain2);
    chain1.doFilter();
  }


}
