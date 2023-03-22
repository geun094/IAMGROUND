package com.iamground.iam.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iamground.iam.entity.MemberAndMemberRole;
import com.iamground.iam.entity.PromemberAndMemberRole;
import com.iamground.iam.member.DTO.MemberAndMemberRoleDTO;
import com.iamground.iam.member.DTO.PromemberAndMemberRoleDTO;
import com.iamground.iam.member.paging.SelectCriteria;
import com.iamground.iam.repository.MemberAndMemberRoleRepository;
import com.iamground.iam.repository.PromemberAndMemberRoleRepository;

@Service
public class AdminService {

	private final MemberAndMemberRoleRepository memberRepository;
	private final PromemberAndMemberRoleRepository promemberRepository;
	private final ModelMapper modelMapper;			
	
	@Autowired
	public AdminService(ModelMapper modelMapper, MemberAndMemberRoleRepository memberRepository,PromemberAndMemberRoleRepository promemberRepository) {
		
		this.modelMapper = modelMapper;
		this.memberRepository = memberRepository;
		this.promemberRepository = promemberRepository;
	}


	public int selectTotalCount(String searchCondition, String searchValue) {
		int count = 0;
		if("3".equals(searchCondition)) {
			count = memberRepository.countByMemNameContaining(searchValue);
		}
		if("2".equals(searchCondition)) {
			count = promemberRepository.countByPromemNameContaining(searchValue);
		}
		return count;
	}

	public List searchMemberList(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;			// Pageble객체를 사용시 페이지는 0부터 시작(1페이지가 0)
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();
		/* 페이징 처리와 정렬을 위한 객체 생성 */
		//Pageable paging = PageRequest.of(index, count, Sort.by("memNo"));	// Pageable은 org.springframework.data.domain패키지로 import

		List<MemberAndMemberRole> adminList = new ArrayList<MemberAndMemberRole>();
		List<PromemberAndMemberRole> adminProList = new ArrayList<PromemberAndMemberRole>();
		
		String sort = "";
		//hibernate에서 native 쿼리 사용시 스네이크 사용 오류로 아래와 같이 처리 
		if("2".equals(selectCriteria.getSearchCondition())) {
			sort = "promemNo";
		} else {
			sort = "memNo";
		}
		Pageable paging = PageRequest.of(index, count, Sort.by(sort));	// Pageable은 org.springframework.data.domain패키지로 import
		if(searchValue != null) {

			if("3".equals(selectCriteria.getSearchCondition())) {
				adminList = memberRepository.findByMemNameContaining(selectCriteria.getSearchValue(), paging);
				return adminList.stream().map(menu -> modelMapper.map(menu, MemberAndMemberRoleDTO.class)).collect(Collectors.toList());
			}
			
			if("2".equals(selectCriteria.getSearchCondition())) {
				adminProList = promemberRepository.findByPromemNameContaining(selectCriteria.getSearchValue(), paging);
			}
		} else {
			if("2".equals(selectCriteria.getSearchCondition())) {
				adminProList = promemberRepository.findAll(paging).toList();
			}else {
				adminList = memberRepository.findAll(paging).toList();
			}
		}
		
		if("2".equals(selectCriteria.getSearchCondition())) {
			/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
			return adminProList.stream().map(menu -> modelMapper.map(menu, PromemberAndMemberRoleDTO.class)).collect(Collectors.toList());
		}
		return adminList.stream().map(menu -> modelMapper.map(menu, MemberAndMemberRoleDTO.class)).collect(Collectors.toList()); 
	}
	
	@Transactional
	public int promemOk(String promemNo) {
		return promemberRepository.updateByProMember(promemNo);
	}
	
	
	
}
