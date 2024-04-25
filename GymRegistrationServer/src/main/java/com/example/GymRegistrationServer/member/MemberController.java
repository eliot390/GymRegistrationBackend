package com.example.GymRegistrationServer.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/member")
public class MemberController {

  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping
  public List<Member> getMembers() {
    return memberService.getMembers();
  }

  @PostMapping
  public void registerNewMember(@RequestBody Member member){
    memberService.addNewMember(member);
  }

  @DeleteMapping(path = "{memberId}")
  public void deleteMember(@PathVariable("memberId") Long id){
    memberService.deleteMember(id);
  }
}
