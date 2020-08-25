package net.su.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.su.dao.HomeDao;
import net.su.vo.Homevo;
import net.su.vo.UserInfovo;

@Service
public class HomeServiceImpl implements HomeService {
	@Autowired
	private HomeDao homeDao;

	@Override
	public void userInfoInsert(UserInfovo vo) throws Exception {
		homeDao.userInfoInsert(vo);
	}

	public UserInfovo loginCheck(UserInfovo vo) {
		return homeDao.userInfoSelect(vo);
	}
	@Override
	public int idchk(UserInfovo vo) {
		return homeDao.idchk(vo);
	}

	@Override
	public List<UserInfovo> allpost(UserInfovo vo) {
		return homeDao.allpost(vo);
	}

	@Override
	public void postwrite(UserInfovo vo) {
		homeDao.postwrite(vo);
	}

	@Override
	public List<UserInfovo> findpost(UserInfovo vo,String subject) {
			return homeDao.findpost(vo,vo.getFind_subject());
		
	}

	@Override
	public UserInfovo showFindPost_one(UserInfovo vo) {
		return homeDao.showFindpost_one(vo);
	}

	@Override
	public void deletePost(UserInfovo vo) {
		homeDao.deletePost(vo);
	}

//	@Override
//	public List<UserInfovo> textListSelect() {		
//		return homeDao.textListSelect();
//	}


//	@Override
//	public void userInfoSelect(UserInfovo vo) {
//		homeDao.userInfoSelect(vo);
//	}

}
