import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortList;
import jssc.SerialPortEventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Enumeration;

public class ChooseCommPort implements ActionListener {


    public static String[] ports = null;


    public void actionPerformed(ActionEvent e) {

        ports = SerialPortList.getPortNames();
        for (int i = 0; i < ports.length; i++) {
        }

    }
}
