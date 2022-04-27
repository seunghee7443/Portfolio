package com.gmail.seunghee7443.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private long pno;
	private String code;
	private String name;
	private long count;
	private int cost;
}
