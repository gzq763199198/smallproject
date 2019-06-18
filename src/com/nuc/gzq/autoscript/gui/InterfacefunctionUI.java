package com.nuc.gzq.autoscript.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfacefunctionUI {

    private JFrame InfaceUI_Frame;
    private JPanel InfaceUI_Panel_top;
    private JPanel InfaceUI_Panel_bottom;
    //标签
    private JLabel function_name;
    private JLabel function_author;
    private JLabel function_setUI;
    private JLabel function_cal;
    private JLabel function_in;
    private JLabel function_in2;
    private JLabel function_intyp;
    private JLabel function_out;
    private JLabel function_out2;
    private JLabel function_outtyp;
    private JLabel function_evtin;
    private JLabel function_evtout;
    private JLabel function_module_type;
    private JLabel function_module_type_continue;
    private JLabel function_module_type_discrete;
    private JLabel function_depu;
    private JLabel function_dept;
    private JLabel function_save_position;
    private JLabel function_blank;
    private JLabel function_blank2;
    private JLabel function_blank3;
    //文本框
    private JTextField function_name_text;
    private JTextField function_author_text;
    private JTextField function_cal_text;
    private JTextField function_in_text;
    private JTextField function_in2_text;
    private JTextField function_intyp_text;
    private JTextField function_out_text;
    private JTextField function_out2_text;
    private JTextField function_outtyp_text;
    private JTextField function_evtin_text;
    private JTextField function_evtout_text;
    private JTextField function_save_position_text;
    //复选框
    private JCheckBox function_setUI_check;
    private JCheckBox function_depu_check;
    private JCheckBox function_dept_check;
    //单选组
    private ButtonGroup function_module_type_group;
    //单选按钮
    private JRadioButton function_module_type_continue_radio;
    private JRadioButton function_module_type_discrete_radio;
    //按钮
    private JButton function_save_position_btn;
    private JButton Button_OK;
    private JButton Button_Return;

    private InterfacefunctionUI sharedInstance;

    public InterfacefunctionUI(){
        //初始化
        InfaceUI_Frame = new JFrame();
        InfaceUI_Panel_top = new JPanel();
        InfaceUI_Panel_bottom = new JPanel();

        function_name = new JLabel("接口函数名称");
        function_author = new JLabel("作者");
        function_setUI = new JLabel("是否有设置参数界面");
        function_cal = new JLabel("是否指定计算函数");
        function_in = new JLabel("模块常规输入端口一维向量");
        function_in2 = new JLabel("模块常规输入端口二维向量");
        function_intyp = new JLabel("模块常规输入端口类型");
        function_out = new JLabel("模块常规输出端口一维向量");
        function_out2 = new JLabel("模块常规输出端口二维向量");
        function_outtyp = new JLabel("模块常规输出端口类型");
        function_evtin = new JLabel("模块事件输入端口");
        function_evtout = new JLabel("模块事件输出端口");
        function_module_type = new JLabel("模块类别");
        function_module_type_continue = new JLabel("连续");
        function_module_type_discrete = new JLabel("离散");
        function_depu = new JLabel("模块输出是否与输入相关");
        function_dept = new JLabel("模块输出是否与时间相关");
        function_save_position = new JLabel("脚本文件保存位置");
        function_blank = new JLabel(" ");
        function_blank2 = new JLabel(" ");
        function_blank3 = new JLabel(" ");

        function_name_text = new JTextField();
        function_author_text = new JTextField();
        function_cal_text = new JTextField();
        function_in_text = new JTextField();
        function_in2_text = new JTextField();
        function_intyp_text = new JTextField();
        function_out_text = new JTextField();
        function_out2_text = new JTextField();
        function_outtyp_text = new JTextField();
        function_evtin_text = new JTextField();
        function_evtout_text = new JTextField();
        function_save_position_text = new JTextField();

        function_setUI_check  = new JCheckBox();
        function_depu_check = new JCheckBox();
        function_dept_check = new JCheckBox();

        function_module_type_group = new ButtonGroup();

        function_module_type_continue_radio = new JRadioButton();
        function_module_type_discrete_radio = new JRadioButton();

        function_save_position_btn = new JButton("选择文件");
        Button_OK = new JButton("确定生成");
        Button_Return = new JButton("取消返回");


        //Frame初始化
        InfaceUI_Frame.setTitle("Xcos模块接口函数自动生成");
        InfaceUI_Frame.setLayout(new BorderLayout(12,12));
        InfaceUI_Frame.setBounds(450,20,300,450);
        InfaceUI_Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //将选项组件放入jpanel_top中
        InfaceUI_Panel_top.setLayout(null);
        //function_name.setPreferredSize(new Dimension(20,20));
        //function_name_text.setPreferredSize(new Dimension(20,20));
        function_name.setBounds(1,1,100,20);
        function_name_text.setBounds(102,2,100,20);
        InfaceUI_Panel_top.add(function_name);
        InfaceUI_Panel_top.add(function_name_text);

        function_author.setBounds(1,26,100,20);
        function_author_text.setBounds(102,27,100,20);
        InfaceUI_Panel_top.add(function_author);
        InfaceUI_Panel_top.add(function_author_text);

        function_setUI.setBounds(1,51,120,20);
        function_setUI_check.setBounds(122,52,120,20);
        InfaceUI_Panel_top.add(function_setUI);
        InfaceUI_Panel_top.add(function_setUI_check);

        function_cal.setBounds(1,76,120,20);
        function_cal_text.setBounds(122,77,100,20);
        InfaceUI_Panel_top.add(function_cal);
        InfaceUI_Panel_top.add(function_cal_text);

        function_in.setBounds(1,101,170,20);
        function_in_text.setBounds(172,102,100,20);
        InfaceUI_Panel_top.add(function_in);
        InfaceUI_Panel_top.add(function_in_text);

        function_in2.setBounds(1,127,170,20);
        function_in2_text.setBounds(172,128,100,20);
        InfaceUI_Panel_top.add(function_in2);
        InfaceUI_Panel_top.add(function_in2_text);

        function_intyp.setBounds(1,152,170,20);
        function_intyp_text.setBounds(172,153,100,20);
        InfaceUI_Panel_top.add(function_intyp);
        InfaceUI_Panel_top.add(function_intyp_text);

        function_out.setBounds(1,177,170,20);
        function_out_text.setBounds(172,178,100,20);
        InfaceUI_Panel_top.add(function_out);
        InfaceUI_Panel_top.add(function_out_text);

        function_out2.setBounds(1,202,170,20);
        function_out2_text.setBounds(172,203,100,20);
        InfaceUI_Panel_top.add(function_out2);
        InfaceUI_Panel_top.add(function_out2_text);

        function_outtyp.setBounds(1,227,170,20);
        function_outtyp_text.setBounds(172,228,100,20);
        InfaceUI_Panel_top.add(function_outtyp);
        InfaceUI_Panel_top.add(function_outtyp_text);

        function_evtin.setBounds(1,252,120,20);
        function_evtin_text.setBounds(122,253,100,20);
        InfaceUI_Panel_top.add(function_evtin);
        InfaceUI_Panel_top.add(function_evtin_text);

        function_evtout.setBounds(1,277,120,20);
        function_evtout_text.setBounds(122,278,100,20);
        InfaceUI_Panel_top.add(function_evtout);
        InfaceUI_Panel_top.add(function_evtout_text);

        function_module_type.setBounds(1,302,80,20);
        function_module_type_continue_radio.setBounds(85,302,20,20);
        function_module_type_continue.setBounds(110,302,80,20);
        function_module_type_discrete_radio.setBounds(195,302,20,20);
        function_module_type_discrete.setBounds(220,302,80,20);
        function_module_type_group.add(function_module_type_continue_radio);
        function_module_type_group.add(function_module_type_discrete_radio);
        InfaceUI_Panel_top.add(function_module_type);
        InfaceUI_Panel_top.add(function_module_type_continue_radio);
        InfaceUI_Panel_top.add(function_module_type_continue);
        InfaceUI_Panel_top.add(function_module_type_discrete_radio);
        InfaceUI_Panel_top.add(function_module_type_discrete);

        function_depu.setBounds(1,327,150,20);
        function_depu_check.setBounds(152,328,120,20);
        InfaceUI_Panel_top.add(function_depu);
        InfaceUI_Panel_top.add(function_depu_check);

        function_dept.setBounds(1,352,150,20);
        function_dept_check.setBounds(152,353,120,20);
        InfaceUI_Panel_top.add(function_dept);
        InfaceUI_Panel_top.add(function_dept_check);




        //InfaceUI_Panel_top.add(function_author,5);
       // InfaceUI_Panel_top.add(function_author_text,7);


        //将按钮组件嵌入jpanel_bottom
        InfaceUI_Panel_bottom.setLayout(new BorderLayout(12,12));
        InfaceUI_Panel_bottom.setPreferredSize(new Dimension(25,25));
        InfaceUI_Panel_bottom.add(Button_OK,BorderLayout.WEST);
        InfaceUI_Panel_bottom.add(Button_Return, BorderLayout.EAST);

        //将jpanel嵌入至Frame中
        InfaceUI_Frame.getContentPane().add(InfaceUI_Panel_top,BorderLayout.CENTER);
        InfaceUI_Frame.getContentPane().add(InfaceUI_Panel_bottom,BorderLayout.SOUTH);

        //按钮绑定监听
        Button_OK.addActionListener(new InfaceButtonListner());
        Button_Return.addActionListener(new InfaceButtonListner());
    }

    private final class InfaceButtonListner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Button_OK.equals(e.getSource())){
                //TODO:trans Data to commons
            }else if(Button_Return.equals(e.getSource())){
                //TODO:unvisible inface and visible Wel
                setVisible(false);
                WelcomeUI temp = new WelcomeUI();
                temp.setVisible(true);
            }else{
                System.out.println("Can not find button!");
            }
        }
    }

    public InterfacefunctionUI getSharedInstance(){
        if(sharedInstance == null){
            sharedInstance = this;
        }
        return sharedInstance;
    }

    public void setVisible(boolean visible){
        this.getSharedInstance().InfaceUI_Frame.setVisible(visible);
    }

}
