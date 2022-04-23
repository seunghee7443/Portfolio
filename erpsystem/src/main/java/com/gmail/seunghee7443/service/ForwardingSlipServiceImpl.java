package com.gmail.seunghee7443.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gmail.seunghee7443.dto.ForwardingSlipDTO;
import com.gmail.seunghee7443.dto.PageRequestDTO;
import com.gmail.seunghee7443.dto.PageResponseDTO;
import com.gmail.seunghee7443.entity.slip.ForwardingSlip;
import com.gmail.seunghee7443.repository.ForwardingSlipRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ForwardingSlipServiceImpl implements ForwardingSlipService {
	private final ForwardingSlipRepository fSlipRepository;

	// 출고 송장 내용을 입력 받기 위한 Method
	@Override
	public Long FSlipRegister(ForwardingSlipDTO fSlipDTO) {
		log.info(fSlipDTO);
		
		ForwardingSlip fSlipEntity = dtoToEntity(fSlipDTO);
		log.info(fSlipEntity);
		
		fSlipRepository.save(fSlipEntity);
		
		return fSlipEntity.getFno();
	}
	
	// 출고 송장 내용을 읽기 위한 Method
	@Override
	public ForwardingSlipDTO FSlipRead(Long fno) {
		Optional<ForwardingSlip> FSlipRead = fSlipRepository.findById(fno);
		
		return FSlipRead.isPresent()?entityToDTO(FSlipRead.get()):null;
	}

	// 출고 송장 내용을 수정하기 위한 Method
	@Override
	public void FSlipModfiy(ForwardingSlipDTO fSlipDTO) {
		Optional<ForwardingSlip> FSlipModfiy = fSlipRepository.findById(fSlipDTO.getFno());
		
		if(FSlipModfiy.isPresent()) {
			ForwardingSlip entity = FSlipModfiy.get();
			entity.changeFslipTitle(fSlipDTO.getFtitle());
			entity.changeFslipContent(fSlipDTO.getFcontent());
			fSlipRepository.save(entity);
		}
		
	}

	// 출고 송장을 삭제하기 위한 Method
	@Override
	public void FSlipRemove(Long fno) {
		Optional<ForwardingSlip> FSlipremove = fSlipRepository.findById(fno);
		
		if(FSlipremove.isPresent()) {
			fSlipRepository.deleteById(fno);
		}
		
	}
	
	// 출고 송장 내용의 목록을 표시하기 위한 Method
	@Override
	public PageResponseDTO<ForwardingSlipDTO, ForwardingSlip> getFSlipList(PageRequestDTO fSlipRequestDTO) {
		Pageable fSlipPageable = fSlipRequestDTO.getPageable(Sort.by("fno").descending());
		
		Page<ForwardingSlip> fSlipResult = fSlipRepository.findAll(fSlipPageable);
		
		Function<ForwardingSlip, ForwardingSlipDTO> fSlipfn = (entity -> entityToDTO(entity));
		
		return new PageResponseDTO<>(fSlipResult, fSlipfn);
	}

}
