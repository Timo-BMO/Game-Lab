
public class Safe extends Item {

	private static final long serialVersionUID = 1L;

	public Safe(String name, String description) {
		super(name, description);
		
	}
	
	public void open() {
		boolean worked = false;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getName().equals("Combination")) {
				Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pcoket the diamond.");
				Item diamond = new Item("Diamond", "It's a shiny blue diamond. Nothing much about it besides the fact that it's a diamond. How boring.");
				inventory.add(diamond);
				worked = true;
			}
		}
		if(worked) {
			
		}
		else {
			Game.print("The safe is locked, and you don't have the combination");
		
		}
		
	}

}
