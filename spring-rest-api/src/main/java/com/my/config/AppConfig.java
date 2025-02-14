package com.my.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.my.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "Berat", "B"));
		employeeList.add(new Employee("2", "Su", "T"));
		employeeList.add(new Employee("3", "Toprak", "L"));
		employeeList.add(new Employee("4", "Güneş", "G"));
		employeeList.add(new Employee("5", "Doğa", "D"));
		employeeList.add(new Employee("6", "Su", "D"));
		employeeList.add(new Employee("7", "Doğa", "A"));
		employeeList.add(new Employee("8", "Beril", "B"));
		employeeList.add(new Employee("9", "Sunay", "D"));
		employeeList.add(new Employee("10", "Sunay", "D"));
		employeeList.add(new Employee("11", "Kemal", "S"));
		employeeList.add(new Employee("12", "Barış", "M"));
		employeeList.add(new Employee("13", "Cem", "K"));
		return employeeList;
	}
}
