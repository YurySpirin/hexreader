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
