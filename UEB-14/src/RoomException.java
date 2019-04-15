
public class RoomException extends Exception {
	public static final String MSG_NEG_BUILDING_NBR =
			"Die Gebäude Nummer darf nicht negativ sein.";
	public static final String MSG_NEG_FLOOR_NBR =
			"Die Etagen Nummer darf nicht negativ sein.";
	public static final String MSG_NEG_ROOM_NBR =
			"Die Raum Nummer darf nicht negativ sein.";
	
	public RoomException() {
		super();
	}

	/**
	 * @param message error
	 */
	public RoomException(String message) {
		super(message);
	}
	
	/**
	 * @param buildingG
	 * @throws RoomException when building is negative
	 */
	public static void negativeBuildingNumber(int buildingG) throws RoomException {
		if(buildingG < 0) {
			throw new RoomException(MSG_NEG_BUILDING_NBR);
		}
	}

	/**
	 * @param floorG
	 * @throws RoomException when floor is negative
	 */
	public static void negativeFloorNumber(int floorG) throws RoomException {
		if(floorG < 0) {
			throw new RoomException(MSG_NEG_FLOOR_NBR);
		}
	}
	
	/**
	 * @param roomG
	 * @throws RoomException when room is negative
	 */
	public static void negativeRoomNumber(int roomG) throws RoomException {
		if(roomG < 0) {
			throw new RoomException(MSG_NEG_ROOM_NBR);
		}
	}
}
