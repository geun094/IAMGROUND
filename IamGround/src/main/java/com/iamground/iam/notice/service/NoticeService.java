package com.iamground.iam.notice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iamground.iam.notice.dto.NoticeDTO;
import com.iamground.iam.notice.dto.NoticeFileAndNoticeDTO;
import com.iamground.iam.notice.entity.Notice;
import com.iamground.iam.notice.entity.NoticeFileAndNotice;
import com.iamground.iam.notice.paging.SelectCriteria;
import com.iamground.iam.notice.repository.NoticeFileAndNoticeRepository;
import com.iamground.iam.notice.repository.NoticeRepository;

@Service
public class NoticeService {

	private final NoticeRepository noticeRepository;
	private final ModelMapper modelMapper;
	private final NoticeFileAndNoticeRepository noticeFileAndNoticeRepository;
	
	/* ModerMapper와 JpaRepository 메소드 사용을 위해 @Autowired */
	@Autowired
	public NoticeService(NoticeRepository noticeRepository, ModelMapper modelMapper, NoticeFileAndNoticeRepository noticeFileAndNoticeRepository) {
		this.noticeRepository = noticeRepository;
		this.modelMapper = modelMapper;
		this.noticeFileAndNoticeRepository = noticeFileAndNoticeRepository;
	}
	
	/* 게시글 DB에 등록 */
	@Transactional
	public void writeNotice(NoticeDTO newNotice) {
		
		noticeRepository.save(modelMapper.map(newNotice, Notice.class));
	}

	/* DB에 있는 게시글들을 가져옴 */
	public List<NoticeDTO> findNoticeList() {
		
		List<Notice> noticeList = noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "noticeNo"));
		
		return noticeList.stream().map(notice -> modelMapper.map(notice, NoticeDTO.class)).collect(Collectors.toList());
	}

	/* 게시글 상세 조회  */
	public NoticeDTO noticeDetail(int noticeNo) {
		
		Notice notice = noticeRepository.findById(noticeNo).get();
		
		return modelMapper.map(notice, NoticeDTO.class);
	}

	/* 게시글 수정(제목, 내용만) */
	@Transactional
	public void modifyNotice(NoticeDTO notice) {
		
		Notice foundNotice = noticeRepository.findById(notice.getNoticeNo()).get();
		foundNotice.setNoticeContent(notice.getNoticeContent());
		foundNotice.setNoticeTitle(notice.getNoticeTitle());
	}

	/* 게시글 삭제 */
	public void deleteNotice(NoticeDTO notice) {
		noticeRepository.deleteById(notice.getNoticeNo());
	}

	/* 페이지, 검색 */
	public int selectTotalCount(String searchCondition, String searchValue) {
		
			int count = 0;
			if(searchValue != null) {
				if("noticeTitle".equals(searchCondition)) {
					count = noticeRepository.countByNoticeTitleContaining(searchValue);
				}
				if("noticeContent".equals(searchCondition)) {
					count = noticeRepository.countByNoticeContentContaining(searchValue);
				}
			} else {
				count = (int)noticeRepository.count();
			}
			
			return count;
		}

	/* 페이지, 검색 */
	public List<NoticeDTO> searchNoticeList(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;			// Pageble객체를 사용시 페이지는 0부터 시작(1페이지가 0)
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		/* 페이징 처리와 정렬을 위한 객체 생성 */
		Pageable paging = PageRequest.of(index, count, Sort.by(Sort.Direction.DESC, "noticeNo"));	// Pageable은 org.springframework.data.domain패키지로 import

		List<Notice> noticeList = new ArrayList<Notice>();
		if(searchValue != null) {
			
			if("noticeTitle".equals(selectCriteria.getSearchCondition())) {
				noticeList = noticeRepository.findByNoticeTitleContaining(selectCriteria.getSearchValue(), paging);
			}
			if("noticeContent".equals(selectCriteria.getSearchCondition())) {
				noticeList = noticeRepository.findByNoticeContentContaining(selectCriteria.getSearchValue(), paging);
			}
		} else {
			noticeList = noticeRepository.findAll(paging).toList();
		}
		
		return noticeList.stream().map(notice -> modelMapper.map(notice, NoticeDTO.class)).collect(Collectors.toList());
	}


}
