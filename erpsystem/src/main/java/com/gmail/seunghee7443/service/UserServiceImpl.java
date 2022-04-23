/*
 * UserService Interface을 주입받아 처리하는 Class
 */

package com.gmail.seunghee7443.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gmail.seunghee7443.dto.UserDTO;
import com.gmail.seunghee7443.entity.User;
import com.gmail.seunghee7443.repository.UserRepository;
import com.gmail.seunghee7443.util.StringUtils;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public String userRegister(UserDTO userDTO) {
		User entity = dtoToEntity(userDTO);
		
		userRepository.save(entity);
		
		return entity.getId();
	}
	
	@Override
	@Transactional		// DB에 작업완료가 commit or rollback 되도록 설정한 Annotation
	public void userModfiy(String id, UserDTO userDTO) throws Exception {
		Optional<User> uModify = userRepository.findById(id);

		if(uModify.isPresent()) {
			User user = uModify.get();
			if (StringUtils.isBlank(userDTO.getPw())) user.setPw(userDTO.getPw());
			if (StringUtils.isBlank(userDTO.getName())) user.setName(userDTO.getName());
			if (StringUtils.isBlank(userDTO.getDep())) user.setDep(userDTO.getDep());
			if (StringUtils.isBlank(userDTO.getEmail())) user.setEmail(userDTO.getEmail());
			if (StringUtils.isBlank(userDTO.getTel())) user.setTel(userDTO.getTel());
			
			userRepository.save(user);
		}

	}
	
	@Override
	public void delete(String id) {
		Optional<User> result = userRepository.findById(id);
		
		if(result.isPresent()) {
			userRepository.deleteById(id);
		}
		
	}

}
