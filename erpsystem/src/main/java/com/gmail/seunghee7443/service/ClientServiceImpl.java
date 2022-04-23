package com.gmail.seunghee7443.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gmail.seunghee7443.dto.ClientDTO;
import com.gmail.seunghee7443.entity.Client;
import com.gmail.seunghee7443.repository.ClientRepository;
import com.gmail.seunghee7443.util.StringUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
	private final ClientRepository clientRepository;

	// Client의 정보를 저장하기 위한 Method
	@Override
	public String clientRegister(ClientDTO clientDTO) {
		Client entity = dtoToEntity(clientDTO);
		
		clientRepository.save(entity);
		
		return entity.getCode();
	}

	// Client의 정보를 수정하기 위한 Method - 부분 수정
	@Override
	@Transactional
	public void clientModify(String code, ClientDTO clientDTO) throws Exception {
		Optional<Client> cModify = clientRepository.findById(code);
		
		if (cModify.isPresent()) {
			Client client = cModify.get();
			
			if (StringUtils.isBlank(clientDTO.getName())) client.setName(clientDTO.getName());
			if (StringUtils.isBlank(clientDTO.getAddr())) client.setAddr(clientDTO.getAddr());
			if (StringUtils.isBlank(client.getManager())) client.setManager(clientDTO.getManager());
			if (StringUtils.isBlank(clientDTO.getEmail())) client.setEmail(clientDTO.getEmail());
			if (StringUtils.isBlank(clientDTO.getTel())) client.setTel(clientDTO.getTel());
			
			clientRepository.save(client);
		}
		
	}

	// Client의 정보를 삭제하기 위한 Method
	@Override
	public void delete(String code) {
		Optional<Client> result = clientRepository.findById(code);
		
		if (result.isPresent()) {
			clientRepository.deleteById(code);
		}
		
	}

}
