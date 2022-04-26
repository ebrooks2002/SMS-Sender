import java.lang.runtime.*;

public class texting {
    public static void main(String args[]) {
        Runtime runtime = Runtime.getRuntime();
        String[] argu = { "osascript", "-e", "on run argv tell application 'Messages' set targetBuddy to '6504474476' set targetService to id of lst account whose service type = SMS set textMessage to 'hello there' set theBuddy to participant targetBuddy of account id targetService send textMessage to theBuddy end tell end run"};
        try {
            Process process = runtime.exec(argu);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
