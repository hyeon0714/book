package com.javaex.author;

public class AuthorVo {	//value object 값이 있는 경우 vo로 표현
	
	private int authorID;
	private String authorName;
	private String authorDesc;
	
	public AuthorVo() {
	}

	public AuthorVo(int authorID, String authorName, String authorDesc) {
		super();
		this.authorID = authorID;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	@Override
	public String toString() {
		return "AuthorVo [authorID=" + authorID + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}
	
	
	
}
