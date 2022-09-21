package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MobilePlan;
import com.example.demo.repo.PlanRepository;

@Service
public class MobilePlanServices {
	private PlanRepository repo;
    @Autowired
	public MobilePlanServices(PlanRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<MobilePlan> findAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}
	public MobilePlan add(MobilePlan entity) {
		return this.repo.save(entity);
	}
	public MobilePlan findById(int id) {
        String message=new StringBuilder("Element With Given Id").append(id).append("Not Found").toString();
        return this.repo.findById(id)
                .orElseThrow(()-> new RuntimeException(message));
    }
	public MobilePlan remove(int id) {
	      MobilePlan element= findById(id);
	       this.repo.deleteById(element.getPlanId());
	       return element;
	    }
	    public void update(MobilePlan entity) {
	            this.repo.save(entity);
	        }
	    public List<MobilePlan> findByPlanName(String planName){
	    	return this.repo.findByPlanName(planName);
	    }
	    public List<MobilePlan> findCostGrtThan(double cost){
	    	return this.repo.getCostGrtThan(cost);
	    	
	    }
	    public int updateValidity(String updatedValue,String planName) {
	    	return this.repo.updateValidity(updatedValue, planName);
	    }
}
