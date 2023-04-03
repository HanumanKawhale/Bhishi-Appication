package com.bhishiapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhishiapplication.entities.BhishiApp;
@Repository
public interface BhishiAppRepository extends JpaRepository<BhishiApp, Integer> {

	//List<Member> findAllByMember(Member member);
	
	//Member findByMember(Member member);
	
	  //List<Member> findByListMember();
}
