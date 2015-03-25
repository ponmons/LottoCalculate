package model.dao;

import java.util.List;

import model.domain.EndNumberDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;

@Repository("EndNumberDAO")
public class EndNumberDAOImpl implements EndNumberDAO {

	@Override
	public List<EndNumberDTO> numberList() {
		SqlSession session = DBUtil.getSqlSession();
		List<EndNumberDTO> endList = null;
		try {
			endList = session.selectList("ENDNUMBER.selectEndNumber");
		} finally {
			session.close();
		}
		return endList;
	}

}
