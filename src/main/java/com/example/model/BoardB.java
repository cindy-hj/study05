package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // repository없어도 형식만 맞으면 entity 때문에 테이블 생성가능
@Data
@NoArgsConstructor
@Table(name="boardb")
public class BoardB {
	@Id // 테이블에는 항상 키가 존재해야함
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private int hits; // 조회수
	private char deleteYn; // 삭제 여부
	private LocalDateTime createdDate = LocalDateTime.now(); // 생성일
	private LocalDateTime modifiedDate; // 수정일
	
	@Builder
	public BoardB(String title, String content, String writer, int hits, char deleteYn) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hits = hits;
		this.deleteYn = deleteYn;
	}

	public void delete() {
		this.deleteYn = 'Y';
	}

	public void update(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.modifiedDate = LocalDateTime.now();
	}
}
