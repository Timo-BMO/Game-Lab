
public class Combination extends Item {

	private static final long serialVersionUID = 1L;

	public Combination(String name, String description) {
		super(name, description);
		
	}

	public void use() {
		Game.print("If you find a safe, try opening it!");
	} 
}
