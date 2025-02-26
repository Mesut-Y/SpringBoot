package com.my.services.impl;

import java.beans.beancontext.BeanContext;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dto.DtoHome;
import com.my.entities.Home;
import com.my.repository.HomeRepository;
import com.my.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{

	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public DtoHome getHomeById(Integer id) {
		Home dbHome = new Home();
		DtoHome dtoHome = new DtoHome();
		Optional<Home> opt = homeRepository.findById(id);
		if (opt.isEmpty())
			return null;
		else {
			dbHome = opt.get();
			dbHome.setRooms(opt.get().getRooms());
			
			BeanUtils.copyProperties(dbHome, dtoHome);
			return dtoHome;
		}
		
	}

}
