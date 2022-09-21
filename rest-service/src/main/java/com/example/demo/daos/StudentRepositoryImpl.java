package com.example.demo.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.utils.ConnectionFactory;
import com.training.exceptions.ElementNotFoundException;
import com.training.ifaces.CrudRepository;
import com.training.model.Student;

public class StudentRepositoryImpl implements CrudRepository<Student> {
       
       private Connection con;
       
       public StudentRepositoryImpl(Connection con) {
             super();
             this.con=con;
       }
       

       public StudentRepositoryImpl() {
		super();
		this.con=ConnectionFactory.getMySqlConnection();
	}


	@Override
       public boolean save(Student obj) {
             
             String sql="insert into lumen_student values(?,?,?,?,?)";
             int rowUpdated=0;
             try {
                    PreparedStatement pstmt=con.prepareStatement(sql);
                    
                    pstmt.setString(1,obj.getStudentName());
                    pstmt.setString(2, obj.getStudentRollNumber());
                    pstmt.setInt(3, obj.getStudentAge());
                    pstmt.setDouble(4,obj.getStudentPhoneNumber());
                    pstmt.setString(5,obj.getStudentCity());
                    
                    
                    rowUpdated=pstmt.executeUpdate();
                    
                    
             }catch(SQLException e) {
                    e.printStackTrace();
             }
             
             return rowUpdated==1?true:false;
       }

       @Override
       public Collection<Student> findAll() {
             List<Student>studList=new ArrayList<>();
             try {
                    String sql="select * from lumen_student";
                    PreparedStatement pstmt=con.prepareStatement(sql);
                    ResultSet rs=pstmt.executeQuery();
                    while(rs.next()) {
                          String name=rs.getString("studentName");
                          String roll=rs.getString("studentRollNumber");
                          int age=rs.getInt("studentAge");
                          long phn=rs.getInt("studentPhoneNumber");
                          String city=rs.getString("studentCity");
                          
                          Student obj=new Student(name,roll,age,phn,city);
                          studList.add(obj);
                          
                    }
                    
             }catch(SQLException e) {
                    e.printStackTrace();
             }
             return studList;
       }

       @Override
       public boolean delete(Student obj) throws ElementNotFoundException {
             // TODO Auto-generated method stub
             return false;
       }


	@Override
	public boolean deleteById(int key) throws ElementNotFoundException {
		// TODO Auto-generated method stub
		String sql = "delete from lumen_student where studentRollNumber=?";

	        
	        int rowDeleted=0;
	        
	        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
	        
	            pstmt.setInt(1, key);
	            
	             rowDeleted  = pstmt.executeUpdate();
	            



	       } catch (SQLException e) {



	           e.printStackTrace();
	        }
	        return rowDeleted==1?true:false;


	}


	@Override
	public Student findById(int key) throws ElementNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select * from lumen_student where studentRollNumber=?";



	       Student obj=null;
	        
	        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
	        
	            pstmt.setInt(1, key);
	            
	            ResultSet rs = pstmt.executeQuery();
	            
	            if(rs.next()) {
	                
	            	String name=rs.getString("studentName");
                    String roll=rs.getString("studentRollNumber");
                    int age=rs.getInt("studentAge");
                    long phn=rs.getInt("studentPhoneNumber");
                    String city=rs.getString("studentCity");
                    
                    obj=new Student(name,roll,age,phn,city);
        
	                
	                
	            }
	            
	            if(obj==null) {
	                throw new ElementNotFoundException("ERR-102","Element with Given Id "+ key+" Not Found");
	            }
	            
	        } catch (SQLException e) {



	           e.printStackTrace();
	        }
	        
	        return obj;
	}
       
}

