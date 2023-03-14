package com.example.model.response;

import java.time.LocalDateTime;

import com.example.model.BoardB;

import lombok.Data;

@Data
public class BoardBResponseDto {
	private Long id;
	private String title;
	private String content;
	private String writer;
	private int hits;
	private char deleteYn;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public BoardBResponseDto(BoardB entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.writer = entity.getWriter();
		this.hits = entity.getHits();
		this.deleteYn = entity.getDeleteYn();
		this.createdDate = entity.getCreatedDate();
		this.modifiedDate = entity.getModifiedDate();
	}
}
