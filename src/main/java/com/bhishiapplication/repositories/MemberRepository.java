package com.bhishiapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhishiapplication.entities.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	

}
