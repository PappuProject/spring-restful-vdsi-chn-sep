package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {
	String emp_insert = "insert into EMP(EMPNO,NAME,ADDRESS,SALARY) values(?,?,?,?)";

	@Autowired
	private JdbcTemplate jt;

	@Override
	public String save(Emp e) {
		try {
			jt.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(emp_insert);
					pst.setInt(1, e.getEmpId());
					pst.setString(2, e.getName());
					pst.setString(3, e.getCity());
					pst.setDouble(4, e.getSalary());
					return pst;
				}
			});
			return "saved";

		} catch (DuplicateKeyException ex) {

			throw new RuntimeException("Emp with primary key " + e.getEmpId() + " Already Exists");
		}

	}

	@Override
	public String update(Emp e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> empList = jt.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}

		});
		return empList;
	}

	@Override
	public Emp findById(int id) {
		try {
			Emp emp = jt.queryForObject("select * from emp where empno=" + id, new RowMapper<Emp>() {

				@Override
				public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {

					return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
							rs.getDouble("SALARY"));
				}

			});
			return emp;
		} catch (EmptyResultDataAccessException ex) {
			throw new RuntimeException("No Employee with given ID");
		}
	}

}
