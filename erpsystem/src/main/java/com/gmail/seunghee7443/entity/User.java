/*
 * 사용자의 정보를 담는 Class
 */

package com.gmail.seunghee7443.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "erp_user_info")
public class User {
	@Id
	@Column(name = "user_id")
	private String id;

	@Column(name = "user_pw", nullable = false)
	private String pw;
	@Column(name = "user_name", length = 15, nullable = false)
	private String name;
	@Column(name = "user_dep", length = 10)
	private String dep;
	@Column(name = "user_email", length = 30)
	private String email;
	@Column(name = "user_tel", length = 30)
	private String tel;
	
	@Builder.Default
	@ElementCollection(fetch = FetchType.LAZY)
	private Set<UserRole> roleSet = new HashSet<>();
	
	public void addUserRole(UserRole userRole) {
		roleSet.add(userRole);
	}
}
