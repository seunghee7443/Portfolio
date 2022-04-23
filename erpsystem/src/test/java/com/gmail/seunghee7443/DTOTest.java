package com.gmail.seunghee7443;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gmail.seunghee7443.dto.UserDTO;
import com.gmail.seunghee7443.service.UserService;

@SpringBootTest
public class DTOTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void registerTest() {
		UserDTO userDTO = UserDTO.builder()
				.id("user1")
				.pw("2222")
				.name("user1")
				.dep("과장")
				.email("newtest1@gmail.com")
				.tel("0103334444").build();
		
		String id = userService.userRegister(userDTO);
		
		System.out.println(id);
	}
}
