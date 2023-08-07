package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.User;
import com.codegym.casestudy_spring_module_4.repository.IUserRepository;
import com.codegym.casestudy_spring_module_4.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " không tồn tại user trong database");
        }
        List<String> roles = userRoleRepository.findAllRoleByUser(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
