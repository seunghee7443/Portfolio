/*
 * Client Data관련 Entity ←→ DTO간의 변환을 위한 Code작성
 */

package com.gmail.seunghee7443.service;

import com.gmail.seunghee7443.dto.ClientDTO;
import com.gmail.seunghee7443.entity.Client;

public interface ClientService {
	
	// Client Class의 Instance → Entity Class의 Instance로 변환
	default Client dtoToEntity(ClientDTO clientDTO) {
		Client entity = Client.builder()
				.code(clientDTO.getCode())
				.name(clientDTO.getName())
				.addr(clientDTO.getAddr())
				.manager(clientDTO.getManager())
				.email(clientDTO.getEmail())
				.tel(clientDTO.getTel()).build();
		
		return entity;
	}
	
	// Entity Class의 Instance → DTO Class의 Instance로 변환
	default ClientDTO entityToDTO(Client client) {
		ClientDTO dto = ClientDTO.builder()
				.code(client.getCode())
				.name(client.getName())
				.addr(client.getAddr())
				.manager(client.getManager())
				.email(client.getEmail())
				.tel(client.getTel()).build();
		
		return dto;
	}
	
	// 신규 Client 정보를 입력하기 위한 Method
	public String clientRegister(ClientDTO clientDTO);
	
	// Client의 정보를 수정하기 위한 Method
	public void clientModify(String code, ClientDTO clientDTO) throws Exception;
	
	// Client의 정보를 삭제하기 위한 Method
	public void delete(String code);
}
