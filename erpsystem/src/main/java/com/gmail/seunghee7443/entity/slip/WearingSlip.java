/*
 * 입고 정보를 담는 Class
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
@Table(name = "erp_wearing_slip")
public class WearingSlip extends BaseEntity {
	@Id
	@Column(name = "wslip_no")
	private long wno;
	
	@Column(name = "wslip_title", length = 30)
	private String wtitle;
	@Column(name = "wslip_content")
	private String wcontent;
	@Column(name = "wslip_name")
	private String wname;
	@Column(name = "wslip_count")
	private int wcount;
	
	public void changeWslipTitle(String wtitle) {
		this.wtitle = wtitle;
	}
	
	public void changWslipContent(String wcontent) {
		this.wcontent = wcontent;
	}
}
