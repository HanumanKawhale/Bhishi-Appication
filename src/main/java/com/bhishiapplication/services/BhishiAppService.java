package com.bhishiapplication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhishiapplication.entities.BhishiApp;

@Service
public interface BhishiAppService {

	
	BhishiApp createBhishiApp(BhishiApp bhishiApp);
	
	BhishiApp updateBhishiApp(BhishiApp bhishiApp,Integer BhishiAppId);
	
	void deleteBhishiApp(Integer bhishiAppId); 
	
	BhishiApp getBhishiAppById(Integer bhishiAppId);
	
	List<BhishiApp> getAllBhishi();
	
	
}
