package net.su.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import net.su.vo.Homevo;
import net.su.vo.UserInfovo;

@Repository
public class HomeDao extends SqlSessionDaoSupport {

	static SqlSession sqlSession;

	public void userInfoInsert(UserInfovo vo) {
		getSqlSession().insert("mapper.infoInsert", vo);
	}

	public UserInfovo userInfoSelect(UserInfovo vo) {
		return getSqlSession().selectOne("mapper.loginCheck", vo);
	}

	public int idchk(UserInfovo vo) {
		return getSqlSession().selectOne("mapper.idchk",vo);
	}

	public List<UserInfovo> allpost(UserInfovo vo) {
		return getSqlSession().selectList("mapper.allpost", vo);
	}

	public void postwrite(UserInfovo vo) {
		getSqlSession().insert("mapper.postwrite", vo);
	}

	public List<UserInfovo> findpost(UserInfovo vo,String subject) {
		if(subject.equals("Title")) {
			return getSqlSession().selectList("mapper.findpost_Title", vo);	
		}else {
			return getSqlSession().selectList("mapper.findpost_postID", vo);
		}
}

	public UserInfovo showFindpost_one(UserInfovo vo) {
		return getSqlSession().selectOne("mapper.showFind_post", vo);
	}

	public int post_LastPage() {
		return getSqlSession().selectOne("mapper.posLastPage");
	}

	public void deletePost(UserInfovo vo) {
		getSqlSession().delete("mapper.deletePost", vo);
	}
	

//	public List<UserInfovo> textListSelect() {
//		
//		return getSqlSession().selectList("mapper.textListSelect");
//		
//	}

}
