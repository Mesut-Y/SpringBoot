package com.my.exception;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {  //exception formatı belirlendi.
	private String id;
	private Date errorTime;
	private Map<String, List<String>> errors;
}
