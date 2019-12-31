package kr.or.ksmart.ksmart_mybatis.service;

import java.util.List;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.ksmart_mybatis.mapper.MemberMapper;
import kr.or.ksmart.ksmart_mybatis.vo.Member;

@Service
public class MemberService {
	
	@Autowired 
	private MemberMapper memberMapper;
	
	public List<Member> getMemberList(){
		List<Member> list = memberMapper.getMemberList();
		System.out.println(list.toString());
		return memberMapper.getMemberList();
	}
	
	public int addMember(Member member) {
		
		return memberMapper.addMember(member);//mapper 클ㄹ래스 객체 참조변수.addMember();
	}
	public Member getMemberForUpdate(String memberId) {
		
		return memberMapper.getMemberForUpdate(memberId);
	}
	public int memberUpdateInsert(Member member) {
		
		return memberMapper.memberUpdateInsert(member);
	}
	
	public int deleteMember(String memberId) {
		
		return memberMapper.deleteMember(memberId);
	}
	
	public List<Member> serchMember(String sk, String sv) {
		
		return memberMapper.serchMember(sk,sv);
	}
	
	
}
