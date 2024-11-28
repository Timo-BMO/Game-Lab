import java.util.HashMap;
import java.io.Serializable;

public class Room extends Game implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	public HashMap<String, Item> roomObjects  = new HashMap<String, Item>();
    public HashMap<String, NPC> roomNPCs = new HashMap<String, NPC>(); 
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean lock;
	
	public Room(String name) {
		this.name = name;
		Game.roomMap.put(name, this);
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
	
	public void addNPC(NPC npc) {
        this.roomNPCs.put(npc.getName(), npc);
    }

    public NPC getNPC(String npcName) {
        return this.roomNPCs.get(npcName);
    }

    public void removeNPC(String npcName) {
        this.roomNPCs.remove(npcName);
    }
    
	@Override
	public String toString() {
		return Game.roomDescriptions.getOrDefault(this.name, "No description avaiable");
		
	}

	public boolean getLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}


