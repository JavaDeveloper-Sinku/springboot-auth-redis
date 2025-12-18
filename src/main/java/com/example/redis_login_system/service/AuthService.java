package com.example.redis_login_system.service;


import com.example.redis_login_system.entity.User;
import com.example.redis_login_system.repository.userRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

   private final userRepository userRepository;
   private final RedisUserCacheService cacheService;

   public AuthService(userRepository userRepository, RedisUserCacheService cacheService){
       this.userRepository = userRepository;
       this.cacheService = cacheService;

   }

   public User login(String email, String password){

       // Try Redis first //
       User cacheUser = cacheService.getUser(email);
       if (cacheUser != null){
           return cacheUser;

       }

       // DB hit via Hibernate //
       User user = userRepository.findByEmail(email)
               .orElseThrow(() ->
                       new RuntimeException("User not found"));

       // Password check ( basic level ) //
       if (!user.getPassword().equals(password)){
           throw new RuntimeException("Invalid Credentials");

       }

       // Save user to Redis cache //
       cacheService.saveUser(email , user);



       return user;

   }
}
