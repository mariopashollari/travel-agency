package com.sda.travel_agency_project.security;

import com.sda.travel_agency_project.entities.AgencyUser;
import com.sda.travel_agency_project.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
             AgencyUser user = userRepository.findByUsername(username).orElseThrow();
            return new UserDetailsImpl(user);
    }

}
