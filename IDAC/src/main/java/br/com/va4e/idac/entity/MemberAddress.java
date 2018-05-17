package br.com.va4e.idac.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "member_address")
public class MemberAddress implements Serializable{
	
	public MemberAddress() {
		super();
	}

	public MemberAddress(String street, String number, String complement, String cep, String city, String state,
			String country, int type, Member member) {
		super();
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.cep = cep;
		this.city = city;
		this.state = state;
		this.country = country;
		this.type = type;
		this.member = member;
	}

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//@NotNull
	//private int type;
	
	
	@NotNull
	private String street;
	
	@NotNull
	private String number;
	
	@NotNull
	private String complement;
	
	
	
	private String cep;
	
	//private City city;
	private String  city;
	
	//private State state;
	private String state;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	//private Country country;
	private String country;
	
	//private AddressType type;
	private int type;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;

}
