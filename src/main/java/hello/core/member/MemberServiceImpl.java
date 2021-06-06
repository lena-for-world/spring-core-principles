package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 관례상 구현체가 하나만 있을 때는 Impl이라고 많이 씀
@Component
public class MemberServiceImpl implements MemberService{
    // MemberRepository 인터페이스 뿐 아니라 MemoryMemberRepository라는 구현체에도
    // 의존하고 있기 때문에 DIP를 안 지킨 코드
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
