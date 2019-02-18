import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ChooseButton implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        JFileChooser hexFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = hexFile.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = hexFile.getSelectedFile();

            Window.reader = selectedFile.getAbsolutePath();
        }
    }
}
