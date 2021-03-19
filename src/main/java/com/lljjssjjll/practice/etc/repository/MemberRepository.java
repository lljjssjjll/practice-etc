package com.lljjssjjll.practice.etc.repository;

import com.lljjssjjll.practice.etc.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
