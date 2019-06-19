import com.nuc.gzq.autoscript.Data.Constants;
import com.nuc.gzq.autoscript.gui.CalculationfunctionUI;
import com.nuc.gzq.autoscript.gui.InterfacefunctionUI;
import com.nuc.gzq.autoscript.gui.WelcomeUI;
import jdk.nashorn.internal.runtime.ECMAException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        WelcomeUI myUI = new WelcomeUI();
        myUI.setVisible(true);
    }
}
