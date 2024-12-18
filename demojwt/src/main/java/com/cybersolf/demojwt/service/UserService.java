package com.cybersolf.demojwt.service;

import com.cybersolf.demojwt.Entity.RoleEntity;
import com.cybersolf.demojwt.Entity.UserEntity;
import com.cybersolf.demojwt.repository.RoleRepository;
import com.cybersolf.demojwt.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Value("${jwt.key}")
    private String keyJwt;
    public String getUserEntity(String email, String password){
        String token="";
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            UserEntity userEntity = user.get();
            String roleName=roleRepository.findById(userEntity.getRoleId()).map((RoleEntity::getName)).orElseThrow(()-> new RuntimeException("role not found"));
            if(passwordEncoder.matches(password,userEntity.getPassword())){
                SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(keyJwt));

                String jws = Jwts.builder().subject(roleName).signWith(key).compact();
                token= jws;
            }
        }
        return token;
    }
}
