import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PARA {
    public static String inString() {
        // function to read a string from the keyboard
        String str = "";
        BufferedReader box = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = box.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
