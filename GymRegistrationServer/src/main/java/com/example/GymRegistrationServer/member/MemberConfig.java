package com.example.GymRegistrationServer.member;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class MemberConfig {

  @Bean
  CommandLineRunner commandLineRunner(MemberRepository repository) {
    return args -> {
      Member eliot = new Member(
              "Eliot Pardo",
              "eliot.pardo@gmail.com",
              LocalDate.of(1982, Month.NOVEMBER, 23)
      );
      Member joanne = new Member(
              "Joanne Pardo",
              "joanne214@gmail.com",
              LocalDate.of(1983, Month.FEBRUARY, 14)
      );
      repository.saveAll(List.of(eliot, joanne));
    };
  }
}
