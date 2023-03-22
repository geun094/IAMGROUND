package com.iamground.iam.notice.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.notice.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

	int countByNoticeTitleContaining(String searchValue);

	List<Notice> findByNoticeTitleContaining(String searchValue, Pageable paging);

	List<Notice> findByNoticeContentContaining(String searchValue, Pageable paging);

	int countByNoticeContentContaining(String searchValue);

	

 
	
}
