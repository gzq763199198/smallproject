package com.nuc.gzq.autoscript.commons;

import java.util.Map;

public class ButtonOp {
    public ButtonOp(){}
    public boolean Button_action(Map<String,String> map){

        System.out.println(map.size());
        System.out.println("SROS_" + map.get("function_name").toString());
        System.out.println(map.get("function_author").toString());

        return true;
    }

}

