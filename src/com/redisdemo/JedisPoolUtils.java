package com.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    private static JedisPool jedisPool;
    //静态代码块，类加载时执行
    static {
        //读配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("\\jedis.properties");
        Properties pro = new Properties();
        //关联文件
        try {
            pro.load(is);
        }catch (Exception e){
            e.printStackTrace();
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        //初始化jedisPool
        jedisPool = new JedisPool(jedisPoolConfig, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
