package com.qa.apartment.business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import com.qa.apartment.persistance.Room;
import com.qa.apartment.util.JSONUtil;

public class RoomDBImple {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	private JSONUtil util = new JSONUtil();

	@Transactional(Transactional.TxType.REQUIRED)
	public void createRoomFromString(String room) {
		Room aRoom = util.getObjectForJSON(room, Room.class);
		createRoomFromRoom(aRoom);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String createRoomFromRoom(Room room) {
		em.persist(room);
		return "{\"message\": \"room sucessfully added\"}";
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void updateRoomFromString(String newDetails) {
		Room aRoom = util.getObjectForJSON(newDetails, Room.class);
		updateRoomFromRoom(aRoom);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String updateRoomFromRoom(Room room) {
		em.merge(room);
		return "{\"message\": \"room sucessfully updated\"}";
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String deleteRoom(long id) {
		em.remove(findRoom(id));
		return "{\"message\": \"room sucessfully removed\"}";
	}
	
	public List<Room> findAllRooms() {
		TypedQuery<Room> query = em.createQuery("SELECT r FROM ROOM r ORDER BY r.id", Room.class);
		return query.getResultList();
	}
	
	public Room findRoom(Long id) {
		return em.find(Room.class, id);
	}
	
	

}
