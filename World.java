

public class World extends Game {
	public static Room buildWorld() {
	     
		Room familyRoom = new Room("You're currently in the Family Room. There's a painting, with a Combination drawn beneath it. There's the living room to the West, and the Kitchen to the South. You could go upstairs as well.");
		Combination combination = new Combination("Combination", "Combination : Left Right Left Right Goodnight");
		familyRoom.addItem(combination);
		Room livingRoom  = new Room("You're currently in the Living Room. There's the family room to the East, or you could go upstairs.");
		Room tvRoom = new Room("You're currently in the TV Room. There's a Remote, a TV, and a Couch. There's the kitchen to the East, or you could go downstairs to the basement.");
		tvRoom.setItem("Remote", "A black TV Remote. Out of batteries");
		tvRoom.setItem("TV", "It's a TV. Thankfully, the remote is out of batteries.");
		tvRoom.setItem("Couch", "You ever wonder how you manage to fit an entire Couch in your pocket? I don't.");
		Room kitchen = new Room("You're currently in the Kitchen. TThere's a Fork and a Spoon. You could go downstairs to the Basement, south for the Bathroom, or East to the Laundry Room. You could also go North for the Family Room, or West for the TV Room.");
		kitchen.setItem("Fork", "A silver fork. Where are is the Knife?");
		kitchen.setItem("Knife", " :) ");
		kitchen.setItem("Spoon", "Only a spoonful");
		Room mainBathroom = new Room("You're currently in the bathroom. Nothing to do here but stare at a single painting placed to make the room look lively. There's a Toilet, Soap Bubble, and a Bathrobe. Head North to exit to the Kitchen.");
		mainBathroom.setItem("Soap Bubble", "You've somehow found a way to store the bubbles (a, singular one, that is) made by soap and water");
		mainBathroom.setItem("Toilet", "It's a toilet. Why would you even want to take this?");
		mainBathroom.setItem("Bathrobe", "+0 Defense, +0 Health, but it is stylish so +20 Charisma");
		
		Room laundryRoom = new Room("You're currently in the Laundry Room. You could head North for the Garage, or West for the Kitchen. You could also head South for the Bathroom.");
		Room Garage = new Room("You're in the Garage. There's nothing here but miscalleous items collecting dust. Oh and that Safe in the back. You can head South to exit to the Laundry Room.");
		Safe safe = new Safe("Safe", "It's an iron cold safe...");
		Garage.addItem(safe);
		
		Room upstairs = new Room("You're currently going upstairs. Nothing to see here but the Bedrooms. You can head north to enter one though. Or down to go back to the Family Room.");
		Room Basement = new Room("You've gone downstairs to the Basement. Nothing to see here but a failed attempt at a 'Man Cave'. Head Up to go upstairs to the Kitchen.");
		Room bedRooms  = new Room("You're currently in the Bedrooms. There's a bed, as Bedrooms would imply to have. You can head south to reach the Stairs, or simply go Down to reach the Family Room.");
		
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
	

