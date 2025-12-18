package com.example.redis_login_system.config;

import com.example.redis_login_system.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, User> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // key -> String (email)
        template.setKeySerializer(new StringRedisSerializer());

        // value -> JSON (User object)
        template.setValueSerializer(
                new GenericJackson2JsonRedisSerializer()
        );
        return template;
    }
}
