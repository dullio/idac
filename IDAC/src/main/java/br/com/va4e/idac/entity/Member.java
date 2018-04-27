
package br.com.va4e.idac.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"firstName", "lastName"}), name = "member")
public class Member implements Serializable {
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

    

    private String userName;
    
    
    private String cpf;
    
    private String rg;
    
    //TODO: Change to enum;
    private String gender;
    
    //TODO: Change data type to "memo"
    
    private String note;
    
    
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


	private Date birthday;
    
    @OneToMany(mappedBy="member")
    private List<MemberEmail> emails;

    @OneToMany(mappedBy="member")
    private List<MemberPhone> phones;

    public Date getBirthday() {
		return birthday;
	}


	public List<MemberPhone> getPhones() {
		return phones;
	}


	public void setPhones(List<MemberPhone> phones) {
		this.phones = phones;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	@OneToMany(mappedBy="member")
    private List<MemberAddress> addresses;
    
    
    
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


	public List<MemberAddress> getAddresses() {
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
	}


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
