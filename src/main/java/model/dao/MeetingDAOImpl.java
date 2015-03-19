package model.dao;


import java.util.List;

import model.domain.MeetingDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;

@Repository("meetingDAO")
public class MeetingDAOImpl implements MeetingDAO {


	@Override
	public int insertMeeting(MeetingDTO meetingDTO) {
		SqlSession session = DBUtil.getSqlSession();
		System.out.println(meetingDTO);
		int result = 0;
		boolean flag = false;
		try {
			result = session.insert("MEETING.insertMeeting", meetingDTO);
			flag = result >0 ? true : false;
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}

	@Override
	public List<MeetingDTO> meetingList(int memno) {
		SqlSession session = DBUtil.getSqlSession();
		List<MeetingDTO> spendList = null;
		try {
			spendList = session.selectList("MEETING.meetingList", memno);
		} finally {
			session.close();
		}
		return spendList;
	}
	
	@Override
	public MeetingDTO selectMeetNo(MeetingDTO md){
		SqlSession session = DBUtil.getSqlSession();
		MeetingDTO md2=null;
		try {
			md2 = session.selectOne("MEETING.selectOne", md);
		} finally {
			session.close();
		}
		return md2;
	}
	
	@Override
	public MeetingDTO meetSelectNum(int meetno){
		SqlSession session = DBUtil.getSqlSession();
		MeetingDTO md2=null;
		try {
			md2 = session.selectOne("MEETING.meetSelect", meetno);
		} finally {
			session.close();
		}
		return md2;
	}
	
	
	
	@Override
	public int deleteMeeting(MeetingDTO md){ //미팅 삭제
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.delete("MEETING.deleteMeeting", md);
			//System.out.println(result);
		} finally {
			session.close();
		}
		return result;	//delete �����ϸ� 1�� ����
		
	}
	
	
}
