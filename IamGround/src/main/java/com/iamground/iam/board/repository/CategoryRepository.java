package com.iamground.iam.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iamground.iam.board.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	
	/*JPQL로 처리해 보기 */
	@Query(value = "SELECT b FROM Category b ORDER BY b.categoryCode")
	public List<Category> findAllCategory();
}
