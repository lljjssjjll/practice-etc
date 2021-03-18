package com.lljjssjjll.practice.etc.repository;

import com.lljjssjjll.practice.etc.model.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}
