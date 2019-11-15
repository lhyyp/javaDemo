package day_01.web.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("name","libai");
        jedis.setex("nihao",10,"hello word");
        System.out.println(jedis.get("a"));
        jedis.close();
    }

    @Test
    public void test2(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.hset("user","name","张三");
        jedis.hset("user","age","张三1");
        jedis.hset("user","sex","张三12");
        System.out.println(jedis.hget("user","age"));
        System.out.println(jedis.hgetAll("user"));
        jedis.close();
    }
}
