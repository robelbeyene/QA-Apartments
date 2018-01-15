package com.qa.apartment.persistance;

import javax.persistence.*;


@Entity
public class Room {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int roomId;
	
	
	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_room_apartment"))
	private Apartment apartment;

	public Room() {
		
	}
	
	public Room(int roomId) {
		super();
		this.roomId = roomId;
	}
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}	
}
