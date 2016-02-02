package org.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//广度优先遍历，也叫 层次遍历
public class BreadthFirstSearch {
  private static Queue<Root> queue=new LinkedList<Root>();
  
  private static List<Integer> list=new ArrayList<Integer>();
  
  public  static void   traverse(Root root)
  {
    while(queue.peek()!=null)
    {
      list.add(queue.poll().value);
    }
    
    if(root.lChild!=null)
    {
      queue.add(root.lChild);
    }
    if(root.rChild!=null)
    {
      queue.add(root.rChild);
    }
    
    if(root.lChild!=null)
    {
      traverse(root.lChild);
    }
    if(root.rChild!=null)
    {
      traverse(root.rChild);
    }
  }
  
  public static void main(String[] args) {
    Root t=Root.createExampleTree();
    queue.add(t);
    traverse(t);
    for(Integer value:list)
    {
      System.out.println(value);
    }
  }

}
