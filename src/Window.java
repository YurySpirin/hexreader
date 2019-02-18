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
        wind.setSize(400, 800);
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
            }
}


