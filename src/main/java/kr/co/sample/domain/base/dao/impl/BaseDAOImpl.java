package kr.co.sample.domain.base.dao.impl;

import org.springframework.stereotype.Repository;

import kr.co.sample.domain.base.dao.BaseDAO;
import kr.co.sample.domain.base.dto.BaseDTO;

@Repository
public class BaseDAOImpl implements BaseDAO {

	@Override
	public BaseDTO getBaseUser(BaseDTO dto) {

		return new BaseDTO();
	}

}
