package com.example.dto;

public class BeanPojo {
	
	String first;
	String second;
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	
	public BeanPojo(String first,String second){
		this.first=first;
		this.second=second;
	}
	
	public BeanPojo(BeanPojo b){
		this.first=b.getFirst();
		this.second=b.getSecond();
	}
	
	
	 public BeanPojo(){
		 
	 }
	
}
