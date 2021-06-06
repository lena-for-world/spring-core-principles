package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // bean의 이름은 메서드의 이름으로 등록되는 것이 기본
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "Aespa", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember((1L));
        System.out.println("new member: " + member.getName());
        System.out.println("find Member: " + findMember.getName());
    }
}
