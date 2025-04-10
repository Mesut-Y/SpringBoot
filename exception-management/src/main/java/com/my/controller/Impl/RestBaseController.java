package com.my.controller.Impl;

import org.hibernate.grammars.hql.HqlParser.RootEntityContext;

import com.my.entities.RootEntitiy;

public class RestBaseController {
	public <T> RootEntitiy<T> ok(T data){
		return RootEntitiy.ok(data);
	}
	
	public <T> RootEntitiy<T> error(String errorMessage){
		return RootEntitiy.error(errorMessage);
	}
}
