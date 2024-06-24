package kr.co.sample.domain.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sample.domain.base.dao.BaseDAO;
import kr.co.sample.domain.base.dto.BaseDTO;
import kr.co.sample.domain.base.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService{
	
	@Autowired
	BaseDAO baseDAO;
	
	
	@Override
	public BaseDTO getBaseUser(BaseDTO dto) {
		
		return baseDAO.getBaseUser(dto);
	}
	

}
