package com.example.appcodingbat.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(length = 600)
    private String description;
//    @Column(length = 600)
    private String method;

//    @Column(columnDefinition = "false")
//    private boolean solved=false;

    @OneToOne
    private Test test;

    @ManyToOne
    private Category category;

}
