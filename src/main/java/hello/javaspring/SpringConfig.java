package hello.javaspring;

import hello.javaspring.aop.TimeTraceAop;
import hello.javaspring.repository.JdbcMemberRepository;
import hello.javaspring.repository.JpaMemberRepository;
import hello.javaspring.repository.MemberRepository;
import hello.javaspring.repository.MemoryMemberRepository;
import hello.javaspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
