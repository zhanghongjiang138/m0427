

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JKit extends JFrame {
  private int winX=800;
  private int winY=600;
  
  public JKit()
  {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c=getContentPane();
   
    /*Box b1=Box.createHorizontalBox();
    for(int i=0;i<5;i++)
    {
      b1.add(new JButton("b1"+i));
      b1.add(Box.createHorizontalStrut(5*i));
    }
    Box b2=Box.createVerticalBox();
    for(int i=0;i<5;i++)
    {
      b2.add(new JButton("b2"+i));
      b2.add(Box.createVerticalStrut(5*i));
    }
    c.add(BorderLayout.CENTER,b1);
    c.add(BorderLayout.CENTER,b2);
    */
    MyPanel my=new MyPanel();
 
    new Thread(my).start();
    add(my);
    addKeyListener(my);
    setSize(winX, winY);
    setVisible(true);
  }
  
  public static void main(String[] args) {
    JKit kit=new JKit();
  }
  
 public class MyPanel extends JPanel implements KeyListener ,Runnable{
    int width=20;
    int height=20;
    int x=0;
    int y=1;
    List<Point> list=new LinkedList<Point>();
    int headX=20;
    int headY=60;
    Point head=new Point(headX,headY);

    Point food=new Point(120,120);
    int speed;
    
    Color[] colors={Color.RED,Color.ORANGE,Color.YELLOW,Color.BLUE,Color.GREEN};
    MyPanel(){
      speed=500;
      list.add(new Point(headX,headY-height));
    }
    
    public void paint(Graphics g){
      super.paint(g);
      g.setColor(Color.RED);
      g.fillRect(head.x+=x*width,head.y+=y*height,width,height);
      
      list.remove(list.size()-1);
      for(Point p:list)
      {
          g.setColor(Color.BLUE);
          g.fillRect(p.x,p.y,width,height);
      }
      g.setColor(Color.GREEN);
      g.fillRect(food.x,food.y,width,height);
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
      
    }
    @Override
    public void keyPressed(KeyEvent e) {
      int dir=e.getKeyCode();
      Point pp=new Point(head.x,head.y);
      if(dir == KeyEvent.VK_LEFT)
      {
        x=-1;
        y=0;
      }
      if(dir == KeyEvent.VK_RIGHT)
      {
        x=1;
        y=0;
      }
      if(dir == KeyEvent.VK_UP)
      {
        x=0;
        y=-1;
      }
      if(dir == KeyEvent.VK_DOWN)
      {
        x=0;
        y=1;
      }
      list.add(0,pp);
      if(pp.x==food.x&&pp.y==food.y)
      {
        list.add(0,food);
        repaint();
        int i = Math.abs(new Random().nextInt(20))*width;
        int j = Math.abs(new Random().nextInt(20))*height;
        food=new Point(i,j);
      }
      repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
      
    }
    
    public  synchronized void run(){
      while(true){
        try{Thread.sleep(speed);
        }catch(Exception e){}

          if(food.x==head.x&&food.y==head.y)
          {
            list.add(food);
            int i = Math.abs(new Random().nextInt(20))*width;
            int j = Math.abs(new Random().nextInt(20))*height;
            food=new Point(i,j);
          }
          if(x==0&&y==-1) keyPressed(new KeyEvent(this,0,0,0,KeyEvent.VK_UP));
          else if(x==0&&y==1) keyPressed(new KeyEvent(this,0,0,0,KeyEvent.VK_DOWN));
          else if(x==-1&&y==0) keyPressed(new KeyEvent(this,0,0,0,KeyEvent.VK_LEFT));
          else if(x==1&&y==0) keyPressed(new KeyEvent(this,0,0,0,KeyEvent.VK_RIGHT));
     }
   }
  }
 
 
 class Point{
   int x;
   int y;
   public Point(int x,int y)
   {
     this.x=x;
     this.y=y;
   }
   
 }
 
 class Snake{
   Point head;
   List<Point> body=new LinkedList<Point>();
   public Snake(Point h)
   {
     this.head=h;
   }
   
 }

}
