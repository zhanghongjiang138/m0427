package org.structure;

public class Heap {
  
  static void minHeapFixup(int[] a,int i)
  {
    int j=(i-1)/2; //父节点数组位置
    int temp;
    while(a[j]>a[i]&&j>=0)
    {
      temp=a[j];
      a[j]=a[i];
      a[i]=temp;
      i=j;
      j=(i-1)/2;
    }
  }
  
  //表示第i个节点，数组大小为n
  static void minHeapFixdown(int[] a,int i,int n)
  {
    int temp=a[i];
    int j=2*i+1;
    while(j<n-1)
    {
      if(j+1<n-1&&a[j+1]<a[j])//取左右子树较小数与根节点比较
        j++;
      
      if(a[i]<a[j])
      {
        break;
      }
      else
      {
        a[j]=a[i];
        i=j;
        j=2*i+1;
      }
    }
    a[i]=temp;
  }
  
  public static void swap(int[]a ,int i, int j)
  {
    int temp=a[i];
    a[i]=a[j];
    a[j]=temp;
  }

  public static void main(String[] args) {
      int[] org={1,5,9,21,15,10,3,8,44,98,24};//原始数据
      int[] a=new int[10]; //构造数量为10的最小堆
      a[0]=org[0];
      for(int i=1;i<org.length;i++)
      {
        if(i<a.length)
        {
          a[i]=org[i];
          minHeapFixup(a,i);
        }
        else
        {
          if(org[i]>a[0])
          {
            a[0]=org[i];
            swap(a,0,a.length-1);
            minHeapFixdown(a,0,a.length);
          }
        }
      }
      for(int x:a)
      {
        System.out.print(x+" ");
      }
  }

}
