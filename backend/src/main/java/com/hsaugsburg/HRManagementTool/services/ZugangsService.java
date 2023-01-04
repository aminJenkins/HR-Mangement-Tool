package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.ZugangEntity;
import com.hsaugsburg.HRManagementTool.database.repository.ZugangsRepo;
import com.hsaugsburg.HRManagementTool.dto.authentication.PasswortResetDTO;
import com.hsaugsburg.HRManagementTool.models.SecurityUser;
import com.hsaugsburg.HRManagementTool.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ZugangsService implements UserDetailsService {

    @Autowired
    private ZugangsRepo zugangsRepo;
    private final JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return zugangsRepo.findByUsername(email)
                .map(SecurityUser::new)
                .orElseThrow(() ->
                        new UsernameNotFoundException("No user was found with email " + email));
    }

    public String generateTokenForUser(String email) {
        final UserDetails user = this.loadUserByUsername(email);

        if (user != null) {
            return jwtUtils.generateToken(user);
        } else return null;
    }

    public void resetPassword(PasswortResetDTO passwortResetDTO, String userEmail, String encodedPassword) {
        if (passwordIsConfirmed(passwortResetDTO)) {
            ZugangEntity zugang = zugangsRepo.findByUsername(userEmail).orElseThrow(() ->
                    new UsernameNotFoundException("No user was found with email " + userEmail));
            zugang.setPassword(encodedPassword);
            zugangsRepo.save(zugang);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The new password was not confirmed correctly");
        }
    }

    private boolean passwordIsConfirmed(PasswortResetDTO passwortResetDTO) {
        return passwortResetDTO.getNewPassword().equals(passwortResetDTO.getConfirmPassword());
    }
}
