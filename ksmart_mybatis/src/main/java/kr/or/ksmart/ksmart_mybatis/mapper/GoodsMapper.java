package kr.or.ksmart.ksmart_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.ksmart_mybatis.vo.Goods;

@Mapper
public interface GoodsMapper {
	
	//접근지정자를 안적어도 인터페이스 안에서는 기본값이 public 
	//public 안써도 크게 에러가 나지 않음
	//전체 회원 리스트 조회
	List<Goods> getGoodsList();
}
