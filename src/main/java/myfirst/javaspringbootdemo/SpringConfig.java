package myfirst.javaspringbootdemo;

import myfirst.javaspringbootdemo.repository.MemberRepository;
import myfirst.javaspringbootdemo.repository.MemoryMemberRepository;
import myfirst.javaspringbootdemo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
