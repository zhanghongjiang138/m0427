package com.m0427.web.dao;

import java.util.List;

import com.m0427.web.model.Essay;

public interface EssayDao {

	void insertEssay(Essay essay);

	List<Essay> selectAllEssay();

}
