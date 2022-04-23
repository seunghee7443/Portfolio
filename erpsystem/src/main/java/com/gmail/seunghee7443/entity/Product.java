package com.gmail.seunghee7443.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "erp_product_info")
public class Product {
	@Id
	@Column(name = "product_num")
	private long pno; 
	
	@Column(name = "product_code", length = 30)
	private String code;
	@Column(name = "product_name")
	private String name;
	@Column(name = "product_count")
	private long count;
	@Column(name = "product_cost")
	private int cost;
}
