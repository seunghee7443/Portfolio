/*
 * 사용자의 정보를 가지고 서로 다른 계층에 주고받기 위해 생성한 객체
 */

package com.gmail.seunghee7443.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String id;
	private String pw;
	private String name;
	private String dep;
	private String email;
	private String tel;
}
