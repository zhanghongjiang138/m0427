package org.swing.toolkit;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * @author Chirs Chou
 *         Mail: chirs@zhoujin.com
 *         Date: 4/7/13
 *         Time: 9:56 AM
 */
public class Dual extends Window implements ActionListener, ChangeListener{
    private static final long serialVersionUID=-4684297480608887575L;
    private int screen;
    public Dual(String one){
        super(new Frame());
        setLayout(new FlowLayout());
        JButton button=new JButton(one);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] gs=ge.getScreenDevices();
                if(screen>-1&&screen<gs.length){
                    gs[screen].setFullScreenWindow(null);
                }
                dispose();
                System.exit(0);
            }
        });
        add(button);
    }
    public static void showOnScreen(int screen, Dual frame){
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs=ge.getScreenDevices();
        if(screen>-1&&screen<gs.length){
            frame.setScreen(screen);
            gs[screen].setFullScreenWindow(frame);
            frame.validate();
        }else if(gs.length>0){
            gs[0].setFullScreenWindow(frame);
        }else{
            throw new RuntimeException("No Screens Found");
        }
    }
    public static void main(String[] args){
        showOnScreen(1,new Dual("Test"));
        showOnScreen(2,new Dual("1...2"));
        //        GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        //        for ( int i = 0; i < devices.length; i++ ) {
        //            System.out.println( "Device " + i + " width: " + devices[ i ].getDisplayMode().getWidth() );
        //            System.out.println( "Device " + i + " height: " + devices[ i ].getDisplayMode().getHeight() );
        //        }
    }
    public void setScreen(int screen){
        this.screen=screen;
    }
    @Override public void actionPerformed(ActionEvent e){
    }
    @Override public void stateChanged(ChangeEvent e){
    }
}