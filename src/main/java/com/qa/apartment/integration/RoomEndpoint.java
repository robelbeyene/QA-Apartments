package com.qa.apartment.integration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.apartment.business.RoomDBImple;
import com.qa.apartment.persistance.Room;
import com.qa.apartment.util.JSONUtil;

@Path("/room")
public class RoomEndpoint {

	@Inject
	private RoomDBImple roomService;

	@Inject
	private JSONUtil jsonUtil;

	@Path("/getRoom/{id}")
	@GET
	public String getRoom(@PathParam("id") long id) {
		Room room = roomService.findRoom(id);
		return jsonUtil.getJSONForObject(room);
	}

	@Path("/getRoom")
	@GET
	public String getAllRooms() {
		return roomService.findAllRooms();
	}

	@Path("/addRoom")
	@POST
	public void createRoom(String json) {
		roomService.createRoomFromString(json);
	}

	@Path("/deleteRoom/{id}")
	@DELETE
	public void deleteRoom(@PathParam("id") long id) {
		roomService.deleteRoom(id);
	}

}
