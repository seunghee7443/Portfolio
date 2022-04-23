/*
 * 출고 정보를 담는 Class
 */

package com.gmail.seunghee7443.entity.slip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gmail.seunghee7443.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "erp_forwarding_slip")
public class ForwardingSlip extends BaseEntity {
	@Id
	@Column(name = "fslip_no")
	private long fno;
	
	@Column(name = "fslip_title")
	private String ftitle;
	@Column(name = "fslip_content")
	private String fcontent;
	@Column(name = "fslip_name")
	private String fname;
	@Column(name = "fslip_count")
	private int fcount;
	
	public void changeFslipTitle(String ftitle) {
		this.ftitle = ftitle;
	}
	
	public void changeFslipContent(String fcontent) {
		this.fcontent = fcontent;
	}
}
