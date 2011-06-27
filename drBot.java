import org.jibble.pircbot.*;
import org.jibble.jmegahal.*;
import java.util.*;
public class drBot extends PircBot {
    JMegaHal ai;
    Random r = new Random();
    public drBot(JMegaHal ai) {
        this.setName("dynotopia");
        this.ai = ai;
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) { 
        if (r.nextInt(30) == 4 || message.split(" ")[0].equals("dynotopia:")) { 
            String sentence;
            if (message.split(" ")[0].equals("dynotopia:")) {
                System.out.println(message.substring(11, message.length()));
                sentence = ai.getSentence(message.substring(11, message.length()));
            } else {
                sentence = ai.getSentence(message);
            }
            if (sentence != null)
                sendMessage(channel, sentence);
        }
    }
}
