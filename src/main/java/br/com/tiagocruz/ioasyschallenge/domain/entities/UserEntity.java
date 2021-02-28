package br.com.tiagocruz.ioasyschallenge.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -3908376807059220089L;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "is_admin")
	private Boolean isAdmin;

	@Column(name = "is_deleted")
	private Boolean isDeleted = Boolean.FALSE;

	public Integer getId() {

		return id;
	}

	public void setId(final Integer id) {

		this.id = id;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(final String userName) {

		this.userName = userName;
	}

	public Boolean getAdmin() {

		return isAdmin;
	}

	public void setAdmin(final Boolean admin) {

		isAdmin = admin;
	}

	public Boolean getDeleted() {

		return isDeleted;
	}

	public void setDeleted(final Boolean deleted) {

		isDeleted = deleted;
	}
}
