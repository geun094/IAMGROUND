package com.iamground.iam.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Category")
/* repository에서 쿼리를 날릴 때 매칭할 테이블 */
@Table(name = "TBL_QNA_BOARD_CATEGORY")
public class Category {
	
	@Id
	@Column(name = "CATEGORY_CODE")
	private Integer categoryCode;
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	public Category() {}

	public Category(Integer categoryCode, String categoryName) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}

	public Integer getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(Integer categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryCode=" + categoryCode + ", categoryName=" + categoryName + "]";
	}

}
