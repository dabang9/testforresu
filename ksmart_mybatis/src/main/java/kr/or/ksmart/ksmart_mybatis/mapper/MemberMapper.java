package kr.or.ksmart.ksmart_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.ksmart_mybatis.vo.Member;

@Mapper
public interface MemberMapper {
	
	//접근지정자를 안적어도 인터페이스 안에서는 기본값이 public 
	//public 안써도 크게 에러가 나지 않음
	//전체 회원 리스트 조회
	List<Member> getMemberList();
	
	// 회원 등록
	// select 제외한 모든 과정은 int로 반환 됩니다
	int addMember(Member member);
	
	//수정 회원 정보 조회
	Member getMemberForUpdate(String memberId);
	
	//수정된 회원정보 업데이트
	int memberUpdateInsert(Member member);
	
	//회원 삭제
	int deleteMember(String memberId);
	
	//회원검색
	List<Member> serchMember(String sk, String sv);
}
