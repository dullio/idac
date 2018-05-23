package br.com.va4e.idac.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "email", "member_id" }), name = "member_email")
public class MemberEmail implements Serializable {

	public MemberEmail(String email, int type, Member member, boolean isDefault, boolean isActive) {
		super();
		this.email = email;
		this.type = type;
		this.member = member;
		this.isDefault = isDefault;
		this.isActive = isActive;
	}

	public MemberEmail() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MemberEmail [id=" + id + ", email=" + email + ", type=" + type + ", member=" + member + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Email
	private String email;

	@NotNull
	private int type;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "member_id")
	//@JsonManagedReference
	 @JsonIgnore
	private Member member;

	@NotNull
	private boolean isDefault;

	@NotNull
	private boolean isActive;

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	// TODO: Insert validation rules and localized messages

}
