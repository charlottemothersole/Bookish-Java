package com.bookishjava.repositories;

import com.bookishjava.models.database.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    Member findByTitle(String title);
}
