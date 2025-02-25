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
public class ApiError<T> {  //exception formatı belirlendi.
	private String id;
	private Date errorTime;
	private T errors;  // farklı hata mesajları formatı için generic kullanıldı.
}
