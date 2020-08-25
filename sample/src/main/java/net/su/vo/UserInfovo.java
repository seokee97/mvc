package net.su.vo;

public class UserInfovo {
	
	//회원 정보
	private int seq;
	private String id;
	private String password;
	private String name;
	private String gender;

	//게시판
	private int postNum;
	private String postId;
	private String postText;
	private String postName;
	private String postDate;
	private String input_find;
	private String paging;
	private int now_Page;
	
	private String commentText;
	private String commentDate;
	
	
	private String find_subject;
	
	public UserInfovo() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getInput_find() {
		return input_find;
	}
	public void setInput_find(String input_find) {
		this.input_find = input_find;
	}
	public int getNow_Page() {
		return now_Page;
	}
	public void setNow_Page(int now_Page) {
		this.now_Page = now_Page;
	}
	public String getPaging() {
		return paging;
	}
	public void setPaging(String paging) {
		this.paging = paging;
	}
	public String getFind_subject() {
		return find_subject;
	}
	public void setFind_subject(String find_subject) {
		this.find_subject = find_subject;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public UserInfovo(String id,String password) {
		this.id = id;
		this.password = password;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
