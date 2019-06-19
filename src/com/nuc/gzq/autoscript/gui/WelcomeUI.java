package com.nuc.gzq.autoscript.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeUI {

    private JFrame WelUIFrame;
    private JPanel WelUIJPanelTop_Left;
    private JPanel WelUIJPanelTop_Right;
    private JPanel WelUIJPanelBottom;
    private JLabel WelUIJLabel;
    private JRadioButton WelUIInterface;
    private JRadioButton WelUICalculation;
    private ButtonGroup WelUIRadioGroup;
    private JButton Button_About;
    private JButton Button_OK;
    private JButton Button_Cancel;
    private JLabel interface_label;
    private JLabel calculater_label;

    private static volatile WelcomeUI sharedInstance;

    public WelcomeUI() {
        //实例化
        WelUIFrame = new JFrame();
        WelUIJPanelTop_Left = new JPanel();
        WelUIJPanelTop_Right = new JPanel();
        WelUIJPanelBottom = new JPanel();
        WelUIInterface = new JRadioButton();
        WelUICalculation = new JRadioButton();
        WelUIRadioGroup = new ButtonGroup();
        Button_About = new JButton();
        Button_OK = new JButton();
        Button_Cancel = new JButton();
        interface_label = new JLabel("生成接口函数");
        calculater_label = new JLabel("生成计算函数");

        //Frame初始化
        WelUIFrame.setTitle("Xcos模块函数自动生成");
        WelUIFrame.setLayout(new BorderLayout(12,12));
        WelUIFrame.setBounds(200,200,500,250);
        WelUIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //左上角图标——苏苏~
        WelUIJLabel = new JLabel(new ImageIcon("E:\\北京\\smallproject\\resource\\WelcomeUI_left.png"));

        //将接口函数和计算函数的选择编入按钮组
        WelUIRadioGroup.add(WelUIInterface);
        WelUIRadioGroup.add(WelUICalculation);

        //组织上方右边的构造，采用网格布局
        WelUIInterface.setPreferredSize(new Dimension(15,60));
        WelUICalculation.setPreferredSize(new Dimension(15,60));
        WelUIJPanelTop_Right.setLayout(new GridLayout(2,2));
        WelUIJPanelTop_Right.add(WelUIInterface);
        WelUIJPanelTop_Right.add(interface_label);
        WelUIJPanelTop_Right.add(WelUICalculation);
        WelUIJPanelTop_Right.add(calculater_label);

        //组织上方左边的构造，采用边界布局
        WelUIJPanelTop_Left.setLayout(new BorderLayout(50,50));
        WelUIJPanelTop_Left.add(WelUIJLabel,BorderLayout.CENTER);
        //WelUIJPanelTop_Left.add(WelUIJPanelTop_Right, BorderLayout.EAST);

        //组织下方构造，采用边界布局
        Button_About.setText("关于");
        Button_OK.setText("确定");
        Button_Cancel.setText("退出");
        WelUIJPanelBottom.setLayout(new BorderLayout(12,12));
        WelUIJPanelBottom.add(Button_About, BorderLayout.WEST);
        WelUIJPanelBottom.add(Button_OK, BorderLayout.CENTER);
        WelUIJPanelBottom.add(Button_Cancel, BorderLayout.EAST);

        //组织整体结构，采用边界布局
        WelUIFrame.getContentPane().add(WelUIJPanelTop_Left, BorderLayout.WEST);
        WelUIFrame.getContentPane().add(WelUIJPanelTop_Right, BorderLayout.CENTER);
        WelUIFrame.getContentPane().add(WelUIJPanelBottom, BorderLayout.SOUTH);

        //按钮绑定监听
        Button_About.addActionListener(new WelButtonListener());
        Button_Cancel.addActionListener(new WelButtonListener());
        Button_OK.addActionListener(new WelButtonListener());

    }


    private final class WelButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(Button_About.equals(e.getSource())){

                JOptionPane.showMessageDialog(null, "本程序由郭志强开发，仅供学习使用", "关于", JOptionPane.WARNING_MESSAGE);

            }else if(Button_OK.equals(e.getSource())){
               // SetVisible(false);
                if(WelUIInterface.isSelected()){
                    setVisible(false);
                    InterfacefunctionUI temp = new InterfacefunctionUI();
                    temp.setVisible(true);
                }else if(WelUICalculation.isSelected()){
                    setVisible(false);
                    CalculationfunctionUI temp = new CalculationfunctionUI();
                    temp.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "你必须选择一个选项", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }else if(Button_Cancel.equals(e.getSource())){
                System.exit(0);
            }else{
                System.out.println("Can not find button!");
            }
        }
    }

    public WelcomeUI getSharedInstance(){
        if(sharedInstance == null){
            sharedInstance = this;
        }
        return sharedInstance;
    }

    public void setVisible(boolean visible){
        this.getSharedInstance().WelUIFrame.setVisible(visible);
    }
}
