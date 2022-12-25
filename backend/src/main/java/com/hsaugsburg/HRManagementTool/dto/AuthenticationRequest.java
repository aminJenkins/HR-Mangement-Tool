package com.hsaugsburg.HRManagementTool.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthenticationRequest {

    private String email;
    private String password;

}
