import com.sun.istack.internal.NotNull;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.*;
import java.sql.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;

public class Reader {
    private byte [] str;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {
            FileReader reader = new FileReader("C:\\Drivers\\MCB07l_Test_BlinckLED_Boot.hex");
            BufferedReader read = new BufferedReader(reader);
            String s = ":10385000814F0008814F0008814F0008814F000808";
            String line = read.readLine();
            /*System.out.println(line);*/
            while (line != null) {
                System.out.println(line);
                line = read.readLine();
                Pattern p = Pattern.compile(":(.*)");
                Matcher m = p.matcher(line);
                while (m.find()) {
                    line = m.group(1);
                }

                /*System.out.println(line);*/



           /* while (line != null);
            {
                System.out.println(line);
                line = read.readLine();*/

                String[] lines = line.split("(?<=\\\\G.{2})");
                System.out.println(Arrays.toString(lines));
                String qwe = lines[1];
                System.out.println(qwe);
                /* byte[] data = new byte[lines.length];
                 *//*for (int i = 0; i < lines.length; i++) {*//*
                    data[i] = (byte) Integer.parseInt(lines[i],16);
                    System.out.printf(HexBin.encode(data));*/

                /*System.out.printf("%X ", data);*/
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
