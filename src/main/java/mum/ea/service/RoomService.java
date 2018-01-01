package mum.ea.service;

import java.util.List;

import mum.ea.domain.Room;

public interface RoomService {

	public List<Room> getAllRooms();

	public Room getRoom(int roomId);

	public void addRoom(Room room);

	public void updateRoom(Room room);

	public void deleteRoom(Room room);

	public void deleteRoom(int roomId);

	public List<Room> findByBuilding(int buildingId);
}
