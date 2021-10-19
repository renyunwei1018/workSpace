import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputFile {
    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<String>();
//            BufferedReader bf = new BufferedReader("");
            InputStream in = new FileInputStream("D:\\workSpace\\webDemo01\\userTableDemo01\\src\\words.txt");
            byte[] bytes = new byte[1024*10];
            int len=0;
            StringBuffer sb = new StringBuffer();
            while ( (len= in.read(bytes)) > 0) {
                sb.append(new String(bytes,0,len));
            }
            String s = sb.toString();
            String[] strings = s.split(",");
            list = Arrays.asList(strings);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
