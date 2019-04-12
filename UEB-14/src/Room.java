
/**
 * Class Room
 * @author marie-louwechsler
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
	 * @param buildingG int
	 * @param floorG int
	 * @param roomG int
	 * @throws RoomException when room is incorrect
	 */
	public Room(int buildingG, int floorG, int roomG) throws RoomException {
		this.building = buildingG;
		this.floor = floorG;
		this.room = roomG;
		
		reservationList = new Reservation[RESERVATION_NUMBER_MAX];
		reservationNumber = 0;
	}
	
	/**
	 * @param reservationG Reservation
	 */
	public void addReservation(Reservation reservationG) {
		reservationList[reservationNumber] = reservationG;
		reservationNumber++;
	}
	
	@Override
	public String toString() {
		String output = "Raum "+ building +"-"+ floor +"."+ room;
		
		for(int i = 0; i < reservationNumber; i++) {
			output += "\n"+ reservationList[i];
		}
		
		return output + "\n";
	}
}