package com.lljjssjjll.practice.etc.model.jdbc;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(value = "member")
public class JdbcMember {

    @Id
    @With
    private Integer id;
    private final String name;

    public JdbcMember(String name) {
        this.name = name;
    }
}
