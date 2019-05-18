package com.example.demo.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by tanwen on 2018/9/8.
 */
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;


    public <T> T get(KeyPrefix prefix,String key,Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            String str = jedis.get(realKey);
            return StringToBean(str,clazz);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public <T> boolean set(KeyPrefix prefix,String key,T value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = BeanToString(value);
            if (StringUtils.isEmpty(str)){
                return false;
            }
            String realKey = prefix.getPrefix() + key;
            //设置过期的时间
            int expireSeconds = prefix.expireSeconds();
            if (expireSeconds <= 0){
                jedis.set(realKey,str);
            }
            else {
                jedis.setex(realKey,expireSeconds,str);
            }
            return true;
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public <T> boolean exists(KeyPrefix prefix,String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
           return jedis.exists(realKey);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public <T> Long incr(KeyPrefix prefix,String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public Long delete(KeyPrefix prefix,String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.del(realKey);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public <T> Long decr(KeyPrefix prefix,String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public <T> String BeanToString(T value){
        if (value == null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class ||clazz == long.class){
            return "" + value;
        }
        else if (clazz == String.class){
            return (String) value;
        }
        else {
            return JSON.toJSONString(value);
        }
    }

    public <T> T StringToBean(String str,Class<T> clazz){
        if (str == null || clazz == null){
            return null;
        }
        if (clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(str);
        }
        else if (clazz == String.class){
            return (T)str;
        }
        else if (clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(str);
        }
        else {
            return JSON.toJavaObject(JSON.parseObject(str),clazz);
        }
    }
}
