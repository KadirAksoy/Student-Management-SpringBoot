package com.kadiraksoy.StudentManagement.model;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Student")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "last_name")
    @NotNull
    private String lastName;
    @Column(name = "email")
    @NotNull
    private String email;
}
