
package br.com.va4e.idac.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.va4e.idac.model.AuditModel;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"firstName", "lastName"}), name = "member")
public class Member extends AuditModel implements Serializable {
	/*public Member(String firstName, String lastName, String userName, String cpf, String rg, String gender, String note,
			boolean isActive, Date birthday, List<MemberEmail> emails, List<MemberPhone> phones,
			List<MemberAddress> addresses)*/
    public Member(String firstName, String lastName, String userName, String cpf, String rg, String gender, String note,
			boolean isActive, Date birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.cpf = cpf;
		this.rg = rg;
		this.gender = gender;
		this.note = note;
		this.isActive = isActive;
		this.birthday = birthday;
/*		this.emails = emails;
		this.phones = phones;
		this.addresses = addresses;*/
	}


	public Member() {

	}


	/**
     * Default value included to remove warning. Remove or modify at will. *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    private String firstName;

    
    @NotNull
    @Size(min = 2, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    private String lastName;

    @Column(unique=true)
    @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
    private String userName;
    
    
    private String cpf;
    
    private String rg;
    
    //TODO: Change to enum;
    private String gender;
    
    //TODO: Change data type to "memo"
    
    private String note;
    
    @NotNull
    private boolean isActive;
    
    @Temporal(TemporalType.DATE)
	private Date birthday;
    
   /* @OneToMany(mappedBy="member", cascade={CascadeType.ALL})
    //@JsonBackReference
    private List<MemberEmail> emails;

    @OneToMany(mappedBy="member", cascade={CascadeType.ALL})
    //@JsonBackReference
    private List<MemberPhone> phones;
    
	@OneToMany(mappedBy="member", cascade={CascadeType.ALL})
	//@JsonBackReference
    private List<MemberAddress> addresses;*/
    
  /*  public void addEmail(MemberEmail email) {
    	
    	TODO:
    	 * Check if email already exists 
    	 
    	
    	emails.add(email);
    	
    }
	
    public void addPhone(MemberPhone phone) {
    	TODO:
    	 * Check if phone already exists 
    	 
    	phones.add(phone);
    	
    }
	
    public void addAddress(MemberAddress address) {
    	TODO:
    	 * Check if address already exists 
    	 
    	addresses.add(address);
    	
    }*/
    
	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}




    public Date getBirthday() {
		return birthday;
	}


/*	public List<MemberPhone> getPhones() {
		return phones;
	}


	public void setPhones(List<MemberPhone> phones) {
		this.phones = phones;
	}
*/

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}    
    
    
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


/*	public List<MemberAddress> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<MemberAddress> addresses) {
		this.addresses = addresses;
	}


	public List<MemberEmail> getEmails() {
		return emails;
	}


	public void setEmails(List<MemberEmail> emails) {
		this.emails = emails;
	}*/


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ "]";
	}
    
    



}
