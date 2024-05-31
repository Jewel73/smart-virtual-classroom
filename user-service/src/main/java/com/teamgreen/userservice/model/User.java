package com.teamgreen.userservice.model;


import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "T_USER")
public class User extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_key")
	private Long userId;

	@Column(name = "tx_user_name")
	private String userName;

	@Column(name = "tx_password")
	private String password;

	@Column(name = "tx_first_name")
	private String firstName;

	@Column(name = "tx_last_name")
	private String lastName;

	@Column(name = "tx_email")
	private String email;
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "T_USER_ROLE", joinColumns = @JoinColumn(name = "id_user_key"), inverseJoinColumns = @JoinColumn(name = "id_role_key"))
//	private List<Role> roleList;
	
	@ManyToOne
	@JoinColumn(name = "id_role_key")
	private Role role;

	@Column(name = "tx_desc")
	private String desc;
}
