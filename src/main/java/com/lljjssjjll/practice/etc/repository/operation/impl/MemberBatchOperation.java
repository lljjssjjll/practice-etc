package com.lljjssjjll.practice.etc.repository.operation.impl;

import com.lljjssjjll.practice.etc.model.jdbc.JdbcMember;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberBatchOperation {

    private final JdbcTemplate jdbcTemplate;

    public int[] batchInsert(List<JdbcMember> jdbcMemberList) {
        return jdbcTemplate.batchUpdate("insert into member (id, name) values (?, ?)", new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, jdbcMemberList.get(i).getId());
                ps.setString(2, jdbcMemberList.get(i).getName());
            }

            @Override
            public int getBatchSize() {
                return jdbcMemberList.size();
            }
        });

    }
}
