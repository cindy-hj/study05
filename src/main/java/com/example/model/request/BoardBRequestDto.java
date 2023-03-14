package com.example.model.request;

import com.example.model.BoardB;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardBRequestDto {
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private char deleteYn; // 삭제 여부
	
	public BoardB toEntity() {
		return BoardB.builder()
					 .title(title)
					 .content(content)
					 .writer(writer)
					 .hits(0)
					 .deleteYn(deleteYn)
					 .build();
	}
}
