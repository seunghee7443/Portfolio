/*
 * Security 관련 config를 위한 Class
 */

package com.gmail.seunghee7443.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Password를 암호화 - 복호화 불가, 평문과 비교 가능
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Create Instance and Return
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Page 넘어가는 Code의 경우 화면구성이 완료 될 시 추가 예정
		
		
		http.csrf().disable();
	}
	
}
