package com.teamgreen.userservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@MappedSuperclass
public class BaseModel {

	@Column(name = "id_version")
	private Integer version;

	@Column(name = "is_active")
	private Integer isActive;

	@Column(name = "id_user_mod_key")
	private Long userModkey;

	@Column(name = "dtt_mod")
	private LocalDateTime modDtt;

	@Column(name = "id_state_key")
	private Long stateId;
	

	@Column(name = "tx_desc")
	private String desc;

	public BaseModel(Integer isActive, Integer version, LocalDateTime modDtt, Long stateId) {
		super();
		this.isActive = isActive;
		this.version = version;
		this.modDtt = modDtt;
		this.stateId = stateId;
	}

	public BaseModel() {
		this.isActive = 1;
		this.modDtt = LocalDateTime.now();
		this.version = 0;
		this.stateId = 100000L;
	}

}

