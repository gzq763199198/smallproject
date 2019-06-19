package com.nuc.gzq.autoscript.gui;

import com.nuc.gzq.autoscript.commons.ButtonOp;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CalculationfunctionUI {
    private JFrame CalcUI_Frame;
    private JPanel CalcUI_Panel_top;
    private JPanel CalcUI_Panel_bottom;
    //标签
    private JLabel function_name;
    private JLabel function_author;
    private JLabel function_save_position;
    //文本框
    private JTextField function_name_text;
    private JTextField function_author_text;
    private JTextField function_save_position_text;
    //按钮
    private JButton function_save_position_btn;
    private JButton Button_OK;
    private JButton Button_Return;

    private CalculationfunctionUI sharedInstance;

    public CalculationfunctionUI(){
        //初始化
        CalcUI_Frame = new JFrame();
        CalcUI_Panel_top = new JPanel();
        CalcUI_Panel_bottom = new JPanel();

        function_name = new JLabel("计算函数名称");
        function_author = new JLabel("作者");
        function_save_position = new JLabel("脚本文件保存位置");

        function_name_text = new JTextField();
        function_author_text = new JTextField();
        function_save_position_text = new JTextField();

        function_save_position_btn = new JButton("...");
        Button_OK = new JButton("确定生成");
        Button_Return = new JButton("取消返回");


        //Frame初始化
        CalcUI_Frame.setTitle("Xcos模块计算函数自动生成");
        CalcUI_Frame.setLayout(new BorderLayout(12,12));
        CalcUI_Frame.setBounds(450,20,300,150);
        CalcUI_Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CalcUI_Frame.setResizable(false);

        //将选项组件放入jpanel_top中
        CalcUI_Panel_top.setLayout(null);
        //function_name.setPreferredSize(new Dimension(20,20));
        //function_name_text.setPreferredSize(new Dimension(20,20));
        function_name.setBounds(1,1,100,20);
        function_name_text.setBounds(102,2,100,20);
        CalcUI_Panel_top.add(function_name);
        CalcUI_Panel_top.add(function_name_text);

        function_author.setBounds(1,26,100,20);
        function_author_text.setBounds(102,27,100,20);
        CalcUI_Panel_top.add(function_author);
        CalcUI_Panel_top.add(function_author_text);

        function_save_position.setBounds(1,52,110,20);
        function_save_position_text.setBounds(115,53,100,20);
        function_save_position_btn.setBounds(220,53,40,20);
        CalcUI_Panel_top.add(function_save_position);
        CalcUI_Panel_top.add(function_save_position_text);
        CalcUI_Panel_top.add(function_save_position_btn);

        //将按钮组件嵌入jpanel_bottom
        CalcUI_Panel_bottom.setLayout(new BorderLayout(12,12));
        CalcUI_Panel_bottom.setPreferredSize(new Dimension(25,25));
        CalcUI_Panel_bottom.add(Button_OK,BorderLayout.WEST);
        CalcUI_Panel_bottom.add(Button_Return, BorderLayout.EAST);

        //将jpanel嵌入至Frame中
        CalcUI_Frame.getContentPane().add(CalcUI_Panel_top,BorderLayout.CENTER);
        CalcUI_Frame.getContentPane().add(CalcUI_Panel_bottom,BorderLayout.SOUTH);

        //按钮绑定监听
        Button_OK.addActionListener(new CalcButtonListner());
        Button_Return.addActionListener(new CalcButtonListner());
        function_save_position_btn.addActionListener(new CalcButtonListner());
    }

    private final class CalcButtonListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Button_OK.equals(e.getSource())){
                //TODO:trans Data to commons
                if(function_save_position_text.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"必须选择脚本保存位置", "错误", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Map<String,String> map = new HashMap<>();
                map.put("function_name",function_name_text.getText());
                map.put("function_author",function_author_text.getText());
                map.put("function_save_position", function_save_position_text.getText());
                ButtonOp bop = new ButtonOp();
                bop.Button_action(map);
            }else if(Button_Return.equals(e.getSource())){
                setVisible(false);
                WelcomeUI temp = new WelcomeUI();
                temp.setVisible(true);
                CalcUI_Frame.dispose();
            }else if(function_save_position_btn.equals(e.getSource())){
                JFileChooser fileChooser = new JFileChooser();
                FileSystemView fsv = FileSystemView.getFileSystemView();
                fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
                fileChooser.setDialogTitle("请选择要保存的路径...");
                fileChooser.setApproveButtonText("选择文件夹");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    String choosepath = fileChooser.getSelectedFile().getPath();
                    function_save_position_text.setText(choosepath+"\\");
                    System.out.println(choosepath);
                }
            }else{
                System.out.println("Can not find button!");
            }
        }
    }

    public CalculationfunctionUI getSharedInstance(){
        if(sharedInstance == null){
            sharedInstance = this;
        }
        return sharedInstance;
    }

    public void setVisible(boolean visible){
        this.getSharedInstance().CalcUI_Frame.setVisible(visible);
    }



}
