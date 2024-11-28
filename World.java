

public class World extends Game {
	public static Room buildWorld() {
	     
		Room familyRoom = new Room("FamilyRoom");
		NPC PuppyA = new Puppy();
		familyRoom.addNPC(PuppyA);
		Combination combination = new Combination("Combination", "Combination : Left Right Left Right Goodnight");
		familyRoom.addItem(combination);
		Room livingRoom  = new Room("LivingRoom");
		NPC ChillGuyA = new ChillGuy();
		livingRoom.addNPC(ChillGuyA);
		Room tvRoom = new Room("TVRoom");
		tvRoom.setItem("Remote", "A black TV Remote. Out of batteries");
		tvRoom.setItem("TV", "It's a TV. Thankfully, the remote is out of batteries.");
		tvRoom.setItem("Couch", "You ever wonder how you manage to fit an entire Couch in your pocket? I don't.");
		Room kitchen = new Room("Kitchen");
		kitchen.setItem("Fork", "A silver fork. Where are is the Knife?");
		kitchen.setItem("Knife", " :) ");
		kitchen.setItem("Spoon", "Only a spoonful");
		Room mainBathroom = new Room("MainBathroom");
		mainBathroom.setItem("Soap Bubble", "You've somehow found a way to store the bubbles (a, singular one, that is) made by soap and water");
		mainBathroom.setItem("Toilet", "It's a toilet. Why would you even want to take this?");
		mainBathroom.setItem("Bathrobe", "+0 Defense, +0 Health, but it is stylish so +20 Charisma");
		
		Room laundryRoom = new Room("LaundryRoom");
		Room Garage = new Room("Garage");
		Safe safe = new Safe("Safe", "It's an iron cold safe...");
		Garage.addItem(safe);
		
		Room upstairs = new Room("Upstairs");
		Room Basement = new Room("Basement");
		Room bedRooms  = new Room("BedRoom");
		
		familyRoom.addExit(livingRoom, 'w');
		familyRoom.addExit(kitchen, 's');
		familyRoom.addExit(upstairs, 'u');
		livingRoom.addExit(familyRoom, 'e');
		livingRoom.addExit(upstairs, 'u');
		tvRoom.addExit(kitchen, 'e');
		tvRoom.addExit(Basement, 'd');
		kitchen.addExit(Basement, 'd');
		kitchen.addExit(mainBathroom, 's');
		kitchen.addExit(laundryRoom, 'e');
		kitchen.addExit(familyRoom, 'n');
		kitchen.addExit(tvRoom, 'w');
		mainBathroom.addExit(kitchen, 'n');
		laundryRoom.addExit(Garage, 'n');
		laundryRoom.addExit(kitchen, 'w');
		laundryRoom.addExit(mainBathroom, 's');
		Garage.addExit(laundryRoom, 's');
		upstairs.addExit(bedRooms, 'n');
		upstairs.addExit(familyRoom, 'd');
		Basement.addExit(kitchen, 'u');
		bedRooms.addExit(upstairs, 's');
		bedRooms.addExit(familyRoom, 'd');
		return livingRoom;
	}
	

}
	

