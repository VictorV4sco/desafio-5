package com.devsuperior.demo.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String authority;
	
	@ManyToMany
	@JoinTable(
			name = "tb_user_role", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public Role() {
	}

	public Role(Long id, String authoroty) {
		this.id = id;
		this.authority = authoroty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthoroty() {
		return authority;
	}

	public void setAuthoroty(String authoroty) {
		this.authority = authoroty;
	}
	
	public void addRole(Role role) {
		roles.add(role);
	}
	
	public boolean hasRole(String roleName) {
		for(Role role : roles) {
			if (role.getAuthoroty().equals(roleName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authority, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(authority, other.authority) && Objects.equals(id, other.id);
	}
	
	
}
