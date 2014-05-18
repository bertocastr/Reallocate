package es.unileon.domain;

import java.util.ArrayList;
import java.util.List;

import es.unileon.handler.Handler;

public class Bank {

	private List<Office> listOfOffice;
	private Handler officeId;
	private String name;
	
	public Bank(String name){
		this.name = name;
		this.listOfOffice = new ArrayList<Office>();
	}
	
	public void addOffice(Office office){
		this.officeId = office.getId();
		if(seekOffice(this.officeId))
			this.listOfOffice.add(office);
	}
	
	public boolean seekOffice(Handler officeId){
		int count = 0;
		boolean found = false;
		while(count<this.listOfOffice.size() && this.listOfOffice.size()>1){
			if(this.listOfOffice.get(count).getId().equals(officeId))
				found = true;
				
			count++;
		}
		return found;
	}
}
