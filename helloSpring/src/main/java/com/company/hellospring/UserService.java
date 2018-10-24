package com.company.hellospring;

import java.util.List;

public interface UserService { // 서비스가 교체될 수도 있기 때문에 인터페이스로 씀.

	// 등록(in)
	public int insertUser(UserDTO dto);

	// 수정(up)
	public int updateUser(UserDTO dto);

	// 삭제(회원탈퇴)(del)
	public int deleteUser(UserDTO dto);

	// 단건조회
	public UserDTO getUser(UserDTO dto);

	// 전체조회(list)
	public List<UserDTO> getUsers(UserSearchDTO searchDto);
	//건수조회
	public int getCnt(UserSearchDTO searchDto);

}
