package com.my.dto;

import java.math.BigDecimal;
import java.util.List;

import com.my.entities.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoHome {

	private Integer id;
	
	private BigDecimal price;
	
	private List<Room> rooms;
}
