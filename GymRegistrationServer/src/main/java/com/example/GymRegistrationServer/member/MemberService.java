package com.example.GymRegistrationServer.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

  private final MemberRepository memberRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public List<Member> getMembers() {
    return memberRepository.findAll();
  }

  public void addNewMember(Member member) {
    Optional<Member> memberByEmail = memberRepository.findMemberByEmail(member.getEmail());
    if (memberByEmail.isPresent()){
      throw new IllegalStateException("Email already exists");
    }
    memberRepository.save(member);
  }

  public void deleteMember(Long id) {
    boolean exists = memberRepository.existsById(id);
    if (!exists){
      throw new IllegalStateException("Member ID '" + id + "' does not exist.");
    }
    memberRepository.deleteById(id);
  }
}
