package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.Zugang;
import com.hsaugsburg.HRManagementTool.utils.JwtUtils;
import com.hsaugsburg.HRManagementTool.database.repository.ZugangsRepo;
import com.hsaugsburg.HRManagementTool.models.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZugangsService implements UserDetailsService {

    @Autowired
    private ZugangsRepo zugangsRepo;
    private final JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("loaduser: "+ zugangsRepo);
        return zugangsRepo.findByUsername(email)
                .map(SecurityUser::new)
                .orElseThrow(() ->
                        new UsernameNotFoundException("No user was found with email " + email));
    }

    public String generateTokenForUser(String email) {
        final UserDetails user = this.loadUserByUsername(email);

        if (user != null) {
            return jwtUtils.generateToken(user);
        }
        else return null;
    }
}
