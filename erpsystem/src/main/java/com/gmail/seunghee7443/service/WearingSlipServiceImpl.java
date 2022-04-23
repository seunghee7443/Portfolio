package com.gmail.seunghee7443.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gmail.seunghee7443.dto.PageRequestDTO;
import com.gmail.seunghee7443.dto.PageResponseDTO;
import com.gmail.seunghee7443.dto.WearingSlipDTO;
import com.gmail.seunghee7443.entity.slip.WearingSlip;
import com.gmail.seunghee7443.repository.WearingSlipRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class WearingSlipServiceImpl implements WearingSlipService {

	private final WearingSlipRepository wSlipRepository;
	
	// 입고 송장 내용을 입력 받기 위한 Method
	@Override
	public Long WSlipRegister(WearingSlipDTO wSlipDTO) {
		log.info(wSlipDTO);
		
		WearingSlip wSlipEntity = dtoToEntity(wSlipDTO);
		log.info(wSlipEntity);
		
		wSlipRepository.save(wSlipEntity);
		
		return wSlipEntity.getWno();
	}

	// 입고 송장 내용을 읽기 위한 Method
	@Override
	public WearingSlipDTO WSlipRead(Long wno) {
		Optional<WearingSlip> WSlipRead = wSlipRepository.findById(wno);
		
		return WSlipRead.isPresent()?entityToDTO(WSlipRead.get()):null;
	}

	// 입고 송장 내용을 수정하기 위한 Method
	@Override
	public void WSlipModfiy(WearingSlipDTO wSlipDTO) {
		Optional<WearingSlip> WSlipModfiy = wSlipRepository.findById(wSlipDTO.getWno());
		
		if(WSlipModfiy.isPresent()) {
			WearingSlip entity = WSlipModfiy.get();
			entity.changeWslipTitle(wSlipDTO.getWtitle());
			entity.changWslipContent(wSlipDTO.getWcontent());
			wSlipRepository.save(entity);
		}
		
	}

	// 입고 송장을 삭제하기 위한 Method
	@Override
	public void WSlipRemove(Long wno) {
		Optional<WearingSlip> WSlipRemove = wSlipRepository.findById(wno);
		
		if(WSlipRemove.isPresent()) {
			wSlipRepository.deleteById(wno);
		}
		
	}
	
	// 입고 송장 내용의 목록을 표시하기 위한 Method
	@Override
	public PageResponseDTO<WearingSlipDTO, WearingSlip> getWSlipList(PageRequestDTO wSlipRequestDTO) {
		Pageable wSlipPageable = wSlipRequestDTO.getPageable(Sort.by("wno").descending());
		
		Page<WearingSlip> wSlipResult = wSlipRepository.findAll(wSlipPageable);
		
		Function<WearingSlip, WearingSlipDTO> wSlipfn = (entity -> entityToDTO(entity));
		
		return new PageResponseDTO<>(wSlipResult, wSlipfn);
	}

}
