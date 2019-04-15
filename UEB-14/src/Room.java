
/**
 * Class Room
 * @author marie-louwechsler/Quentin Duflot
 * @version 1.1
 */

public class Room {
	private int building;
	private int floor;
	private int room;
	
	private int RESERVATION_NUMBER_MAX = 12;
	private Reservation[] reservationList;
	private int reservationNumber;
	
	/**
	 * @param buildingG int building number (>0)
	 * @param floorG int floor number (>0)
	 * @param roomG int room number (>0)
	 * @throws RoomException when room is incorrect
	 */
	public Room(int buildingG, int floorG, int roomG) throws RoomException {
		RoomException.negativeBuildingNumber(buildingG);
		RoomException.negativeFloorNumber(floorG);
		RoomException.negativeRoomNumber(roomG);
		
		this.building = buildingG;
		this.floor = floorG;
		this.room = roomG;
		
		reservationList = new Reservation[RESERVATION_NUMBER_MAX];
		reservationNumber = 0;
	}
	
	/**
	 * addReservation-method: add a resevation to the reservation array
	 *
	 * @param reservationG Reservation to added to the array
	 */
	public void addReservation(Reservation reservationG) throws RoomException {
		RoomExeption.arrayFull(reservationNumber,RESERVATION_NUMBER_MAX);
		reservationList[reservationNumber] = reservationG;
		reservationNumber++;
	}

	public int getBuilding() {
		return building;
	}

	public int getFloor() {
		return floor;
	}

	public int getRoom() {
		return room;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Raum");
		sb.append(" ")
				.append(building)
				.append("-")
				.append(floor)
				.append(".")
				.append(room);
		for (int i = 0; i < reservationNumber; i++){
			sb.append("\n").append(reservationList[i]);
		}
		return sb.toString();
	}
}