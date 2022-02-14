package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.TimeZone;

public class JsonTest {

    @Test
    public void test01(){
        Person person = new Person();
        person.setAddress("aa");
        person.setName("张三");
        person.setAge(12);

        ObjectMapper om = new ObjectMapper();
        /*
        * 转换方法
        *   writeValue(参数1, obj)
        *       参数1：file: 将对象转为json字符串并将字符串写到文件中
        *           writer: 将对象转为json字符穿并将字符串写道输出字符流中
        *           OutputStream: 将对象转为字符串并输入到字节流中
        *   writeValueAsString(obj)
        *
        *   readValue(String,class)
        *
        * */
        String s = null;
        try {
            s = om.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
    @Test
    public void test02() throws JsonProcessingException {

        ObjectMapper om = new ObjectMapper();
        Person person = new Person();
        person.setAddress("aa");
        person.setName("张三");
        person.setAge(12);
        person.setBirthday(new Date());

        String s = om.writeValueAsString(person);
        System.out.println(s);
    }

    @Test
    public void test03() throws IOException {
        String JsonString = "{\"name\":\"张三\",\"birthday\":\"2021-10-21 07:55:35\",\"age\":12,\"address\":\"aa\"}";
        ObjectMapper om = new ObjectMapper();
        Person person = om.readValue(JsonString, Person.class);
        System.out.println(person);
    }

    @Test
    public void test04() throws UnsupportedEncodingException {
        String str = URLEncoder.encode("202111182250","");
//        String str1= URLDecoder.decode("202111182250", "UTF-8");
        System.out.println(str);
    }
}




