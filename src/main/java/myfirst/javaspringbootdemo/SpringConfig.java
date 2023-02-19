package myfirst.javaspringbootdemo;

import myfirst.javaspringbootdemo.repository.JdbcMemberRepository;
import myfirst.javaspringbootdemo.repository.JdbcTemplateMemberRepository;
import myfirst.javaspringbootdemo.repository.MemberRepository;
import myfirst.javaspringbootdemo.repository.MemoryMemberRepository;
import myfirst.javaspringbootdemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
