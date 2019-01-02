package com.ftn.isa.projekat.user.userCore.friendRequest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "friend_request")
@Data
public class FriendRequest {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "source_user")
	private Long sourceUser;
	
	@Column (name = "invited_user")
	private Long invitedUser;
	
	@Column (name = "status")
	private String status;

}
