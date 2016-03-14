
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Tetris extends JFrame {
  public Tetris()
  {
    Container c=getContentPane();
    LPanel lp=new LPanel();
    RPanel rp=new RPanel();
    
    c.add(lp);
    c.add(rp);
    c.setVisible(true);
    c.setSize(400, 450);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,450);
    addKeyListener(lp);
    new Thread(lp).start();
    setVisible(true);
  }
 

  public static void main(String[] args) {
    Tetris t=new Tetris();
  }
  
  class Pattern
  {
    int x=0,y=0;
    int[][] squires;
    Pattern(int[][] squires)
    {
      this.squires=squires;
    }

    Pattern(int[][] squires2, int x2, int y2) {
      this.squires=squires2;
      this.x=x2;
      this.y=y2;
    }
    void setSquires(int[][] s)
    {
      this.squires=s;
    }
  }
  
  
  class LPanel extends JPanel implements KeyListener,Runnable{
    int[][] a={
        {0,0,0},
        {1,0,0},
        {1,1,1}
    };
    int[][] a1={
        {1,1,1},
        {0,0,0},
        {0,0,0}
    };
    int[][] a2={
        {0,0,0},
        {0,1,0},
        {1,1,1}
    };
    int[][] a3={
        {0,0,0},
        {0,1,1},
        {0,1,1}
    };
    int[][] a4={
        {0,0,0},
        {1,1,0},
        {0,1,1}
    };
    int speed=1000;
    int direction=0;
    int sideLen=20;
    Pattern p=new Pattern(a,0,0);
    
     int[][]  rotate(int[][] s)
    {
      int[][] d={                 
          {s[2][0],s[1][0],s[0][0]},
          {s[2][1],s[1][1],s[0][1]},
          {s[2][2],s[1][2],s[0][2]}
      };
      return d;
    }
    

    ArrayList<Pattern> patternList=new ArrayList<Pattern>();
    ArrayList<Pattern> standList=new ArrayList<Pattern>();
    int[][] array=new int[45][25];
    LPanel()
    {
      setSize(300, 450);
      setBorder(new LineBorder(Color.BLACK,2));
      patternList.add(new Pattern(a));
      patternList.add(new Pattern(a1));
      patternList.add(new Pattern(a2));
      patternList.add(new Pattern(a3));
      patternList.add(new Pattern(a4));
    }
    Pattern randomNext()
    {
      return patternList.get(new Random().nextInt(patternList.size()));
    }
    
    public void drawPattern(Graphics g,Pattern p){
      int[][] squires=p.squires;
      g.setColor(Color.RED);
      for(int i=0;i<squires.length;i++){
        for(int j=0;j<squires[i].length;j++)
        {
          if(squires[i][j]==1)
          {
            g.fillRect(p.x+i*sideLen, p.y+j*sideLen, sideLen, sideLen);
          }
        }
      }
    }
    public void paint(Graphics g){
      super.paint(g);
      drawPattern(g,p);
      
      g.setColor(Color.BLUE);
      for(int i=0;i<array.length;i++){
        for(int j=0;j<array[i].length;j++)
        {
          if(array[i][j]==1)
          {
            g.fillRect(i*sideLen,j*sideLen, sideLen, sideLen);
          }
        }
      }
    }
    @Override
    public synchronized void run() {
      while(true)
      {
        try {
          Thread.sleep(speed);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
         keyPressed(new KeyEvent(this,0,0,0,KeyEvent.VK_DOWN));
      }
    }

    @Override
    public void keyPressed(KeyEvent e) {
      int dir=e.getKeyCode();
      if(dir == KeyEvent.VK_LEFT)
      {
        direction=-1;
        p.x-=sideLen;
      }
      if(dir == KeyEvent.VK_RIGHT)
      {
        direction=1;
        p.x+=sideLen;
      }
      if(dir == KeyEvent.VK_UP)
      {
        p.setSquires(rotate(p.squires));
        direction=2;//翻转
      }
      if(dir == KeyEvent.VK_DOWN)
      {
        direction=0;
        p.y+=sideLen;
      }
      
      int[][] sq=p.squires;
      boolean stop=false;
      for(int i=sq.length-1;i>=0;i--){
        for(int j=0;j<sq[i].length;j++)
        {
          if(sq[i][j]==1&&array[p.x/sideLen+i][p.y/sideLen+j]==1)
          {
            stop=true;
          }
          if(stop)
          {
            if(sq[i][j]==1)
            {
              array[p.x/sideLen+i][(p.y-1)/sideLen+j]=1;
            }
          }
        }
      }
      if(stop)
      {
        p=randomNext();
      }
      else if(p.y>15*sideLen)
      {
        for(int i=0;i<sq.length;i++){
          for(int j=0;j<sq[i].length;j++)
          {
            if(sq[i][j]==1)
            {
              array[p.x/sideLen+i][(p.y-1)/sideLen+j]=1;
            }
          }
        }
        p=randomNext();
      }
      repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
  }
  
  class RPanel extends JPanel implements KeyListener,Runnable{
    
    RPanel()
    {
      setSize(100, 450);
      setBorder(new LineBorder(Color.BLUE,2));
    }
    @Override
    public void run() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void keyTyped(KeyEvent e) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
      // TODO Auto-generated method stub
      
    }
    
  }

}
