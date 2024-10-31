public class Item extends Game {
	public String name;
	public String description;
	
	public Item(String name, String description){
	    this.name = name;
	    this.description = description;
	}
	
	public void setName(String newname){
	    this.name = newname;
	}
	
	public void setDescription(String newdescription){
	    this.description = newdescription;
	}
	
	public String getName(){
	    return this.name;
	}
	
	public String getDesc(){
	    return this.description;
	}
	
	public void open() {
		Game.print("You can't open that!");
	}
	
	public void use() {
		Game.print("You can't use that!");
	}
	
	
	@Override
	public String toString() {
		return this.name;
	}


}


