package com.gmail.seunghee7443;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gmail.seunghee7443.entity.Client;
import com.gmail.seunghee7443.entity.User;
import com.gmail.seunghee7443.entity.UserRole;
import com.gmail.seunghee7443.repository.ClientRepository;
import com.gmail.seunghee7443.repository.UserRepository;
import com.gmail.seunghee7443.service.UserService;

@SpringBootTest
public class EntityTest {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@Test
	public void insertUserData() {
		for(int i = 1; i <= 30; i = i + 1) {
			User user = User.builder()
					.id("test"+i)
					.pw(passwordEncoder.encode("8468"))
					.name("Tester" + i)
					.dep("사원")
					.email("user" + i + "@gmail.com")
					.tel("0101232345").build();
			
			user.addUserRole(UserRole.USER);
			if(i > 25) {
				user.addUserRole(UserRole.ACCOUNTDEP);
			}
			
			if(i == 30) {
				user.addUserRole(UserRole.ADMIN);
			}

			userRepository.save(user);
		}
	}
	 
	//@Test
	public void updateUserData() {
		User user = User.builder()
				.id("test1")
				.pw("1111")
				.name("kim")
				.dep("대리")
				.email("kim1@gmail.com")
				.tel("0101112222").build();
		
		userRepository.save(user);
	}
	
	//@Test
	public void deleteUserData() {
		User user = User.builder()
				.id("test1")
				.pw("1111")
				.name("kim")
				.dep("대리")
				.email("kim1@gmail.com")
				.tel("0101112222").build();
		
		userRepository.delete(user);
	}
	
	@Autowired
	private ClientRepository clientRepository;
	
	//@Test
	public void insertClientData() {
		for(int i = 100; i <= 130; i = i + 1) {
			Client client = Client.builder()
					.code("TestShop" + i)
					.name("show" + i)
					.addr("Sample Addr" + i)
					.manager("Manager" + i)
					.email("manager" + i + "@gmail.com")
					.tel("0103334455").build();
			
			clientRepository.save(client);
		}
	}
	
	//@Test
	public void updateClientData() {
		Client client = Client.builder()
				.code("TestShop101")
				.name("change101")
				.addr("change101")
				.manager("Manager Kim")
				.email("kimmanager@gmail.com")
				.tel("08033237766").build();
		
		clientRepository.save(client);
	}

	//@Test
	public void deleteClientData() {
		Client client = Client.builder().code("TestShop103").build();
		
		clientRepository.delete(client);
	}
}
