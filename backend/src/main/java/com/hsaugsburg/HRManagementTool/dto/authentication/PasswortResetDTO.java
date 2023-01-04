package com.hsaugsburg.HRManagementTool.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PasswortResetDTO {
    String oldPassword;
    String newPassword;
    String confirmPassword;
}
