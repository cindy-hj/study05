package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BoardB;
import com.example.model.request.BoardBRequestDto;
import com.example.model.response.BoardBResponseDto;
import com.example.repository.BoardBRepository;
import com.example.service.BoardBService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardBController {
	
	@Autowired
	private BoardBService boardBService;
//	@Autowired
//	private BoardBRepository boardBRepository;
	
	@PostMapping("/boards")
	public Long save(@RequestBody BoardBRequestDto params) {
		return boardBService.save(params);
	}
	
	@GetMapping("/boards")
	public List<BoardBResponseDto> findAll() {
		return boardBService.findAll();
	}
	
	@DeleteMapping("/boards/{id}")
	public Long delete(@PathVariable Long id) {
		return boardBService.delete(id);
	}
	
	@GetMapping("/boards/delete")
	public List<BoardBResponseDto> findByDeleteYn(char deleteYn) {
		return boardBService.findAllByDeleteYn(deleteYn);
	}
	
	@GetMapping("/boards/find/{id}")
	public BoardBResponseDto findById(@PathVariable Long id) {
		return boardBService.findById(id); 
	}
	
	@DeleteMapping("/boards/delete/{id}")
	public Long findByDeleteYn(@PathVariable Long id) {
		return boardBService.findByDeleteYn(id);
	}
	
	@PatchMapping("/boards/update/{id}")
	public Long save(@PathVariable Long id, @RequestBody BoardBRequestDto params) {
		return boardBService.update(id,params);
	}
	
	@GetMapping("/boards/listall")
	public Page<BoardB> getAllBoardB(@RequestParam("page")Integer page, @RequestParam("size")Integer size){
		PageRequest pageRequest = PageRequest.of(page, size);
//		return boardBRepository.findAll(pageRequest); 가독성과 유지보수 위해서 바로 repository에서 읽어오는것보다 service를 거치는것이 좋다
		return boardBService.findAll(pageRequest);
	}
	
	@GetMapping("/boards/listall1")
	public Page<BoardB> getAllBoardB(Pageable pageable) { // 기본 사이즈 20
//		return boardBRepository.findAll(pageable);
		return boardBService.findAll(pageable);
	}
	/* 작성자를 기준으로 페이지를 나눔 */
	@GetMapping("/boards/writers")
	public Page<BoardB> getBoardBWriter(Pageable pageable) {
		return boardBService.findByWriter("관리자",pageable);
	}
	/* 제목을 기준으로 페이지를 나눔 */
	@GetMapping("/boards/title")
	public Page<BoardB> getBoardBTitle(Pageable pageable) {
		return boardBService.findByTitleLike("%"+"제목"+"%",pageable);
	}
}
