import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.*;

import static java.lang.String.valueOf;

public class Reader {
    private byte [] str;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {
            FileReader reader = new FileReader("C:\\Drivers\\MCB07l_Test_BlinckLED_Boot.hex");
            BufferedReader read = new BufferedReader(reader);
         
            String line = null;           
            // считываем остальные строки в цикле
            while ((line = read.readLine()) != null) {
                System.out.println(line);
                line = read.readLine();

                byte[] str = new byte[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    str[i] = (byte) Integer.parseInt((line), 16);
                }
                
                System.out.printf("%X ", str);               
            }         
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
