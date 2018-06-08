package com.example.pop1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pop1.model.MemberModel;

@Repository
public interface MemberRepository extends JpaRepository<MemberModel, Long>{

}
