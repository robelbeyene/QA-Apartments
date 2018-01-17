package com.qa.apartment.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.apartment.persistance.Room;
import com.qa.apartment.util.JSONUtil;

@ApplicationScoped
@Alternative
public class RoomImpl implements RoomService {

	private static final Logger LOGGER = Logger.getLogger(RoomImpl.class);
	private final int INITIAL_COUNT = 0;
	private Map<Long, Room> roomMap;
	private int ID;
	
	@Inject
	private JSONUtil util;
	
	public RoomImpl() {
		this.roomMap = new HashMap<Long, Room>();
		ID = INITIAL_COUNT;
	}
	
	@Override
	public String createRoomFromString(String roomJson) {
		ID++;
		Room aRoom = util.getObjectForJSON(roomJson, Room.class);
		LOGGER.info("In createRoomFromString method about to add to roomMap");
		roomMap.put((long) ID, aRoom);
		LOGGER.info("In createRoomFromString method added room to roomMap");
		return "{\"message\": \"room sucessfully added\"}";
		
	}

	@Override
	public String createRoomFromRoom(Room room) {
		ID++;
		LOGGER.info("In createRoomFromRoom method about to add to roomMap");
		roomMap.put((long) ID, room);
		LOGGER.info("In createRoomFromRoom method added room to roomMap");
		return "{\"message\": \"room sucessfully added\"}";
		
	}

	@Override
	public String updateRoomFromString(String newDetailsJson) {
		Room aRoom = util.getObjectForJSON(newDetailsJson, Room.class);
		LOGGER.info("In updateRoomFromString method about update room");
		updateRoomFromRoom(aRoom);
		LOGGER.info("In updateRoomFromString method sucessfully updated room");
		return "{\"message\": \"room sucessfully updated\"}";
	}

	@Override
	public String updateRoomFromRoom(Room room) {
		Room currentRoom = roomMap.get(room.getRoomId());
		LOGGER.info("In updateRoomFromRoom method about to check room is not null");
		if (currentRoom != null) {
			LOGGER.info("In updateRoomFromRoom method about to update room");
			roomMap.put(currentRoom.getRoomId(), room);
			LOGGER.info("In updateRoomFromRoom method successfully updated room");
			return "{\"message\": \"room sucessfully updated\"}";
		}
		LOGGER.info("In updateRoomFromRoom method, room is null so not updated!!");
		return "{\"message\": \"ALERT: room unsucessfully updated. "
				+ "Room to update (currentRoom) is null.\"}";
	}

	@Override
	public String deleteRoom(long id) {
		LOGGER.info("In deleteRoom method about delete room");
		roomMap.remove(id);
		LOGGER.info("In deleteRoom method sucessfully deleted room");
		return "{\"message\": \"room sucessfully deleted\"}";
		
	}

	@Override
	public List<Room> findAllRooms() {
		LOGGER.info("In findAllRooms method, attempting to cast "
				+ "HashMap roomMap to a List");
		return (List<Room>) roomMap;
	}

	@Override
	public Room findRoom(long id) {
		return roomMap.get(id);
	}
	

}
