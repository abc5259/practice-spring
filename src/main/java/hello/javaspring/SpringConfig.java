package hello.javaspring;

import hello.javaspring.repository.MemberRepository;
import hello.javaspring.repository.MemoryMemberRepository;
import hello.javaspring.service.MemberService;
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
