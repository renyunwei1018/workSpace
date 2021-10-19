package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo1.class.getClassLoader().getResource("user.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Element element = document.getElementById("1");
        String text = element.text();
        System.out.println(text);
    }
}
