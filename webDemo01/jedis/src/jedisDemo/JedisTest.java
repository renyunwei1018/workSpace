package jedisDemo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    /*
    * String
    * */
    @Test
    public void test01(){

        //1.get connection
        Jedis jedis = new Jedis("localhost",6379);
        //2.operation
        jedis.set("username","zhangsan");
        String username = jedis.get("username");
        jedis.del("username");
        //close connection
        jedis.close();
        System.out.println(username);
    }

    /*
    * hash
    * */
    @Test
    public void test02(){

        Jedis jedis = new Jedis();
        jedis.hset("myhash","name","zhangsan");
        jedis.hset("myhash","age","12");
        jedis.hset("myhash","address","cahngsha");
        jedis.hdel("myhash", "dd");

        Map<String, String> myhash = jedis.hgetAll("myhash");
        for (String a :myhash.keySet()){
            System.out.println(a +" : "+myhash.get(a));
        }

        String name = jedis.hget("myhash", "name");
        System.out.println(name);
    }

    /*
    * list
    * */
    @Test
    public void test03(){

        Jedis jedis = new Jedis();
        jedis.del("list");
        jedis.lpush("list","a","b");
        jedis.rpush("list","c","d");

        List<String> list = jedis.lrange("list", 0, -1);

        for (String a :list) {
            System.out.println(a);
        }

        jedis.rpop("list");
        jedis.lpop("list");
        list = jedis.lrange("list", 0, -1);
        for (String a :list) {
            System.out.println(a);
        }

        jedis.close();
    }

    /*
    * set
    * */
    @Test
    public void test04(){
        Jedis jedis = new Jedis();
        jedis.sadd("set","a","d","c");
        Set<String> set = jedis.smembers("set");
        for (String a:set) {
            System.out.println(a);
        }
        jedis.srem("set","d");

        set = jedis.smembers("set");
        for (String a:set) {
            System.out.println(a);
        }
    }

    /*
    * redis连接池  
    * */
    @Test
    public void test05(){
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxTotal(50);
        jpc.setMaxIdle(10);
        JedisPool jp = new JedisPool(jpc,"localhost",6379);
        Jedis jedis = jp.getResource();

    }
}
