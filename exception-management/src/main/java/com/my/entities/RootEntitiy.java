package com.my.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootEntitiy<T> {
	private boolean status;
	private T data;
	private String errorMessage;
	
	public RootEntitiy<T> ok(){
		return (new RootEntitiy<T>(true, data, null));
	}
	
	public RootEntitiy<T> error(){
		return (new RootEntitiy<T>(false, null, "Controller Hata Mesajı."));
	}
}
