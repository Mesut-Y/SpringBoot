package com.my.entities;

import lombok.Data;

@Data
public class RootEntitiy<E> {
	private boolean status;
	private E data;
	private String message;
}
