import jssc.SerialPortList;

import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;


public class Window extends JFrame {
    public static Object comports;
    static String reader;
    private static String[] ports;

    public Window() throws FileNotFoundException {
        //Создаем окно
        JFrame wind = new JFrame();
        wind.setTitle("HexReader");
        wind.setSize(600, 600);
        wind.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wind.setVisible(true);
        //создаем кнопку
        JButton chooser = new JButton("Выбрать");
        wind.add(chooser);
        chooser.setVisible(true);
        chooser.setLocation(50, 50);
        chooser.setSize(100, 30);
        chooser.setActionCommand("Pressed");
        ActionListener actionListener = new ChooseButton();
        chooser.addActionListener(actionListener);
        //создаем кнопку опроса ком портов
        JButton chooseComm = new JButton("Выбрать Comm");
        wind.add(chooseComm);
        chooseComm.setVisible(true);
        chooseComm.setLocation(250, 50);
        chooseComm.setSize(150, 30);
        chooseComm.setActionCommand("Pressed");
        chooseComm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ports = SerialPortList.getPortNames();
                for (int i = 0; i < ports.length; i++) {
                    JTextField comports = new JTextField();
                    wind.add(comports);
                    comports.setVisible(true);
                    comports.setLocation(200, 200);
                    comports.setSize(100, 100);
                    comports.setText(ports[i]);
                }
            }
        });
    }
    }