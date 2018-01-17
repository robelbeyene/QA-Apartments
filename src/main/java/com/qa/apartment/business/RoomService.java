package com.qa.apartment.business;

import java.util.List;

import com.qa.apartment.persistance.Room;

public interface RoomService {
	
	String createRoomFromString(String roomJson);
	
	String createRoomFromRoom(Room room);
	
	String updateRoomFromString(String newDetailsJson);
	
	String updateRoomFromRoom(Room room);
	
	String deleteRoom(long id);
	
	List<Room> findAllRooms();
	
	Room findRoom(long id);

}
