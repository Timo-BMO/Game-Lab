public class Puppy extends NPC {
    private int talkCount = 0;

    public Puppy() {
        super("puppy", "A hideous puppy wags his tail.");
    }

    @Override
    public void talk() {
        switch (talkCount) {
            case 0:
                say("Hi! I'm an adorable puppy!");
                String[] options1 = {
                    "Yes you are! Who's a good boy?",
                    "Ew, no. You're actually kinda hideous."
                };
                getResponse(options1);
                break;
            case 1:
                say("Hey! Wanna play fetch? Say yes! Say yes!");
                String[] options2 = {
                    "Yes! I love fetch!",
                    "No. I am a horrible person and don't like playing with puppies."
                };
                getResponse(options2);
                break;
            default:
                say("Yip!");
                Game.print("The puppy wags his tail.");
                break;
        }
        talkCount++;
    }

    @Override
    public void response(int option) {
        switch (talkCount) {
            case 1: // Response for Dialog 1
                switch (option) {
                    case 1:
                        say("I am! I'm a good boy!");
                        break;
                    case 2:
                        say("I am adorable! Why are you so mean?");
                        Game.print("The puppy bites you. You deserve it.");
                        break;
                }
                break;
            case 2: // Response for Dialog 2
                switch (option) {
                    case 1:
                        say("Yay! Fetch!");
                        Game.print("The puppy runs off and returns with a ball. You receive the ball.");
                        Item ball = new Item("Ball", "A bouncy rubber ball.");
                        Game.inventory.add(ball);
                        break;
                    case 2:
                        say("You're a bad person! I don't like you!");
                        Game.print("The puppy runs away and doesn't come back.");
                        break;
                }
                break;
            default:
                Game.print("The puppy seems happy just wagging his tail.");
                break;
        }
    }
}
