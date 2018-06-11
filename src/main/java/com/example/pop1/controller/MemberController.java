package com.example.pop1.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pop.exception.ResourceNotFoundException;
import com.example.pop1.model.MemberModel;
import com.example.pop1.repository.MemberRepository;


@RestController
@RequestMapping("/api")
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	//get all member
	@GetMapping("/member")
	public @ResponseBody List<MemberModel> getAllMember(){
		return memberRepository.findAll();
	} 
	
	//create new member
	@PostMapping("/member")
	public MemberModel createMember (@Valid @RequestBody MemberModel member) {
		return memberRepository.save(member);
	}
	
	//get single member
	@GetMapping("/member/{id}")
	public MemberModel getMemberById(@PathVariable(value = "id")Long memberId) {
		return memberRepository.findById(memberId).orElseThrow(
				()->new ResourceNotFoundException("Member", "id", memberId)
			);
	}
	
	// Update a Note
	@PutMapping("/member/{id}")
	public MemberModel updateMember(@PathVariable(value="id") Long memberId,@Valid @RequestBody MemberModel memberDetail) {
		
		MemberModel member = memberRepository.findById(memberId).orElseThrow(
				()-> new ResourceNotFoundException("Member", "id", memberId)
				);
		member.setFirstName(memberDetail.getFirstName());
		member.setLastName(memberDetail.getLastName());
		member.setUsername(memberDetail.getUsername());
		
		MemberModel updateMember = memberRepository.save(member);
		return updateMember;
		
	}
	
	// Delete a Note
	@DeleteMapping("/member/{id}")
	public ResponseEntity<?> deleteMember(@PathVariable (value = "id") Long memberId){
		MemberModel member = memberRepository.findById(memberId).orElseThrow(
				()-> new ResourceNotFoundException("Member", "id", memberId)
				);
		memberRepository.delete(member);
		return ResponseEntity.ok().build();
	}
	
}
