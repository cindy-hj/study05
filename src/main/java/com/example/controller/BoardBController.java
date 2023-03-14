package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.request.BoardBRequestDto;
import com.example.model.response.BoardBResponseDto;
import com.example.service.BoardBService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardBController {
	
	@Autowired
	private BoardBService boardBService;
	
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
}
