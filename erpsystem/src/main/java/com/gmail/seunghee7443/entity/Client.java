/*
 * User와 거래를 하는 Client를 관리하는 Class
 */

package com.gmail.seunghee7443.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "erp_client_info")
public class Client {
	@Id
	@Column(name = "client_code")
	private String code;
	
	@Column(name= " client_name", length = 30, nullable = false)
	private String name;
	@Column(name = "client_addr", length = 150)
	private String addr;
	@Column(name = "client_manager", length = 30, nullable = false)
	private String manager;
	@Column(name = "client_email", length = 30)
	private String email;
	@Column(name = "client_tel", length = 30, nullable = false)
	private String tel;
}
