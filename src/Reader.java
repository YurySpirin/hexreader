import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.*;

import static java.lang.String.valueOf;

public class Reader {
    private byte [] str;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {
            FileReader reader = new FileReader("C:\\Drivers\\MCB07l_Test_BlinckLED_Boot.hex");
            BufferedReader  read = new BufferedReader(reader);
            String s = ":10385000814F0008814F0008814F0008814F000808";
            String line = read.readLine();
            /*System.out.println(line);*/
            while (line != null) {
                System.out.println(line);
                line = read.readLine();


           /* while (line != null);
            {
                System.out.println(line);
                line = read.readLine();*/

                String[] lines = line.split("", 2);
                System.out.println(lines.toString());
               /* byte[] data = new byte[lines.length];
                for (int i = 0; i < lines.length; i++) {
                    data[i] = (byte) Integer.parseInt(lines[i],16);
                    System.out.printf(HexBin.encode(data));

                    *//*System.out.printf("%X ", data);*//*
                }*/
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
