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
public class ForwardingSlipDTO {
	private long fno;
	private String ftitle;
	private String fcontent;
	private String fname;
	private int fcount;
	
	private LocalDateTime regDate;
	private LocalDateTime modDate;
}
