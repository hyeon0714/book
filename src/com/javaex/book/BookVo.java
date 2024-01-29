package com.javaex.book;

public class BookVo {
	
	private int book_id;
	private String title;
	private String pubs;
	private String date;
	private int author_id1;
	private int author_id2;
	private String name;
	private String desc;
	
	public BookVo() {
		super();
	}
	
	

	public BookVo(int book_id, String title, String pubs, String date, int author_id1) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.pubs = pubs;
		this.date = date;
		this.author_id1 = author_id1;
	}



	public BookVo(int book_id, String title, String pubs, String date, int author_id1, int author_id2, String name,
			String desc) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.pubs = pubs;
		this.date = date;
		this.author_id1 = author_id1;
		this.author_id2 = author_id2;
		this.name = name;
		this.desc = desc;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAuthor_id1() {
		return author_id1;
	}

	public void setAuthor_id1(int author_id1) {
		this.author_id1 = author_id1;
	}

	public int getAuthor_id2() {
		return author_id2;
	}

	public void setAuthor_id2(int author_id2) {
		this.author_id2 = author_id2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "BookVo [book_id=" + book_id + ", title=" + title + ", pubs=" + pubs + ", date=" + date + ", author_id1="
				+ author_id1 + ", author_id2=" + author_id2 + ", name=" + name + ", desc=" + desc + "]";
	}
	
	
	
}
