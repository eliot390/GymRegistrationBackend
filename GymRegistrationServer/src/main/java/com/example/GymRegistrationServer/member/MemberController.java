package com.example.GymRegistrationServer.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

  @Autowired
  private MemberRepository memberRepository;
  @GetMapping("/{id}")
  /**
   * Get single user
   * http://localhost:8080/api/v1/member/4
   * @param id
   */
  public ResponseEntity<Member> getMemberById(@PathVariable Long id){
    return memberRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  /**
   * Add new member
   * @param member
   * {
   *     "name": "Cheddar",
   *     "email": "cheds@gmail.com",
   *     "birthday": "2022-07-26"
   * }
   */
  public void registerNewMember(@RequestBody Member member){
    memberService.addNewMember(member);
  }

  @DeleteMapping(path = "{memberId}")
  /**
   * http://localhost:8080/api/v1/member/4
   * @param id
   */
  public void deleteMember(@PathVariable("memberId") Long id){
    memberService.deleteMember(id);
  }

  @PutMapping(path = "{memberId}")
  /**
   * Update/change member info
   * http://localhost:8080/api/v1/member/4?name=Name&email=Email
   * @param id
   * @param name
   * @param email
   */
  public void updateMember(@PathVariable("memberId") Long id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email) {
    memberService.updateMember(id, name, email); }
}
