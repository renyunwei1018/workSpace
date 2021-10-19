package test01;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputTest {
    @Test
    public void test001() throws IOException {
        FileInputStream in = new FileInputStream("C:\\Users\\RenYunWei\\Desktop\\temp\\login.js");
        FileOutputStream os = new FileOutputStream("D:\\20210609\\a.js");
        int len = 0;
        byte[] bytes = new byte[1024*8];
        while((len = in.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
    }
}
