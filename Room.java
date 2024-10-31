import java.util.HashMap;

public class Room extends Game {
	private String description;
	public HashMap<String, Item> roomObjects  = new HashMap<String, Item>();
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	
	public Room(String descript) {
		this.description = descript; 
		
	}
	
	public Room getExit(char Direction) {
		if(Direction == 'e') {
			return this.east;
		}
		else if(Direction == 'w') {
			return this.west;
		}
		else if(Direction == 'n') {
			return this.north;
		}
		else if(Direction == 's') {
			return this.south;
		}
		else if(Direction == 'u') {
			return this.up;
		}
		else if(Direction == 'd') {
			return this.down;
		}
		else {
			return null;
		}
	}
	
	public void addExit(Room space, char Direction) {
		if(Direction == 'e') {
			this.east = space;
		}
		else if(Direction == 'w') {
			this.west = space;
		}
		else if(Direction == 'n') {
			this.north = space;
		}
		else if(Direction == 's') {
			this.south = space;
		}
		else if(Direction == 'u') {
			this.up = space;
		}
		else if(Direction == 'd') {
			this.down = space;
		}
		
	}


	
	public void addItem(Item o) {
		this.roomObjects.put(o.getName(), o);
	}
	
	public void setItem(String itemName, String itemDesc) {
		Item newObject = new Item(itemName, itemDesc);
		this.roomObjects.put(newObject.getName(), newObject);
	}
	
	public Item getItem(String itemName){
		return this.roomObjects.get(itemName);
		
	}
	
	public void removeItem(String itemName) {
		this.roomObjects.remove(itemName);
	}
	
	@Override
	public String toString() {
		return this.description;
	}
	

}


