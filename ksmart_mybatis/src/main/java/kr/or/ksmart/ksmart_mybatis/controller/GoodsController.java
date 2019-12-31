package kr.or.ksmart.ksmart_mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.ksmart_mybatis.service.GoodsService;


@Controller
public class GoodsController {
	@Autowired private GoodsService goodsService; 
	
	//컨테이너 get 방식에 주소요청을 정의
	@GetMapping("/goodsList")
	public String goodsList(Model model) {
		
		model.addAttribute("goodsList", goodsService.getGoodsList());
		
		return "goods/goodsList";
	}
}
