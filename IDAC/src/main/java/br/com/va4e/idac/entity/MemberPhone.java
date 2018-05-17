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
@Table(name = "member_phone")
//@Serializable(version=12345L)
public class MemberPhone implements Serializable {

	public MemberPhone(String ddd, String phone, String extension, String note, int type, Member member) {
		super();
		this.ddd = ddd;
		this.phone = phone;
		this.extension = extension;
		this.note = note;
		this.type = type;
		this.member = member;
	}

	public MemberPhone() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ddd;

	private String phone;

	private String extension;

	private String note;

	private int type;
	
	@Override
	public String toString() {
		return "MemberPhone [id=" + id + ", ddd=" + ddd + ", phone=" + phone + ", extension=" + extension + ", note="
				+ note + ", type=" + type + ", member=" + member + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	

}
