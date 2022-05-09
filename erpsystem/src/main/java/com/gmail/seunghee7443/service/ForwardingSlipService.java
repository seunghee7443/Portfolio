package com.gmail.seunghee7443.service;

import com.gmail.seunghee7443.dto.ForwardingSlipDTO;
import com.gmail.seunghee7443.dto.PageRequestDTO;
import com.gmail.seunghee7443.dto.PageResponseDTO;
import com.gmail.seunghee7443.entity.slip.ForwardingSlip;

public interface ForwardingSlipService {
	default ForwardingSlip dtoToEntity(ForwardingSlipDTO fSlipDTO) {
		ForwardingSlip entity = ForwardingSlip.builder()
				.fno(fSlipDTO.getFno())
				.ftitle(fSlipDTO.getFtitle())
				.fcontent(fSlipDTO.getFcontent())
				.fname(fSlipDTO.getFname())
				.fcount(fSlipDTO.getFcount()).build();
		
		return entity;
	}
	
	default ForwardingSlipDTO entityToDTO(ForwardingSlip fSlipEntity) {
		ForwardingSlipDTO dto = ForwardingSlipDTO.builder()
				.fno(fSlipEntity.getFno())
				.ftitle(fSlipEntity.getFtitle())
				.fcontent(fSlipEntity.getFcontent())
				.fname(fSlipEntity.getFname())
				.fcount(fSlipEntity.getFcount())
				.regDate(fSlipEntity.getRegDate())
				.modDate(fSlipEntity.getModDate()).build();
		
		return dto;
	}
	
	// 출고 송장의 정보 삽입을 위한 Method
	public Long FSlipRegister(ForwardingSlipDTO fSlipDTO);
	
	// 출고 송장의 정보를 읽기위한 Method
	ForwardingSlipDTO FSlipRead(Long fno);
	
	// 출고 송장의 정보를 수정하기 위한 Method
	void FSlipModfiy(ForwardingSlipDTO fSlipDTO);
	
	// 출고 송장의 정보를 삭제하기 위한 Method
	void FSlipRemove(Long fno);
	
	// 출고 송장의 Data를 일정한 Page형태로 출력하여 목록을 보기 위한 Method
	public PageResponseDTO <ForwardingSlipDTO, ForwardingSlip> getFSlipList(PageRequestDTO fSlipRequestDTO);

}
