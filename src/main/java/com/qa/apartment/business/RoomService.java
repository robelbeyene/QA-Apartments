package com.qa.apartment.business;

import com.qa.apartment.persistance.Room;
import com.qa.apartment.util.JSONUtil;

public interface RoomService {

	String createRoomFromString(String roomJson);

	String createRoomFromRoom(Room room);

	String updateRoomFromString(Long id, String newDetailsJson);

	String updateRoomFromRoom(Long id, Room room);

	String deleteRoom(long id);

	String findAllRooms();

	Room findRoom(long id);

	void setUtil(JSONUtil util);

}
