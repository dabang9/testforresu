package kr.or.ksmart.ksmart_mybatis.service;

import java.util.List;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.ksmart_mybatis.mapper.GoodsMapper;
import kr.or.ksmart.ksmart_mybatis.vo.Goods;

@Service
public class GoodsService {
	
	@Autowired 
	private GoodsMapper goodsMapper;
	
	public List<Goods> getGoodsList(){
	
		return goodsMapper.getGoodsList();
	}
}
