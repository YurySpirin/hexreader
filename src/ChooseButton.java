import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChooseButton implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        JFileChooser hexFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = hexFile.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = hexFile.getSelectedFile();

            Window.reader = selectedFile.getAbsolutePath();

            try {
                System.out.println(Window.reader);
                FileReader reader = new FileReader(Window.reader);
                BufferedReader read = new BufferedReader(reader);
                String line = new String();
                while (line != null) {
                    line = read.readLine();
                    Pattern p = Pattern.compile(":(.*)");
                    Matcher m = p.matcher(line);
                    while (m.find()) {
                        line = m.group(1);
                    }
                    String[] SS = new String[line.length() / 2];
                    int k = 0;  //счетчик для индексов  массива
                    for (int i = 0; i < line.length() - 1; i = i + 2) { // проход по массиву через каждые 2 символа для нахождения новой подстроки
                        String S1 = line.substring(i, i + 2); // нахождение подстроки с длиной в 2 символа
                        SS[k++] = S1; // присваивание  подстроки к элементу массива
                    }
                    byte[] data = new byte[SS.length];
                    for (int i = 0; i < SS.length; i++) {
                        data[i] = (byte) Integer.parseInt(SS[i], 16);
                    }
                    System.out.println(HexBin.encode(data));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException ex) {
                System.out.println(ex);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println(ex);
            }
        }
    }
}
