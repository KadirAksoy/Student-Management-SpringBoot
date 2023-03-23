package com.kadiraksoy.StudentManagement.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String name;
    private String lastName;
    private String email;
}
