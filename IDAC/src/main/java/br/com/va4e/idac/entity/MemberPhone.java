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
public class MemberPhone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ddd;

	private String phone;

	private String extension;

	private String note;

	private int type;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	

}
