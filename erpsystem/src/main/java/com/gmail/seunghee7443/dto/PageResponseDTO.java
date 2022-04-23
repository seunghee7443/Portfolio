package com.gmail.seunghee7443.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResponseDTO<DTO, EN> {
	// 목록을 보기 위해 만든 List (DTO : 출력할 DTO Class / EN : Entity Class)
	private List<DTO> dtoList;			// 목록을 호출시 List형태로 출력하기 위해 선언
	private List<Integer> pageList;		// Page의 No List
	private int totalPage;				// 전체 Page의 수
	
	private int page;					// Page의 No
	private int size;					// 1Page당 표기될 크기
	
	private int start;					// Page의 시작 번호
	private int end;					// Page의 종료 번호
	
	private boolean prev;				// 이전 Page Link 유무
	private boolean next;				// 다음 Page Link 유무
	
	private void makePageList(Pageable pageable) {
		// 일반적인 Program에서는 0부터 시작하기에 1Page를 표기 하기 위해선 기존 page에 1을 더해야 함
		this.page = pageable.getPageNumber() + 1;
		this.size = pageable.getPageSize();
		
		// 시작 Page를 계산하기위해 작성된 함수 (15EA의 Page를 표기)
		int tempEnd = (int)(Math.ceil(page / 10.0)) * 15;
		start = tempEnd - 14;
		
		prev = start > 1;
		end = totalPage > tempEnd ? tempEnd : totalPage;
		next = totalPage > tempEnd;
		
		pageList = new ArrayList<>();
		for(int i = start; i <= end; i = i + 1) {
			pageList.add(i);
		}
	}
	
	// Page의 내용을 위에서 선언한 List형태(dtoList)로 만들기 위한 Method 선언
	public PageResponseDTO(Page<EN> result, Function<EN, DTO> fn) {
		// stream : 순회 / map : 변환(Function<EN, DTO>를 변환) / collect : Collectors를 생성해주는 Method
		dtoList = result.stream().map(fn).collect(Collectors.toList());
	}
}
