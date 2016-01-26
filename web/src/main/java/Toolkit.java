import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import org.apache.commons.lang.StringUtils;


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
    private JTextField text1= new JTextField();
    private JTextField text2= new JTextField();
    private JTextField text3= new JTextField();
    private JComboBox<String> box=new JComboBox<String>();
    
    private static final int intervalX=10;
    private static final int intervalY=40;
    
    private static int jLabelX=34;
    private static int jLabelY=15;
    
    private static int jTextX=96;
    private static int jTextY=15;
    private static int jTextLen=160;
    private static int jTextHeight=25;
    
    private static int jComBoxX=jTextX+jTextLen+10;
    private static int jComBoxY=jTextY+intervalY;
    
    private static int jButtonX=130;
    private static int jButtonY=200;
    
   
    
    
    public NewFrame(){
        super();
        this.setSize(500,300);
        this.setLocationByPlatform(true);
        this.getContentPane().setLayout(null);//设置布局控制器
        
        this.add(this.getTextField(text1),null);//添加文本框
        
        this.add(this.getTextField(text2),null);//添加文本框

        this.add(this.getTextField(text3),null);//添加文本框
        
        this.add(this.getBox(),null);//添加下拉列表框

        this.add(this.getLabel(label1,"key"),null);//添加标签
        
        this.add(this.getLabel(label2,"中文翻译"),null);//添加标签
        
        this.add(this.getLabel(label2,"英文翻译"),null);//添加标签
        
        this.add(this.getButton(),null);//添加按钮

        this.setTitle("国际化");//设置窗口标题
        
    }
    
    private JComboBox getBox(){
          box.setBounds(jComBoxX,jComBoxY,71,27);
          box.addItem("");
          box.addItem(".C");
          box.addItem(".M");
          box.addItem(".D");
          box.addActionListener(new comboxListener());//为下拉列表框添加监听器类
      return box;
  }
  private class comboxListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          System.out.println("selected");
      }
  }

    private JTextField getTextField(JTextField text){
        jTextY+=intervalY;
        text.setBounds(jTextX,jTextY,jTextLen,jTextHeight);
        return text;
    }
    

    private JLabel getLabel(JLabel label,String labelText){
        if(label==null){
            label = new JLabel();
            jLabelY+=intervalY;
            label.setBounds(jLabelX,jLabelY,53,20);
            label.setText(labelText);
        }
        return label;
    }

    private JButton getButton(){
        if(button1==null){
            button1 = new JButton();
            button1.setBounds(jButtonX,jButtonY,71,27);
            button1.setText("提交");
            button1.addActionListener(new HelloButton());//添加监听器类，其主要的响应都由监听器类的方法实现
        }
        return button1;
    }

    private class HelloButton implements ActionListener{
      private static final String RESOURCESET="CommonResources";
      private static final String EN="en";
      
        public void actionPerformed(ActionEvent e){
          String key=text1.getText();
          String zhValue=text2.getText();
          String enValue=text3.getText();
          String suffix=(String)box.getSelectedItem();
          key=key+suffix;
          Connection con=DBConnection.getConnection();
          
          if(StringUtils.isBlank(key)||StringUtils.isBlank(enValue)||StringUtils.isBlank(suffix))
          {
            JOptionPane.showMessageDialog(null, "参数不能为空");
          }
          String sqlQuery="select count(1) from SY_LOCALERESOURCE where RESOURCESET= ? and RESOURCEKEY = ? ";
          String[] pramQuery={RESOURCESET,key};
          try {
            String result=DBConnection.executeQuery(con, sqlQuery,pramQuery);
            if(Integer.parseInt(result)>0)
            {
              JOptionPane.showMessageDialog(null, "已存在该key");
              return ;
            }
          } catch (SQLException ee) {
            JOptionPane.showMessageDialog(null, "程序异常！");
            ee.printStackTrace();
          }
          
          
          
          String sq0="insert into SY_LOCALERESOURCE (RESOURCESET, RESOURCEKEY, RESOURCEVALUE) values (?,?,?)";
          String sq1="insert into SY_LOCALERESOURCE_TL (Resourceset, Resourcekey, Languagecode, Resourcevalue) values (?,?,?,?)";
          String[] pram0={RESOURCESET,key,zhValue};
          String[] pram1={RESOURCESET,key,EN,enValue};
          try {
            DBConnection.execute(con, sq0,pram0);
            DBConnection.execute(con, sq1,pram1);
            JOptionPane.showMessageDialog(null, "保存成功！");
          } catch (SQLException ee) {
            JOptionPane.showMessageDialog(null, "程序异常！");
            ee.printStackTrace();
          }

        }
          
    }
}