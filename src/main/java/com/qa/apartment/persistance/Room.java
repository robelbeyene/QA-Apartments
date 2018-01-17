package com.qa.apartment.persistance;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roomId;

	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_room_apartment"))
	private Apartment apartment;

	public Room() {

	}

	public Room(int roomId) {
		super();
		this.roomId = roomId;
	}

	public Room(int roomId, Apartment apartment) {
		super();
		this.roomId = roomId;
		this.apartment = apartment;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
}
