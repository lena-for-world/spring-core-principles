package hello.core;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class OptionTest {

    @Test
    void optionTestFunc() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(OptionTestClass.class);
    }

    @Configuration
    static class OptionTestClass {

        // 주입할 스프링 빈이 없어도 동작해야할 경우
        // 아래와 같은 옵션들을 이용할 수 있음음
        // Member는 스프링 빈이 아니니까 오류 발생
       @Autowired(required=false)
        public void setNoBean1(Member member1) {
            System.out.println("member1 = " + member1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member2) {
            System.out.println("member2 = " + member2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member3) {
            System.out.println("member3 = " + member3);
        }

    }
}
