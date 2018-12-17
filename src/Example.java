import java.lang.reflect.Array;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        String s = "some text";
        byte [] q = new byte [15];
        q = s.getBytes();
        System.out.println(Arrays.toString(q));

    }
}
