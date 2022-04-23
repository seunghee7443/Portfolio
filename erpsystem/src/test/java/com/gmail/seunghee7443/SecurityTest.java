package com.gmail.seunghee7443;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SecurityTest {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@Test
	public void EncodingTest() {
		String password = "8468";
		
		String enPW = passwordEncoder.encode(password);
		
		System.out.println("Encoding WP :" + enPW);
		
		// 비교
		System.out.println("비교 : " + passwordEncoder.matches(password, enPW));
	}

}
