package com.m0427.web.service;

import java.util.List;

import com.m0427.web.model.Essay;

public interface EssayService {
	List<Essay> selectAllEssay();
	void insertEssay(Essay essay);

}
