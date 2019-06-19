package com.nuc.gzq.autoscript.commons;

import com.nuc.gzq.autoscript.Control.FileOp;
import com.nuc.gzq.autoscript.Data.Constants;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ButtonOp {
    public ButtonOp(){}
    public boolean Button_action(Map<String,String> map){
        String savePath = map.get("function_save_position");
        String filename = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String content = "";
        StringBuilder temp = new StringBuilder();
        Constants co = new Constants();
        FileOp fop = new FileOp();
        if(map.size() > 3){
            filename = co.InterfacePrefix + map.get("function_name");
            content = content + co.Comment_1 + temp.append(co.Comment_2).insert(17, filename);
            temp.delete(0,temp.length());
            content = content + temp.append(co.Comment_3).insert(17,map.get("function_author"));
            temp.delete(0,temp.length());
            content = content + temp.append(co.Comment_4).insert(17,df.format(new Date()));
            temp.delete(0,temp.length());
            content = content + co.Comment_5 + co.Comment_1 + temp.append(co.Infacecontent1).insert(21,filename);
            temp.delete(0,temp.length());
            content = content + co.Infacecontent2;
            if(map.get("function_setUI") == "1")
                content = content + co.Infacecontent3;
            content = content + co.Infacecontent4;
            if(map.get("function_cal").equals("")) {
                content = content + temp.append(co.Infacecontent5).insert(20,co.CalculatePrefix+map.get("function_name"));
            }else{
                content = content + temp.append(co.Infacecontent5).insert(20,map.get("function_cal"));
            }
            temp.delete(0,temp.length());
            if(map.get("function_in").equals("")) {
                content = content + co.Infacecontent6;
            }else{
                content = content + temp.append(co.Infacecontent6).replace(13,15,map.get("function_in"));
                temp.delete(0,temp.length());
            }
            if(map.get("function_in2").equals("")) {
                content = content + co.Infacecontent7;
            }else{
                content = content + temp.append(co.Infacecontent7).replace(14,16,map.get("function_in2"));
                temp.delete(0,temp.length());
            }
            if(map.get("function_intyp").equals("")) {
                content = content + co.Infacecontent8;
            }else{
                content = content + temp.append(co.Infacecontent8).replace(16,18,map.get("function_intyp"));
                temp.delete(0,temp.length());
            }
            if(map.get("function_out").equals("")) {
                content = content + co.Infacecontent9;
            }else{
                content = content + temp.append(co.Infacecontent9).replace(14,16,map.get("function_out"));
                temp.delete(0,temp.length());
            }
            if(map.get("function_out2").equals("")) {
                content = content + co.Infacecontent10;
            }else{
                content = content + temp.append(co.Infacecontent10).replace(15,17,map.get("function_out2"));
                temp.delete(0,temp.length());
            }
            if(map.get("function_outtyp").equals("")) {
                content = content + co.Infacecontent11;
            }else{
                content = content + temp.append(co.Infacecontent11).replace(17,19,map.get("function_outtyp"));
                temp.delete(0,temp.length());
            }
            if(map.get("function_evtin").equals("")) {
                content = content + co.Infacecontent12;
            }else{
                content = content + temp.append(co.Infacecontent12).replace(16,18,map.get("function_evtin"));
                temp.delete(0,temp.length());
            }
            if(map.get("function_evtout").equals("")) {
                content = content + co.Infacecontent13;
            }else{
                content = content + temp.append(co.Infacecontent13).replace(17,19,map.get("function_evtout"));
                temp.delete(0,temp.length());
            }
            content = content + co.Infacecontent14;
            if(map.get("function_module_type") == "d")
                content = content + temp.append(co.Infacecontent15).insert(21,"d");
            else
                content = content + temp.append(co.Infacecontent15).insert(21,"c");;
            temp.delete(0,temp.length());
            String deput = "";
            if(map.get("function_depu") == "1"){
                deput = "%t ";
            }else{
                deput = "%f ";
            }
            if(map.get("function_dept") == "1"){
                deput = deput + "%t";
            }else{
                deput = deput + "%f";
            }
            content = content + temp.append(co.Infacecontent16).insert(18,deput);
            temp.delete(0,temp.length());
            content = content + co.Infacecontent17;
            System.out.println(content);
        }else{
            filename = co.CalculatePrefix + map.get("function_name");
            content = content + co.Comment_1 + temp.append(co.Comment_2).insert(17, filename);
            temp.delete(0,temp.length());
            content = content + temp.append(co.Comment_3).insert(17,map.get("function_author"));
            temp.delete(0,temp.length());
            content = content + temp.append(co.Comment_4).insert(17,df.format(new Date()));
            temp.delete(0,temp.length());
            content = content + co.Comment_5 + co.Comment_1 + temp.append(co.Calculatecontent1).insert(17,filename);
            temp.delete(0,temp.length());
            System.out.println(content);
        }
        if(fop.saveFile(savePath, content, filename)){
            JOptionPane.showMessageDialog(null,"函数模板生成成功！", "提示", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

}

