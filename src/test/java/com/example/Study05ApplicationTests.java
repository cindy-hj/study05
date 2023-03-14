package com.example;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.BoardB;
import com.example.repository.BoardBRepository;

@SpringBootTest
class Study05ApplicationTests {
	
//	@Test
//	void contextLoads() {
//	}
	@Autowired
	BoardBRepository boardBRepository;
	
	@Test
	public void save() {
		BoardB params = BoardB.builder()
							  .title("1번 게시글 제목")
							  .content("1번 게시글 내용")
							  .writer("홍길동")
							  .hits(0)
							  .deleteYn('N')
							  .build();
		boardBRepository.save(params);
		
		BoardB entity = boardBRepository.findById(1L).get();
		System.out.println(entity);
	}
	
	@Test
	public void save20() {
		for(int i=2; i<=20; i++) {
			BoardB params = BoardB.builder()
								  .title(i+"번 게시글 제목")
								  .content(i+"번 게시글 내용")
								  .writer("관리자")
								  .hits(0)
								  .deleteYn('N')
								  .build();
			
			boardBRepository.save(params);
		}
		List<BoardB> boards = boardBRepository.findAll();
		for(BoardB board:boards) {
			System.out.println(board);
		}
	}
	
	public void delete() {
		BoardB entity = boardBRepository.findById(1L).get();
		boardBRepository.delete(entity);
		
	}
}
