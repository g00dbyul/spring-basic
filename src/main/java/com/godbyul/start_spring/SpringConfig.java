package com.godbyul.start_spring;

import com.godbyul.start_spring.repository.JdbcMemberRepository;
import com.godbyul.start_spring.repository.JdbcTemplateMemberRepository;
import com.godbyul.start_spring.repository.JpaMemberRepository;
import com.godbyul.start_spring.repository.MemberRepository;
import com.godbyul.start_spring.repository.MemoryMemberRepository;
import com.godbyul.start_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
