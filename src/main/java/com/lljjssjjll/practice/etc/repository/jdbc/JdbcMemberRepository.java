package com.lljjssjjll.practice.etc.repository.jdbc;

import com.lljjssjjll.practice.etc.model.jdbc.JdbcMember;
import org.springframework.data.repository.CrudRepository;

public interface JdbcMemberRepository extends CrudRepository<JdbcMember, Integer> {
}
