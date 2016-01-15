import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Toolkit{
    public static void main(String args[])throws Exception{
        NewFrame frame1 = new NewFrame();
        
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//一定要设置关闭

        frame1.setVisible(true);
    }
}
class NewFrame extends JFrame{
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JTextField text1;
    private JTextField text2;
    private JComboBox box;
    private JMenuBar menuBar;
    private JSlider slider;
    private JSpinner spinner;
    private JToolBar toolBar;
    
//    label.setBounds(34,49,53,18);
//    text.setBounds(96,49,160,20);
    private static int jLabelX=34;
    private static int jLabelY=49;
    
    private static int jTextX=96;
    private static int jTextY=49;
    
    private static int jButtonX=130;
    private static int jButtonY=160;
    
    private final int intervalX=10;
    private final int intervalY=40;
    
    
    public NewFrame(){
        super();
        this.setSize(500,300);
        this.getContentPane().setLayout(null);//设置布局控制器

        this.add(this.getTextField(text1),null);//添加文本框
        
        this.add(this.getTextField(text2),null);//添加文本框

        this.add(this.getButton(),null);//添加按钮

        this.add(this.getLabel(label1,"key"),null);//添加标签
        
        this.add(this.getLabel(label2,"value"),null);//添加标签

        this.setTitle("Hello World!");//设置窗口标题

    }
    /**
     * 设定文本域
     * @return
     */
    private JTextField getTextField(JTextField text){
      if(text==null){
        text = new JTextField();
        jTextY+=intervalY;
        text.setBounds(jTextX,jTextY,160,20);
      }
      return text;
    }
    /**
     * 设置标签
     * @return 设置好的标签
     */
    private JLabel getLabel(JLabel label,String labelText){
        if(label==null){
            label = new JLabel();
            jLabelY+=intervalY;
            label.setBounds(jLabelX,jLabelY,53,18);
            label.setText(labelText);
        }
        return label;
    }
    /**
     * 设置按钮
     * @return 设置好的按钮
     */
    private JButton getButton(){
        if(button1==null){
            button1 = new JButton();
            button1.setBounds(jButtonX,jButtonY,71,27);
            button1.setText("提交");
            button1.setToolTipText("提交");
            button1.addActionListener(new HelloButton());//添加监听器类，其主要的响应都由监听器类的方法实现

        }
        return button1;
    }
    /**
     * 监听器类实现ActionListener接口，主要实现actionPerformed方法
     * @author HZ20232
     *
     */
    private class HelloButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("Hello world!");
        }
    }
}