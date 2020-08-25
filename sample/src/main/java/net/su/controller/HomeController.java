package net.su.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.SessionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.Session;

import net.su.service.HomeService;
import net.su.service.Page;
import net.su.vo.Homevo;
import net.su.vo.UserInfovo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;
	private Page page;
	private Page findPage;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	int pageNum = 1;
	int findPageNum = 1;
	
	// main 화면
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String main(UserInfovo vo, Locale locale, Model model, HttpSession session) {
		try {
			page = new Page(homeService.allpost(vo));
			List<UserInfovo> postList = page.return_Post_Page(pageNum);
			for(UserInfovo vo3: postList) {
				System.out.println(vo3.getPostNum());
			}
			model.addAttribute("postList", postList);
			model.addAttribute("maxPage", page.getMax_Page());
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("post에러"+e.getMessage());
		}

		try {
			System.out.println(session.getAttribute("userinfo"));
			model.addAttribute("userinfo", session.getAttribute("userinfo"));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			model.addAttribute("userinfo", null);
			return "main";
		}
		return "main";
	}

	// main화면 로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.POST })
	public String logout(Locale locale, Model model, HttpSession session) {
		session.removeAttribute("userinfo");
		return "redirect:/";
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////

	// 회원가입
	@RequestMapping(value = "/signup", method = { RequestMethod.GET, RequestMethod.POST })
	public String signup(Locale locale, Model model) {
		return "signup";
	}

	@RequestMapping(value = "/signupinsert", method = { RequestMethod.GET, RequestMethod.POST })
	public String signupBtn(UserInfovo vo) throws Exception {
		homeService.userInfoInsert(vo);
		return "redirect:/login";

	}

	// 로그인
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Locale locale, Model model) {
		return "login";
	}

	@RequestMapping(value = "/loginBtn", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginBtn(UserInfovo vo, Model model, HttpSession session) throws Exception {
		UserInfovo vo1 = new UserInfovo(vo.getId(), vo.getPassword());
		UserInfovo vo2 = homeService.loginCheck(vo);
		try {
			List<UserInfovo> postList = homeService.allpost(vo);
			model.addAttribute("postList", postList);
			if ((vo1.getId()).equals(vo2.getId())) {
				if (vo1.getPassword().equals(vo2.getPassword())) {
					session.setAttribute("userinfo", vo2.getId());
					return "redirect:/";
				} else {
					model.addAttribute("matchError", "비밀번호 불일치");
					return "login";
				}
			}
		} catch (Exception e) {
			model.addAttribute("matchError", "아이디 불일치");
			return "login";
		}
		return "login";
	}

	@RequestMapping(value = "/findpw", method = { RequestMethod.GET, RequestMethod.POST })
	public String findpw(Locale locale, Model model) {
		return "findpw";
	}

	@ResponseBody
	@RequestMapping(value = "/loginchk", method = { RequestMethod.POST })
	public int loginchk(Locale locale, Model model, HttpServletRequest req, UserInfovo vo) {
		int val = homeService.idchk(vo);
		return val;
	}

	// 글쓰기
	@RequestMapping(value = "/postwrite", method = { RequestMethod.GET, RequestMethod.POST })
	public String postwrite(UserInfovo vo, Model model, HttpSession session) throws Exception {

		return "postwrite";
	}

	// 게시글 보기
	@RequestMapping(value = "/showpost", method = { RequestMethod.GET, RequestMethod.POST })
	public String showpost(UserInfovo vo, Model model, HttpSession session) throws Exception {
		System.out.println("게시글 보기(이름) : "+vo.getPostName());
		System.out.println("postNum"+vo.getPostNum());
		UserInfovo vo_post = homeService.showFindPost_one(vo);
		model.addAttribute("postInfo",vo_post);
		model.addAttribute("userId", session.getAttribute("userinfo"));

		return "showpost";
	}

	// 게시글찾기
	@RequestMapping(value = "/findpost", method = { RequestMethod.GET, RequestMethod.POST })
	public String findpost(UserInfovo vo, Model model, HttpSession session) throws Exception {
//		System.out.println("찾는 게시글 제목"+vo.getPostName());`
		System.out.println("항목 : "+vo.getFind_subject());
		System.out.println("찾"+vo.getInput_find());
		model.addAttribute("inputfind", vo.getInput_find());
		try {
			findPage = new Page(homeService.findpost(vo,vo.getFind_subject()));
			List<UserInfovo> findPostList = findPage.return_Post_Page(findPageNum);
			findPageNum = 1;
			model.addAttribute("maxPage", findPage.getMax_Page());
			model.addAttribute("findPost_OK", "findPost_OK");
			model.addAttribute("findPostList", findPostList);
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("post에러"+e.getMessage());
		}
		
		return "findmain";
	}

	// 게시글삭제
	@RequestMapping(value = "/deletePost", method = { RequestMethod.GET, RequestMethod.POST })
	public String deletePost(UserInfovo vo, Model model, HttpSession session) throws Exception {
		homeService.deletePost(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/paging", method = { RequestMethod.GET, RequestMethod.POST })
	public String paging(UserInfovo vo, Model model, HttpSession session) throws Exception {
		
		pageNum = vo.getNow_Page();
		
		try {
			page = new Page(homeService.allpost(vo));
			List<UserInfovo> postList = page.return_Post_Page(pageNum);
			pageNum = 1;
			model.addAttribute("postList", postList);
			model.addAttribute("maxPage", page.getMax_Page());
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("post에러"+e.getMessage());
		}

		try {
			System.out.println(session.getAttribute("userinfo"));
			model.addAttribute("userinfo", session.getAttribute("userinfo"));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			model.addAttribute("userinfo", null);
			return "main";
		}
		return "main";
	}
	
	@RequestMapping(value = "/findpaging", method = { RequestMethod.GET, RequestMethod.POST })
	public String findpaging(UserInfovo vo, Model model, HttpSession session) throws Exception {
		try {
			findPageNum = vo.getNow_Page();
			List<UserInfovo> findPostList = findPage.return_Post_Page(findPageNum);
			findPageNum = 1;
			model.addAttribute("maxPage", findPage.getMax_Page());
			model.addAttribute("findPost_OK", "findPost_OK");
			model.addAttribute("findPostList", findPostList);
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("post에러"+e.getMessage());
		}

		try {
			System.out.println(session.getAttribute("userinfo"));
			model.addAttribute("userinfo", session.getAttribute("userinfo"));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			model.addAttribute("userinfo", null);
			return "findmain";
		}
		return "findmain";
	}
	// 글쓰기
	@RequestMapping(value = "/postwritesql", method = { RequestMethod.GET, RequestMethod.POST })
	public String postwritesql(UserInfovo vo, Model model, HttpSession session) throws Exception {
		String id = (String) session.getAttribute("userinfo");
		vo.setId(id);
		homeService.postwrite(vo);
		return "redirect:/";
	}
	
	
	

}
