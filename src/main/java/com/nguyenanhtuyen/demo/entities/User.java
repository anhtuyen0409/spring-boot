package com.nguyenanhtuyen.demo.entities;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;
	private String rolename;

	public User() {
		super();
	}

	public User(final String username, final String password, final String rolename) {
		this.username = username;
		this.password = password;
		this.rolename = rolename;
	}
	
	@Transient
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(getRolename()));
		return authorities;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name = "username", unique = true, nullable = false, length = 255)
	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Column(name = "password", unique = true, nullable = false, length = 255)
	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Column(name = "rolename", unique = true, nullable = false, length = 255)
	public String getRolename() {
		return rolename;
	}

	public void setRolename(final String rolename) {
		this.rolename = rolename;
	}

}
