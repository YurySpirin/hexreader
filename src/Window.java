import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Window extends JFrame {
    static String reader;

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
        chooser.setLocation(50,50);
        chooser.setSize(100,30);
        chooser.setActionCommand("Pressed");
        ActionListener actionListener = new ChooseButton();
        chooser.addActionListener(actionListener);

        JButton chooseComm = new JButton("Выбрать Comm");
        wind.add(chooseComm);
        chooseComm.setVisible(true);
        chooseComm.setLocation(250,50);
        chooseComm.setSize(150,30);
        chooseComm.setActionCommand("Pressed");
        ActionListener chooseCommPort = new ChooseCommPort();
        chooseComm.addActionListener(chooseCommPort);

        JTextField comports = new JTextField(String.valueOf(ChooseCommPort.ports[0]+ChooseCommPort.ports[1]));
        wind.add(comports);
        comports.setVisible(true);
        comports.setLocation(200,200);
        comports.setSize(100,100);
        }
}


