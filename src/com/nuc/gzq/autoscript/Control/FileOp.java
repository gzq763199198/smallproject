package com.nuc.gzq.autoscript.Control;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;

public class FileOp {

    public FileOp(){}

    public boolean saveFile(String savePath,String content,String filename){
        try{
            File f = new File(savePath+filename+".sci");
            FileWriter fw = new FileWriter(f);
            fw.write(content);
            fw.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "错误", JOptionPane.WARNING_MESSAGE);
            System.out.println("error :" + e.toString());
            return false;
        }
        return true;
    }
}
