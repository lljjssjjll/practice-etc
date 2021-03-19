package com.lljjssjjll.practice.etc.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;
    @Column(name = "name")
    private String name;

    public Member(String name) {
        this.name = name;
    }
}
