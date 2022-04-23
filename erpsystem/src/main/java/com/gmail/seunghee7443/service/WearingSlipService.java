package com.gmail.seunghee7443.service;

import com.gmail.seunghee7443.dto.PageRequestDTO;
import com.gmail.seunghee7443.dto.PageResponseDTO;
import com.gmail.seunghee7443.dto.WearingSlipDTO;
import com.gmail.seunghee7443.entity.slip.WearingSlip;

public interface WearingSlipService {
	default WearingSlip dtoToEntity(WearingSlipDTO wSlipDTO) {
		WearingSlip entity = WearingSlip.builder()
				.wno(wSlipDTO.getWno())
				.wtitle(wSlipDTO.getWtitle())
				.wcontent(wSlipDTO.getWcontent())
				.wname(wSlipDTO.getWname())
				.wcount(wSlipDTO.getWcount()).build();

		return entity;
	}
	
	default WearingSlipDTO entityToDTO(WearingSlip wSlipEntity) {
		WearingSlipDTO dto = WearingSlipDTO.builder()
				.wno(wSlipEntity.getWno())
				.wtitle(wSlipEntity.getWtitle())
				.wcontent(wSlipEntity.getWcontent())
				.wname(wSlipEntity.getWname())
				.wcount(wSlipEntity.getWcount())
				.regDate(wSlipEntity.getRegDtae())
				.modDate(wSlipEntity.getModDate()).build();
		
		return dto;
	}
	
	// 입고 송장의 정보 삽입을 위한 Method
	public Long WSlipRegister(WearingSlipDTO wSlipDTO);
	
	// 입고 송장의 정보를 읽기위한 Method
	WearingSlipDTO WSlipRead(Long wno);
	
	// 입고 송장의 정보를 수정하기 위한 Method
	void WSlipModfiy(WearingSlipDTO wSlipDTO);
	
	// 출고 송장의 정보를 삭제하기 위한 Method
	void WSlipRemove(Long wno);
	
	// 출고 송장의 Data를 일정한 Page형태로 출력하여 목록을 보기 위한 Method
	public PageResponseDTO <WearingSlipDTO, WearingSlip> getWSlipList(PageRequestDTO wSlipRequestDTO);
	
}
