import org.jibble.jmegahal.*;
import java.util.Scanner;
import java.io.File;
public class drBotDriver {
    public static void main(String[] str) throws Exception {
        JMegaHal ai = new JMegaHal();

        Scanner sc = new Scanner(new File("input.txt"));
        int learnt = 0;
        while (sc.hasNextLine()) {
            ai.add(sc.nextLine().replaceAll("(\\r|\\n)", ""));
            learnt++;
        }

        System.out.println("learnt " + learnt + " strings");

        drBot p = new drBot(ai);
        p.setVerbose(true);
        p.connect("irc.freenode.net");
        p.joinChannel("#compsci.adl");
    }
}
