public class ChillGuy extends NPC {
    public ChillGuy() {
        super("guy", "A guy is just chilling in the liminal space, looking relaxed.");
    }

    @Override
    public void talk() {
        say("Hey there! Just chilling, you know? Nothing much to do around here.");
        String[] options = {
            "Why are you here?",
            "Can you help me with something?",
            "Just wanted to say hi."
        };
        getResponse(options);
    }

    @Override
    public void response(int option) {
        switch (option) {
            case 1:
                say("Why am I here? Good question. Just vibing, really. Liminal spaces have a certain charm, don't they?");
                break;
            case 2:
                say("Help you? Hmm, I don't know if I can be of much use. I'm more of a 'relax and observe' kind of guy.");
                break;
            case 3:
                say("Hi back at ya! Feel free to chill here too, it's nice and quiet.");
                break;
            default:
                Game.print("The guy just keeps chilling, ignoring your weird question.");
                break;
        }
    }
}