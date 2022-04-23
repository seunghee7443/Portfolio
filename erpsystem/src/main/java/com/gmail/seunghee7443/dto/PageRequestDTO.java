package com.gmail.seunghee7443.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class PageRequestDTO {
	private int page;		// page를 받기 위한 변수
	private int size;		// page에 표시할 크기(갯수)
	
	// Page 표기 기본 설정을 위한 부분 (1page당 10EA의 목록을 표기)
	public PageRequestDTO() {
		page = 1;
		size = 10;
	}
	
	// page, size이용하여 pageable객채 생성 및 Return 하는 Method
	public Pageable getPageable(Sort sort) {
		return PageRequest.of(page-1, size, sort);
	}
}
