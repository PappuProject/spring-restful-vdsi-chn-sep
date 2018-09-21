package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class JdbcApp1 {

	public static void main(String[] args) {

		String emp_insert = "insert into EMP(EMPNO,NAME,ADDRESS,SALARY) values(?,?,?,?)";
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);

		// JdbcTemplate jt=(JdbcTemplate)ctx.getBean("jt");
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);

		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(emp_insert);
				pst.setInt(1, 111);
				pst.setString(2, "Kamal");
				pst.setString(3, "MAA");
				pst.setDouble(4, 76000);
				return pst;
			}
		});

		int count1 = jt.update((con) -> {
			PreparedStatement pst = con.prepareStatement(emp_insert);
			pst.setInt(1, 112);
			pst.setString(2, "Ramdev");
			pst.setString(3, "UK");
			pst.setDouble(4, 76000);
			return pst;
		});
		System.out.println("Rows Inserted : " + count);
	}

}
