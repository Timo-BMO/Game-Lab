

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static Room currentRoom;
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static Room getRoom() {
		return currentRoom;
	}
	
	public static void main(String[] args) {
		runGame();
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
		Scanner input = new Scanner(System.in);
		
		String command; // player's command
		do {
			System.out.println(currentRoom);
			System.out.print("Where do you want to go? ");
			command = input.nextLine();
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
			default:
				System.out.println("I don't know what that means.");
			}
			
		} while(!command.equals("x"));
		
		input.close();
	}
	
}



