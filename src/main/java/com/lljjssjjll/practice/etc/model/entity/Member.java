package com.lljjssjjll.practice.etc.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id
    @With
    private Integer id;
    private final String name;

    public Member(String name) {
        this.name = name;
    }
}
