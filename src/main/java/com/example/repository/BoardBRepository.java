package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.BoardB;

public interface BoardBRepository extends JpaRepository<BoardB, Long> {

	List<BoardB> findAllByDeleteYn(char deleteYn);

	Page<BoardB> findByWriter(String string, Pageable pageable);

	Page<BoardB> findByTitleLike(String string, Pageable pageable);
	
}
