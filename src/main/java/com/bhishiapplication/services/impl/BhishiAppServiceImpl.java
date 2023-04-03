package com.bhishiapplication.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhishiapplication.entities.BhishiApp;
import com.bhishiapplication.exception.ResourceNotFoundException;
import com.bhishiapplication.repositories.BhishiAppRepository;
import com.bhishiapplication.services.BhishiAppService;
@Service
public class BhishiAppServiceImpl implements BhishiAppService {

	@Autowired
	private BhishiAppRepository bhishiAppRepository;
	
	
	@Override
	public BhishiApp createBhishiApp(BhishiApp bhishiApp) {
		
		BhishiApp app = this.bhishiAppRepository.save(bhishiApp);
		return app;
	}
	

	@Override
	public BhishiApp updateBhishiApp(BhishiApp bhishiApp, Integer bhishiAppId) {
						
		BhishiApp bhishiApp2	=this.bhishiAppRepository.findById(bhishiAppId)
				.orElseThrow(()-> new ResourceNotFoundException("BhishiApp","id",bhishiAppId));
		
		bhishiApp2.setBhishiName(bhishiApp.getBhishiName());
		bhishiApp2.setStartDate(bhishiApp.getStartDate());
		bhishiApp2.setEndDate(bhishiApp.getEndDate());
		bhishiApp2.setAmount(bhishiApp.getAmount());
		bhishiApp2.setNoOfMember(bhishiApp.getNoOfMember());
		bhishiApp2.setDiscription(bhishiApp.getDiscription());
		
		BhishiApp app= this.bhishiAppRepository.save(bhishiApp2);
		return app;
		  
	}

	
	@Override
	public void deleteBhishiApp(Integer bhishiAppId) {
	
		BhishiApp bhishiApp = this.bhishiAppRepository.findById(bhishiAppId)
				.orElseThrow(()-> new ResourceNotFoundException("BhishiApp","id",bhishiAppId));
		this.bhishiAppRepository.delete(bhishiApp);
	}

	
	@Override
	public BhishiApp getBhishiAppById(Integer bhishiAppId) {
	    BhishiApp bhishiApp = this.bhishiAppRepository.findById(bhishiAppId)
	    		.orElseThrow(()-> new ResourceNotFoundException("BhishiApp","id",bhishiAppId));
		return bhishiApp;
	}

	
	@Override
	public List<BhishiApp> getAllBhishi() {

		List<BhishiApp> listBhishiApps = this.bhishiAppRepository.findAll();
		
		return listBhishiApps ;
	}

}
