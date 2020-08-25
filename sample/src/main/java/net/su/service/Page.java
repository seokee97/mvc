package net.su.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.su.dao.HomeDao;
import net.su.vo.UserInfovo;

public class Page {

	HomeDao homeDao;
	UserInfovo vo;
	private int now_Page;
	private final int first_Page = 1;
	private int last_Page;
	private int max_Page;

	private List<UserInfovo> post_List_All;
	private Map<Integer, ArrayList<UserInfovo>> post_Page_Map;
	private int max_Page_Max_Num;

	public Page(List<UserInfovo> post_List_All) {
		this.post_List_All = post_List_All;

		vo = new UserInfovo();
		last_Page = post_List_All.size();
		if (last_Page % 10 == 0) {
			max_Page = last_Page / 10;
			max_Page_Max_Num = last_Page % 10;
		} else {
			max_Page = (last_Page / 10) + 1;
			max_Page_Max_Num = last_Page % 10;
		}
		post_Page_Map = new HashMap<Integer, ArrayList<UserInfovo>>();

		for (int i = 0; i < max_Page; i++) {
			ArrayList<UserInfovo> post_List_10 = new ArrayList<UserInfovo>();
			if (max_Page_Max_Num == 0) {
				for (int j = 0; j < 10; j++) {
					post_List_10.add(post_List_All.get(((i + 1) * 10 - 10) + j));
				}
			} else {
				if (i == max_Page-1) {
					for (int j = 0; j < max_Page_Max_Num; j++) {
						post_List_10.add(post_List_All.get(((i + 1) * 10 - 10) + j));
					}
				} else {
					for (int j = 0; j < 10; j++) {
						post_List_10.add(post_List_All.get(((i + 1) * 10 - 10) + j));
					}
				}
			}
			post_Page_Map.put(i + 1, post_List_10);
		}
	}

	
	public void show_Page_Post(int now_Page) {
		for (UserInfovo vo : post_Page_Map.get(now_Page)) {
			System.out.println(vo.getPostName());
		}
	}

	public ArrayList<UserInfovo> return_Post_Page(int iNum) {
		return (ArrayList<UserInfovo>) post_Page_Map.get(iNum);
	}


	public int getMax_Page() {
		return max_Page;
	}


	public void setMax_Page(int max_Page) {
		this.max_Page = max_Page;
	}

}