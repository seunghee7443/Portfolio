package com.gmail.seunghee7443.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gmail.seunghee7443.dto.ClientDTO;
import com.gmail.seunghee7443.entity.Client;
import com.gmail.seunghee7443.repository.ClientRepository;

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

	
	@Override
	@Transactional
	public void clientModify(String code, ClientDTO clientDTO) throws Exception {
		Optional<Client> cModify = clientRepository.findById(code);
		
		if (cModify.isPresent()) {
			Client client = cModify.get();
			
			if (S)
		}
		
	}

	@Override
	public void delete(String code) {
		// TODO Auto-generated method stub
		
	}

}
