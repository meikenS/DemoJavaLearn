package com.redisdemo;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    @Test
    public void stringTest(){
        Jedis jedis = new Jedis();
        jedis.set("username", "zhangsabn");
        String username = jedis.get("username");
        System.out.println(username);
        //关闭连接
        jedis.close();
    }

    @Test
    public void hashTest(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","suya");
        jedis.hset("user","password","123");
        jedis.hset("user","sex","female");
        String name = jedis.hget("user", "name");
        System.out.println(name);
        //获取user中所有数据
        Map<String, String> user = jedis.hgetAll("user");
        Set<Map.Entry<String, String>> entries = user.entrySet();
        for (Map.Entry entry: entries){
            System.out.println(entry);
        }
        //关闭连接
        jedis.close();
    }

    //linked
    @Test
    public void listTest(){
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.lpush("mylist", "a", "b", "c");
        jedis.rpush("mylist","a","b","c");
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        jedis.close();
    }

    //jedis连接池
    @Test
    public void redisPoolTest(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("hehe","zzz");
        jedis.close();
    }
}
