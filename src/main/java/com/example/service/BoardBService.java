package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.BoardB;
import com.example.model.request.BoardBRequestDto;
import com.example.model.response.BoardBResponseDto;
import com.example.repository.BoardBRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardBService {
	
	@Autowired
	private BoardBRepository boardBRepository;
	
	@Transactional
	public Long save(BoardBRequestDto params) {
		BoardB entity = boardBRepository.save(params.toEntity());
		return entity.getId();
	}

	public List<BoardBResponseDto> findAll() {
		List<BoardB> list = boardBRepository.findAll();
		return list.stream().map(BoardBResponseDto::new).collect(Collectors.toList());
	}

	@Transactional
	public Long delete(Long id) {
		BoardB entity = boardBRepository.findById(id).orElseThrow(null);
		entity.delete();
		return id;
	}

	public List<BoardBResponseDto> findAllByDeleteYn(char deleteYn) {
		List<BoardB> list = boardBRepository.findAllByDeleteYn(deleteYn);
		return list.stream().map(BoardBResponseDto::new).collect(Collectors.toList());
	}

	public BoardBResponseDto findById(Long id) {
		Optional<BoardB> boardB = boardBRepository.findById(id); 
		return new BoardBResponseDto(boardB.get());
	}

	@Transactional
	public Long findByDeleteYn(Long id) {
		boardBRepository.deleteById(id);
		return id;
	}

	@Transactional
	public Long update(Long id, BoardBRequestDto params) {
		BoardB entity = boardBRepository.findById(id).get();
		entity.update(params.getTitle(), params.getContent(), params.getWriter());
		return id;
	}
}
