package com.qa.apartment.persistance;

import javax.persistence.*;


@Entity
public class Room {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long roomId;
	
	
	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_room_apartment"))
	private Apartment apartment;

	public Room(int roomId) {
		super();
		this.roomId = roomId;
	}
	
	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}	
}
