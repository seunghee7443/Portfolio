package com.gmail.seunghee7443.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WearingSlipDTO {
	private long wno;
	private String wtitle;
	private String wcontent;
	private String wname;
	private int wcount;
	
	private LocalDateTime regDate;
	private LocalDateTime modDate;
}
