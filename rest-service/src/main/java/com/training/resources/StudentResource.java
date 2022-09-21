package com.training.resources;
import com.example.demo.daos.StudentRepositoryImpl;
import com.example.demo.utils.ConnectionFactory;
import com.training.exceptions.ElementNotFoundException;
import com.training.model.Student;
import java.util.Collection;
//import com.example.demo.repos.StudentRepositoryImpl;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/api/students")
public class StudentResource {
	
	private static final Student entity = null;
	StudentRepositoryImpl repo; 
	
	public StudentResource() {
		super();
		this.repo= new StudentRepositoryImpl(ConnectionFactory.getMySqlConnection());
	}
	
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	public Collection<Student> findAllStudent(){
		return repo.findAll();
		
	}
	@Produces(value=MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	@POST
	public Response addStudent(Student entity) {
		boolean result =repo.save(entity);
		return Response.ok(entity).status(201).build();
	}
	
	 @GET
	 @Path("/{key}")
     public Student findByID(@PathParam("key") int key) throws ElementNotFoundException{
        return repo.findById(key);
        
    }
    
    @DELETE
    @Path("/{key}")
    public boolean deleteByID(@PathParam("key") int key) throws ElementNotFoundException{
        return repo.deleteById(key);
        
    }

}
