package net.su.vo;

public class Homevo {
	private int seq;
	private String id;
	private String password;

	private String postName;
	private String postNum;
	private String postDate;
	private String postId;
	private String postText;

	private String find_subject;
	
	
	public String getFind_subject() {
		return find_subject;
	}

	public void setFind_subject(String find_subject) {
		this.find_subject = find_subject;
	}

	public int getSeq() {
		return seq;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
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

}
