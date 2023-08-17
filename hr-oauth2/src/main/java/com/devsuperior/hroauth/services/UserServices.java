package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feightclient.UserFeighClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserServices.class);

    @Autowired
    private UserFeighClient userFeighClient;

    public User findByEmail(String email){
        User user = userFeighClient.findByEmail(email).getBody();
        if(user == null){
            logger.error("Emails not found:" + email);
            throw new IllegalArgumentException("Emails not found");
        }
        logger.info("Email found:" + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userFeighClient.findByEmail(s).getBody();
        if(user == null){
            logger.error("Email not found:" + s);
            throw  new UsernameNotFoundException("Email not found");
        }
        logger.info("Email found:" + s);
        return user;
    }
}
