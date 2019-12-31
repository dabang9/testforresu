package kr.or.ksmart.ksmart_mybatis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_mybatis.service.MemberService;
import kr.or.ksmart.ksmart_mybatis.vo.Member;

@Controller
public class MemberController {
	@Autowired private MemberService memberService; 
	
	//컨테이너 get 방식에 주소요청을 정의
	@GetMapping("/memberList")
	public String memberList(Model model) {
		
		model.addAttribute("memberList", memberService.getMemberList());
		
		return "member/memberList";
	}
	@GetMapping("/memberInsert")
	public String memberInsert() {
		
		return "member/memberInsert";
	}
	
	@PostMapping("/memberInsert")
	public String addMember(Member member) {
		memberService.addMember(member);
		//System.out.println( "member입니다"+ memberId );
		return "redirect:/memberList";
	}
	@GetMapping("/memberUpdate")
	public String getMemberForUpdate(@RequestParam(value="memberId") String memberId,Model model){
		System.out.println("memberId --->>>" + memberId);
		model.addAttribute("getMem", memberService.getMemberForUpdate(memberId));
		return "member/memberUpdate";
	}
	
	@PostMapping("/memberUpdateInsert")
	public String memberUpdateInsert(Member member) {
		memberService.memberUpdateInsert(member);
		//System.out.println( "member입니다"+ memberId );
		return "redirect:/memberList";
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(String memberId) {
		memberService.deleteMember(memberId);
		return "redirect:/memberList";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "/login/login";
	}
	@PostMapping("/login")
	public String login(Member member, HttpSession session,@RequestParam(value="memberId") String memberId,Model model) {
		System.out.println(member.toString() + "<-member");
		Member dbmember = memberService.getMemberForUpdate(member.getMemberId());
		String dbId = dbmember.getMemberId();
		String dbPw = dbmember.getMemberPw();
		if(dbId==null) {
			System.out.println("아이디 없음");
		}else{
			System.out.println(dbId + "<-아이디가 있습니다");
			session.setAttribute("SID", member.getMemberId());
			if(dbPw.equals(member.getMemberPw())) {
			System.out.println("아이디/비밀번호 일치 로그인성공");
			session.setAttribute("SID", member.getMemberId());
			session.setAttribute("SPW", member.getMemberPw());
			session.setAttribute("SLEVEL", member.getMemberLevel());
			session.setAttribute("SNAME", member.getMemberName());
			return "redirect:/";
			}else {
				System.out.println("비번불일치");
			}
		}
		return "redirect:/";
		
	}
	@GetMapping("/logout")
	public String logout( HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@PostMapping("/memberList")
	public String serchMember(String sk,String sv,Model model) {
		model.addAttribute("memberList", memberService.serchMember(sk,sv));
		return "memberList";
	}
	
	
}
