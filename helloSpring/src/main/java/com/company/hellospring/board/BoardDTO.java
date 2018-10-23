package com.company.hellospring.board;

public class BoardDTO {

	private String seq;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String cnt;
	private String outmsg;
	
	
	
	public String getOutmsg() {
		return outmsg;
	}
	public void setOutmsg(String outmsg) {
		this.outmsg = outmsg;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regdate=" + regdate + ", cnt=" + cnt + ", outmsg=" + outmsg + "]";
	}

}
