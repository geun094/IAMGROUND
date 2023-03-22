package com.iamground.iam.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamground.iam.notice.entity.NoticeFileAndNotice;

public interface NoticeFileAndNoticeRepository extends JpaRepository<NoticeFileAndNotice, Integer> {

}
