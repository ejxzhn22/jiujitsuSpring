package com.sujin.spring.vo;

/*
b_no int AI PK 
b_title varchar(100) 
b_content varchar(500) 
b_write varchar(45) 
b_date datetime 
b_del int
*/

public class Board {
	
	private int b_no;
	private String b_title;
	private String b_content;
	private String b_writer;
	private String b_date;
	private int b_del;
	private int b_kategorie;
	private int b_answer;
	

	
	public int getB_answer() {
		return b_answer;
	}

	public void setB_answer(int b_answer) {
		this.b_answer = b_answer;
	}
	
	public int getB_kategorie() {
		return b_kategorie;
	}



	public void setB_kategorie(int b_kategorie) {
		this.b_kategorie = b_kategorie;
	}



	public int getB_no() {
		return b_no;
	}


	public void setB_no(int b_no) {
		this.b_no = b_no;
	}


	public String getB_title() {
		return b_title;
	}


	public void setB_title(String b_title) {
		this.b_title = b_title;
	}


	public String getB_content() {
		return b_content;
	}


	public void setB_content(String b_content) {
		this.b_content = b_content;
	}


	public String getB_writer() {
		return b_writer;
	}


	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}


	public String getB_date() {
		return b_date;
	}


	public void setB_date(String b_date) {
		this.b_date = b_date;
	}


	public int getB_del() {
		return b_del;
	}


	public void setB_del(int b_del) {
		this.b_del = b_del;
	}



	@Override
	public String toString() {
		return "Board [b_no=" + b_no + ", b_title=" + b_title + ", b_content=" + b_content + ", b_writer=" + b_writer
				+ ", b_date=" + b_date + ", b_del=" + b_del + ", b_kategorie=" + b_kategorie + "]";
	}


	
	
	
	

}
