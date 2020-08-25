package net.su.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.su.vo.Homevo;
import net.su.vo.UserInfovo;

public interface HomeService {

	public void userInfoInsert(UserInfovo vo) throws Exception;

	public UserInfovo loginCheck(UserInfovo vo);

	public int idchk(UserInfovo vo);

	public List<UserInfovo> allpost(UserInfovo vo);

	public void postwrite(UserInfovo vo);

	public List<UserInfovo> findpost(UserInfovo vo,String subject);

	public UserInfovo showFindPost_one(UserInfovo vo);

	public void deletePost(UserInfovo vo);
}
