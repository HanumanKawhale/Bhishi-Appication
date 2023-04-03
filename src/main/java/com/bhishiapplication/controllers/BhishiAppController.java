package com.bhishiapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhishiapplication.entities.BhishiApp;
import com.bhishiapplication.services.BhishiAppService;

@RestController
@RequestMapping("/bhishiApp")
public class BhishiAppController {

	@Autowired
	private BhishiAppService bhishiAppService;
	
	
	
	@PostMapping("/")
	public ResponseEntity<BhishiApp> createBhishiApp(@RequestBody BhishiApp bhishiApp){
		
		BhishiApp bhishiApp2 = this.bhishiAppService.createBhishiApp(bhishiApp);
		
		return new ResponseEntity<>(bhishiApp2, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/{bhishiAppId}")
	public ResponseEntity<BhishiApp>  updateBhishiApp(@RequestBody BhishiApp bhishiApp
			, @PathVariable("bhishiAppId") Integer bhishiAppId) {
		
		System.out.println(bhishiApp);
		BhishiApp bhishiApp2 = this.bhishiAppService.updateBhishiApp(bhishiApp, bhishiAppId);
		
		return new ResponseEntity<>(bhishiApp2, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/{bhishiAppId}")
	public ResponseEntity<String> deleteBhishiApp(@PathVariable("bhishiAppId") Integer bhishiAppId ) {
		
		this.bhishiAppService.deleteBhishiApp(bhishiAppId);
		
		String message = "delete successfully " + bhishiAppId;
		return new ResponseEntity<String>(message,HttpStatus.OK) ;
		
	}
	
	
	
	@GetMapping("/{bhishiAppId}")
	public ResponseEntity<BhishiApp> getBhishiApp(@PathVariable("bhishiAppId") Integer bhishiAppId){
		
		BhishiApp bhishiApp = this.bhishiAppService.getBhishiAppById(bhishiAppId);
		
		return new ResponseEntity<BhishiApp>(bhishiApp,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/")
	public ResponseEntity<List<BhishiApp>> getAllBhishiApp() {
		
		List<BhishiApp> apps = this.bhishiAppService.getAllBhishi();
		
		return new ResponseEntity<List<BhishiApp>>(apps,HttpStatus.OK);
		
	}

	
}
