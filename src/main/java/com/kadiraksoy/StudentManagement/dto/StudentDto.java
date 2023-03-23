package com.kadiraksoy.StudentManagement.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentDto {

    private String name;
    private String lastName;
    private String email;
}
