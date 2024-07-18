package com.wipro.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wipro.model.Student;
import com.wipro.util.DBUtils;

public class StudentServiceImpl implements StudentService{

	@Override
	public void addStudent(Student student) throws SQLException, ClassNotFoundException{
		
		PreparedStatement ps=DBUtils.getConnection().prepareStatement("insert into student values (?,?,?,?)");
		
		ps.setInt(1, student.getId());
		ps.setString(2, student.getName());
		ps.setString(3, student.getAddress());
		ps.setString(4, student.getEmail());
		
		ps.executeUpdate();
		
//		System.out.println("Student inserted successfully...");

		
	}

	@Override
	public void deleteStudent(int id) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps=DBUtils.getConnection().prepareStatement("delete from student where id=?");
		
		ps.setInt(1,id);
		ps.executeUpdate();
		System.out.println("Student with id "+id+" deleted successfully...");
		
	}

	@Override
	public void updateStudent(int id, Student student) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=DBUtils.getConnection().prepareStatement("update student set name=?, address=?, email=? where id=?");
		
		ps.setString(1, student.getName());
		ps.setString(2, student.getAddress());
		ps.setString(3,student.getEmail());
		ps.setInt(4, student.getId());
		
		ps.executeUpdate();
		
		
	}

	@Override
	public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
		Statement st=DBUtils.getConnection().createStatement();
		
		ResultSet rs=st.executeQuery("select * from student");
		List<Student> list=new ArrayList<>();
		
		while(rs.next()) {
			Student s=new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAddress(rs.getString(3));
			s.setEmail(rs.getString(4));
			list.add(s);
			
		}
		
		
		
		
		return list;
	}

	@Override
	public Student getStudent(int id) throws ClassNotFoundException, SQLException {	
		
		
		
		
		Statement st=DBUtils.getConnection().createStatement();
		String query="select * from student where id="+id;
		ResultSet rs=st.executeQuery(query);
		
		Student s=new Student();
		while(rs.next()) {
			s.setId(id);
			s.setName(rs.getString(2));
			s.setAddress(rs.getString(3));
			s.setEmail(rs.getString(4));
		}
		
		return s;
	}

}
