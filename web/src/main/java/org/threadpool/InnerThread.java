package org.threadpool;
import java.util.concurrent.Callable;

public  class InnerThread implements Callable<Double>{
    private int start;
    private int end;
    private double[] arr;
    public InnerThread(double[] arr,int start,int end)
    {
      this.arr=arr;
      this.start=start;
      this.end=end;
    }
    @Override
    public Double call() throws Exception {
      return ThreadTest.getRandom(arr, start, end);
    }


    
  }