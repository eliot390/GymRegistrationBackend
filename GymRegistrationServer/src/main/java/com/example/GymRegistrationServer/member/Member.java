package com.example.GymRegistrationServer.member;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Member {
  @Id
  @SequenceGenerator(
          name = "member_sequence",
          sequenceName = "member_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "member_sequence"
  )
  private Long id;
  private String name;
  private String email;
  private LocalDate birthday;
  @Transient
  private Integer age;

  public Member() {
  }

  public Member(Long id, String name, String email, LocalDate birthday) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birthday = birthday;
  }

  public Member(String name, String email, LocalDate birthday) {
    this.name = name;
    this.email = email;
    this.birthday = birthday;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public Integer getAge() {
    return Period.between(this.birthday, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
