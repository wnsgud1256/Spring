package com.company.hellospring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class UserDAOSpring {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String USER_LIST = "SELECT * FROM USERS order by id";
	private final String USER_GET = "SELECT * FROM USERS where id=?";
	private final String USER_INSERT = "INSERT INTO USERS(ID,PASSWORD,NAME,ROLE) VALUES (?,?,?,?)";
	private final String USER_DELETE = "DELETE FROM USERS where id=?";
	private final String USER_UPDATE = "UPDATE USERS SET NAME=?,PASSWORD=?,ROLE=? WHERE id=?";
	//추가
	public int insertUser(UserDTO dto) {
		Object[] arr= {dto.getId(),dto.getPassword(),
			dto.getName(),dto.getRole()}; // 오브젝트 배열로 할수도 있음
		
		return jdbcTemplate.update(USER_INSERT, arr);
				/*dto.getId(),dto.getPassword(),
				dto.getName(),dto.getRole()); //이 방법도 있음.*/
        }
	//수정
	public int updateUser(UserDTO dto) {
		Object[] arr= {dto.getName(),dto.getPassword(),
				dto.getRole(),dto.getId()};
		return jdbcTemplate.update(USER_UPDATE, arr);
	}
	//삭제
	public int deleteUser(UserDTO dto) {
		
		return jdbcTemplate.update(USER_DELETE, dto.getId());
	}
	//단건조회
	public UserDTO getUser(UserDTO dto) {
		Object[] arr = {dto.getId() };
		return jdbcTemplate.queryForObject(USER_GET, arr, new UserRowMapper());
	}
	
	
	//전체조회
		public List<UserDTO> getUsers() {
			System.out.println("List<UserDTO> : 리스트 조회");
			return jdbcTemplate.query(USER_LIST, new UserRowMapper());
		}
}

class UserRowMapper implements RowMapper<UserDTO>{

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO(); //조회되는 건수만큼 객체를 생성 해야함.
		userDTO.setId(rs.getString("Id"));				//매핑은 직접하자. mybatis는 매핑까지 자동으로 해줌
		userDTO.setPassword(rs.getString("Password"));
		userDTO.setName(rs.getString("Name"));
		userDTO.setRole(rs.getString("Role"));
		return userDTO;
	}
	
}
