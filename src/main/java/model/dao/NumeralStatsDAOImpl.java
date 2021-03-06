package model.dao;

import java.util.List;

import model.domain.NumeralStatsDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;


@Repository("NumeralStatsDAO")
public class NumeralStatsDAOImpl implements NumeralStatsDAO{

	@Override
	public List<NumeralStatsDTO> list(){
		SqlSession session = DBUtil.getSqlSession();
		List<NumeralStatsDTO> numeralStatsDTO= null;
		
		try {
			numeralStatsDTO = session.selectList("NUMERALSTATS.read");
		}finally{
			session.close();
		}
		
		return numeralStatsDTO;
		
	}

	@Override
	public float getStat(int number) {
		SqlSession session = DBUtil.getSqlSession();
		try {
			return session.selectOne("NUMERALSTATS.getStat", number);
		}finally{
			session.close();
		}
	}
	
	
/*	public int update(NumeralStatsDTO NumeralStats){
		int numeral_frequency = session.update("NumeralStats.update", NumeralStats);
		return numeral_frequency;
		};*/
		
		
}