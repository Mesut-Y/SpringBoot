package com.my.dto;

import com.my.entities.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoDepartment {

	private Integer id;

	private String departmentName;
}
