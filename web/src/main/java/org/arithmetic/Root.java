package org.arithmetic;

import java.util.ArrayList;
import java.util.List;

class Root {
  int value;
  Root lChild;
  Root rChild;
  Root(int value)
  {
    this.value=value;
  }
  
  private static List<Integer> list=new ArrayList<Integer>();
  //深度遍历 Depth-first search
  public  static void traverse(Root root)
  {
    list.add(root.value);//先序遍历
    if(root.lChild!=null)
    {
      traverse(root.lChild);
    }
    //list.add(root.value);//中序遍历
    if(root.rChild!=null)
    {
      traverse(root.rChild);
    }
    //list.add(root.value);//后序遍历
  }
  public static Root createExampleTree()
  {
    Root t=new Root(1);
    Root tl1=new Root(2);
    Root tr1=new Root(3);
    Root tl2=new Root(4);
    Root tr2=new Root(5);
    Root tl3=new Root(6);
    Root tr2l=new Root(7);
    Root tr2r=new Root(8);
    
    t.lChild=tl1;
    t.rChild=tr1;
    tl1.lChild=tl2;
    tl1.rChild=tr2;
    tl2.lChild=tl3;
    tr2.lChild=tr2l;
    tr2.rChild=tr2r;
    
    return t;
  }
  public static void main(String[] args)
  {
    
    traverse(createExampleTree());

    for(Integer i:list)
    {
      System.out.println(i);
    }
    
  }

}


