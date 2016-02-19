package org.designPattern;

public interface FilterChain {
    public void doFilter();
    
    public FilterChain getChain();
    /** 
    * @param chain 要设置的 chain
    */
    public void setChain(FilterChain chain);
}