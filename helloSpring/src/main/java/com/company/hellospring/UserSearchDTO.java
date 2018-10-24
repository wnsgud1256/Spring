package com.company.hellospring;

import java.util.Arrays;

public class UserSearchDTO extends UserDTO {

	private String searchCondition;
	private String searchKeyword;
	//페이징처리를 위한 내용
	private Integer start;		//Integer와 int는 다름 int는 값이 안넘어 오면 0이고 integer는 null값임
	private Integer end;
	//단건처리를 위해 배열 사용
	
	private String[] ids;  //스트링 배열  Foreach를 쓰기 위해 생성.

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "UserSearchDTO [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + ", start="
				+ start + ", end=" + end + ", ids=" + Arrays.toString(ids) + "]";
	}
	//디버깅을 하기위해서 출력 값을 받아 볼려면(string값) toString을 생성 해야함
	
	
}
