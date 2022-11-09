package com.hsaugsburg.HRManagementTool.database.keys;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZugangsPK implements Serializable {
    private String email;
    private String password;
}
