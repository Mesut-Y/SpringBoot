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
	
	public RootEntitiy<T> ok(T data){
		return (new RootEntitiy<T>(true, data, null));
	}
	
	public RootEntitiy<T> error(String errorMessage){
		return (new RootEntitiy<T>(false, null, errorMessage));
	}
}
