
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	public static HashMap<String, String> roomDescriptions = new HashMap<>();
	public static HashMap<String, Room> roomMap = new HashMap<String, Room>(); // Static HashMap to hold all rooms
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static Room currentRoom;
	public static Scanner scan = new Scanner(System.in); // Public static Scanner for user input

	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static Room getRoom() {
		return currentRoom;
	}
	
	

	
	public static void main(String[] args) {
		loadRoomDescriptions("C:\\Users\\aoski\\Downloads\\Game-Lab-main\\Game-Lab-main\\roomDescription");
		runGame();
	}
	
	public static void loadRoomDescriptions(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String roomName = null;
            StringBuilder roomDescription = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.equals("#")) {
                    if (roomName != null) {
                        roomDescriptions.put(roomName, roomDescription.toString().trim());
                    }
                    roomName = null;
                    roomDescription = new StringBuilder();
                } else if (roomName == null) {
                    roomName = line.trim();
                } else {
                    roomDescription.append(line).append(" ");
                }
            }

            // Add the last room if file doesn't end with "#"
            if (roomName != null) {
                roomDescriptions.put(roomName, roomDescription.toString().trim());
            }

        } catch (IOException e) {
            System.out.println("Error reading room descriptions: " + e.getMessage());
        }
    }
	
	public Item returnObject(String itemName) {
		Item foundObject = null;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getName().equals(itemName)){
				foundObject = inventory.get(i);
			}
			
		}
		
		return foundObject;
	}
	
	public static void runGame() {
		Room currentRoom = World.buildWorld();
		
		String command; // player's command
		do {
			System.out.println(currentRoom);
			System.out.print("Where do you want to go? ");
			command = scan.nextLine();
			String[] readcommand = command.split("[,\\.\\s]");
			
			
			switch(readcommand[0]) {
			case "e":
				currentRoom = currentRoom.getExit('e');
				break;

			case "w":
				currentRoom = currentRoom.getExit('w');

				break;
			case "n":
				currentRoom = currentRoom.getExit('n');
				
				break;
			case "s":
				currentRoom = currentRoom.getExit('s');
				
				break;
			case "u":
				currentRoom = currentRoom.getExit('u');
				break;
				
			case "d":
				currentRoom = currentRoom.getExit(command.charAt(0));
				break;
			case "x":
				System.out.println("Thanks for walking through my game!");
				break;
			case "take":
				if(currentRoom.getItem(readcommand[1]) != null) {
					System.out.println("You have taken " + currentRoom.getItem(readcommand[1]).getName());
					inventory.add(currentRoom.getItem(readcommand[1]));
					currentRoom.removeItem(readcommand[1]);
				}
				else{
					System.out.println("That item is not in this room.");
				}
			break;
			
			case "use":
				if(currentRoom.getItem(readcommand[1]) != null) {
					System.out.println("You've attempted to use the " + currentRoom.getItem(readcommand[1]).getName());
					currentRoom.getItem(readcommand[1]).use();
				}
				else if (inventory.size() > 0){
					for(int i = 0; i < inventory.size(); i++) {
						if(inventory.get(i).getName().equals(readcommand[1])) {
							System.out.println("You've attempted to use the " + inventory.get(i).getName());
							inventory.get(i).use();
						}
						
					}
					
				}
				else{
					System.out.println("That item is not in this room.");
				}
			break;
			
			case "open":
				if(currentRoom.getItem(readcommand[1]) != null) {
					System.out.println("You've attempted to use the " + currentRoom.getItem(readcommand[1]).getName());
					currentRoom.getItem(readcommand[1]).open();
				}
				else if (inventory.size() > 0){
					for(int i = 0; i < inventory.size(); i++) {
						if(inventory.get(i).getName().equals(readcommand[1])) {
							System.out.println("You've attempted to use the " + inventory.get(i).getName());
							inventory.get(i).open();
						}
						
					}
					
				}
				else{
					System.out.println("That item is not in this room.");
				}
			break;
			case "look":
				if(currentRoom.getItem(readcommand[1]) != null) {
					System.out.println(currentRoom.getItem(readcommand[1]).getDesc());
				}
				else if (inventory.size() > 0){
					for(int i = 0; i < inventory.size(); i++) {
						if(inventory.get(i).getName().equals(readcommand[1])) {
							System.out.println(inventory.get(i).getDesc());
						}
						
					}
					
				}
				else {
					System.out.println("No such item exists");
				}
				
				break;
				
			case "i":
				if(inventory.size() == 0) {
					System.out.println("You're carrying nothing");
				}
				else {
					System.out.println(inventory);
				}
				break;
			case "save":
				saveGame("savegame.dat");
				break;
			case "load":
				loadGame("savegame.dat");
				break;
			case "talk":
                if(currentRoom.getNPC(readcommand[1]) != null) {
                    currentRoom.getNPC(readcommand[1]).talk();
                } else {
                    System.out.println("There is no one by that name here.");
                }
                break;
			default:
				System.out.println("I don't know what that means.");
			}
			
		} while(!command.equals("x"));
		
		scan.close();
	}
	
	public static void saveGame(String fileName) {
	    File f = new File(fileName);
	    try (FileOutputStream fos = new FileOutputStream(f);
	         ObjectOutputStream stream = new ObjectOutputStream(fos)) {
	        
	    	if (getRoom() == null) {
	    	    System.out.println("Warning: Current room is null before saving.");
	    	    return;
	    	}
	        // Save game state objects
	        stream.writeObject(currentRoom);
	        
	        stream.writeObject(inventory);
	        stream.writeObject(roomMap);
	        
	        System.out.println("Current Room: " + currentRoom);
	        System.out.println("Inventory: " + inventory);
	        
	        System.out.println("Game saved successfully to " + fileName);
	    } catch (FileNotFoundException e) {
	        System.out.println("File " + fileName + " not found.");
	    } catch (IOException ex) {
	        System.out.println("Failed to save game: " + ex.getMessage());
	    }
	}

	public static void loadGame(String fileName) {
	    File f = new File(fileName);
	    try (FileInputStream fis = new FileInputStream(f);
	         ObjectInputStream stream = new ObjectInputStream(fis)) {
	        
	        // Load game state objects
	    	Room loadedRoom = (Room) stream.readObject();
	        inventory = (ArrayList<Item>) stream.readObject();
	        roomMap = (HashMap<String, Room>) stream.readObject();
	        
	    	currentRoom = loadedRoom;
	       
	        System.out.println("Game loaded successfully from " + fileName);
	        System.out.println("Current Room: " + currentRoom);
	        System.out.println("Inventory: " + inventory);
	    } catch (FileNotFoundException e) {
	        System.out.println("File " + fileName + " not found.");
	    } catch (IOException ex) {
	        System.out.println("Failed to load game: " + ex.getMessage());
	    } catch (ClassNotFoundException ex) {
	        System.out.println("Failed to load game: Object type mismatch.");
	    }
	}
	
}



