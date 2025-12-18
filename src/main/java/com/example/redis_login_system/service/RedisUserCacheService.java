package com.example.redis_login_system.service;


import com.example.redis_login_system.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisUserCacheService {

    private final RedisTemplate<String, User> redisTemplate;

    private static final long TTL = 10;

    public RedisUserCacheService(RedisTemplate<String, User> redisTemplate){
        this.redisTemplate = redisTemplate;

    }

    // Get user from Redis using email as key //
    public  User getUser(String email){
        return redisTemplate.opsForValue().get(email);
    }

    // Save user to Redis with TTL //
    public void saveUser(String email, User user){
        redisTemplate.opsForValue()
                .set(email , user, TTL, TimeUnit.MINUTES);

    }

    // Remove user from Redis ( on LogOut / update ) //
    public void evictUser(String email){
        redisTemplate.delete(email);

    }
}
