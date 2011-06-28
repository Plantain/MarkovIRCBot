import org.jibble.pircbot.*;
import org.jibble.jmegahal.*;
import java.util.*;
public class drBot extends PircBot {
    JMegaHal ai;
    Random r = new Random();
    private String nickname = "guess_who_I_am";
    public drBot(JMegaHal ai) {
        this.setName(nickname);
        this.ai = ai;
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) { 
        if (r.nextInt(30) == 4 || message.split(" ")[0].equals(nickname + ":")) { 
            String sentence;
            if (message.split(" ")[0].equals(nickname + ":")) {
                System.out.println(message.substring(nickname.length() + 2, message.length()));
                sentence = ai.getSentence(message.substring(nickname.length() + 2, message.length()));
            } else {
                sentence = ai.getSentence(message);
            }
            if (sentence != null)
                sendMessage(channel, sentence);
        }
    }
}
