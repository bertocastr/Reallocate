package es.unileon.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import es.unileon.handler.Handler;
import es.unileon.handler.OfficeHandler;

@Entity
@Table(name = "Bank")
public class Bank {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "idBank")
	private String idBank;
	
	public Bank(){
		
	}
	
	public Bank(String idBank){
		this.idBank = idBank;
	}
	
	public String getIdBank() {
		return idBank;
	}

	public void setIdBank(String idBank) {
		this.idBank = idBank;
	}

}
