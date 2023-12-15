package it.tecninf.hrmanagement.utility;

public class Chart {
	private String skill;
	private int quantity;
	
	public Chart(String skill,int quantity) {
		this.skill = skill;
		this.quantity = quantity;
	}
	
	public String getSkill() {
		return this.skill;
		
	}
	
	public int getQuantity() {
		return this.quantity;
	}
}
