package com.lljjssjjll.practice.etc;

import com.lljjssjjll.practice.etc.model.entity.Member;
import com.lljjssjjll.practice.etc.model.jdbc.JdbcMember;
import com.lljjssjjll.practice.etc.repository.MemberRepository;
import com.lljjssjjll.practice.etc.repository.jdbc.JdbcMemberRepository;
import com.lljjssjjll.practice.etc.repository.operation.impl.MemberBatchOperation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DisplayName("Batch insert 테스트")
public class BatchInsertTests {

    private static final int ROW = 5000;
    @Autowired
    private JdbcMemberRepository jdbcMemberRepository;
    @Autowired
    private MemberBatchOperation memberBatchOperation;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("ID 자동 생성 - non JPA")
    void test_01() {
        // Given
        List<JdbcMember> jdbcMemberList = IntStream.range(1, ROW + 1)
                .mapToObj(i -> new JdbcMember(Integer.toString(i)))
                .collect(Collectors.toList());
        // When
        List<JdbcMember> savedJdbcMemberList = new ArrayList<>();
        jdbcMemberRepository.saveAll(jdbcMemberList).forEach(savedJdbcMemberList::add);
        // Then
        assertTrue(savedJdbcMemberList.stream().noneMatch(member -> Objects.isNull(member.getId())));
    }

    @Test
    @DisplayName("ID 수동 생성 - JDBC")
    void test_02() {
        // Given
        List<JdbcMember> jdbcMemberList = IntStream.range(1, ROW + 1)
                .mapToObj(i -> new JdbcMember(Integer.toString(i)).withId(i))
                .collect(Collectors.toList());
        // When
        int[] savedCntArr = memberBatchOperation.batchInsert(jdbcMemberList);
        // Then
        assertEquals(ROW, savedCntArr.length);
    }

    @Test
    @DisplayName("ID 자동 생성 - JPA")
    void test_03() {
        // Given
        List<Member> memberList = IntStream.range(1, ROW + 1)
                .mapToObj(i -> new Member(Integer.toString(i)))
                .collect(Collectors.toList());
        // When
        List<Member> savedMemberList = memberRepository.saveAll(memberList);
        // Then
        assertTrue(savedMemberList.stream().noneMatch(member -> Objects.isNull(member.getId())));
    }
}
