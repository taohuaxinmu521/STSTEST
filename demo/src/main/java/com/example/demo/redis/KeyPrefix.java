package com.example.demo.redis;

/**
 * Created by tanwen on 2018/9/8.
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
