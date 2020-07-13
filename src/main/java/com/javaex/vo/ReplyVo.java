package com.javaex.vo;

public class ReplyVo {

//---------------------------------------------------------		필드

	private int no;
	private int userNo;
	private String title;
	private String content;
	private int hit;
	private String date;
	private String userName;
	private int groupNo;
	private int orderNo;
	private int depth;

//---------------------------------------------------------		생성자

	public ReplyVo() {

	}

	public ReplyVo(int no, int userNo, String title, String content, int hit, String date, String userName, int groupNo,
			int orderNo, int depth) {
		this.no = no;
		this.userNo = userNo;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.date = date;
		this.userName = userName;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
	}

//---------------------------------------------------------		getter, setter

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

//---------------------------------------------------------		일반메소드

//---------------------------------------------------------		toString()

	@Override
	public String toString() {
		return "ReplyVo [no=" + no + ", userNo=" + userNo + ", title=" + title + ", content=" + content + ", hit=" + hit
				+ ", date=" + date + ", userName=" + userName + ", groupNo=" + groupNo + ", orderNo=" + orderNo
				+ ", depth=" + depth + "]";
	}

}
