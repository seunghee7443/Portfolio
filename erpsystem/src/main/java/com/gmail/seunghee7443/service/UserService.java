/*
 * User Data관련 Entity ←→ DTO간의 변환을 위한 Code작성
 */

package com.gmail.seunghee7443.service;

import com.gmail.seunghee7443.dto.UserDTO;
import com.gmail.seunghee7443.entity.User;

public interface UserService {
	// DTO Class의 Instance → Entity Class의 Instance로 변환
	default User dtoToEntity(UserDTO userDTO) {
		User entity = User.builder()
				.id(userDTO.getId())
				.pw(userDTO.getPw())
				.name(userDTO.getName())
				.dep(userDTO.getDep())
				.email(userDTO.getEmail())
				.tel(userDTO.getTel()).build();
		
		return entity;
	}
	
	// Entity Class의 Instance → DTO Class의 Instance로 변환
	default UserDTO entityToDTO(User user) {
		UserDTO dto = UserDTO.builder()
				.id(user.getId())
				.pw(user.getPw())
				.name(user.getName())
				.dep(user.getDep())
				.email(user.getEmail())
				.tel(user.getTel()).build();
		
		return dto;
	}
	
	// User의 정보를 삽입하기 위한 Method
	public String userRegister(UserDTO userDTO);

	// User의 정보를 삭제하기 위한 Method
	public void userModfiy(String id, final UserDTO userDTO) throws Exception;
	
	// User의 정보를 삭제하기 위한 Method
	public void delete(String id);
}
