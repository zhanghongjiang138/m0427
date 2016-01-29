package org.threadpool;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
  private static int length=10000000;
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    
    long start0=System.currentTimeMillis();
    double[] arr=new double[length];
   
    long start1=System.currentTimeMillis();
    ExecutorService pool=Executors.newFixedThreadPool(2);
    InnerThread i1=new InnerThread(arr,0,(int)length/2);
    InnerThread i2=new InnerThread(arr,(int)length/2,length);
    Future<Double> f1=pool.submit(i1);
    Future<Double> f2=pool.submit(i2);
    pool.submit(i1);
    pool.submit(i2);
    double max1=f1.get()+f2.get();
    long end1=System.currentTimeMillis();
    double max2=getRandom(arr,0,length);
    long end2=System.currentTimeMillis();
    System.out.println(start1-start0);
    System.out.println(end1-start1);
    System.out.println(end2-end1);
    System.exit(0);
  }
  public static double getMax(double[] arr, int start,int end) {
    double max=arr[start];
    for(int i=start+1;i<end;i++)
    {
      if(arr[i]>max)
      {
        max=arr[i];
      }
    }
    return max;
  }
  
  public static double getRandom(double[] arr, int start,int end) {
    double max=arr[start];
    for(int i=start+1;i<end;i++)
    {
      arr[i]=Math.random();
    }
    return max;
  }
  


}
