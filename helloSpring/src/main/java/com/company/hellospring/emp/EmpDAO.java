package com.company.hellospring.emp;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	@Autowired SqlSessionTemplate mybatis;
	
	public int getCnt() {
		
	return mybatis.selectOne("emp.getCnt");
	}
	public List<EmpDTO> getSalaryTOP3(){
		return mybatis.selectList("emp.getSalaryTOP3");
	}
	public List<EmpDTO> getEmps(EmpDTO dto){
		return mybatis.selectList("emp.getEmps",dto);
	}
	public List<Map<String,Object>> getEmpDept(){   //여러값을 보여줘야 하기 때문에 리스트임
		return mybatis.selectList("emp.getEmpDept");
	}
	public int insertEmp(EmpDTO dto) {
		int r = mybatis.insert("emp.insertEmp", dto);
		System.out.println(dto.getEmployeeId());
		return r;
	}
	
}
