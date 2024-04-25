package com.example.GymRegistrationServer.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

  @Query("SELECT m FROM Member m WHERE m.email = ?1")
  Optional<Member> findMemberByEmail(String email);
}
