package com.m0427.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.m0427.web.dao.EssayDao;
import com.m0427.web.model.Essay;
import com.m0427.web.service.EssayService;

@Service("essayService")
public class EassyServiceImpl implements EssayService {

	@Resource EssayDao essayDao;
	
	@Override
	public List<Essay> selectAllEssay() {
		return essayDao.selectAllEssay();
	}

	@Override
	public void insertEssay(Essay essay) {
		essayDao.insertEssay(essay);

	}

}
