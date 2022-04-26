import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.runtime.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class texting {

    public static void text(String number, String message) {
        // String[] argu = {"osascript", "-e", "on run argv tell application 'Messages' set targetBuddy to '6504474476' set targetService to id of lst account whose service type = SMS set textMessage to 'hello there' set theBuddy to participant targetBuddy of account id targetService send textMessage to theBuddy end tell end run"};

        String[] launchCmd = {"osascript", "-e",    "on run argv\n" +
                                                        "tell application \"Messages\"\n" +
                                                            "set targetBuddy to (item 1 of argv)\n" +
                                                            "set targetService to id of 1st account whose service type = SMS\n" +
                                                            "set textMessage to (item 2 of argv)\n" +
                                                            "set theBuddy to participant targetBuddy of account id targetService\n" +
                                                            "send textMessage to theBuddy\n" +
                                                        "end tell\n" +
                                                    "end run", number, message
                                                };
        try {
            Process process = Runtime.getRuntime().exec(launchCmd);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // BufferedReader bufferedReader = new BufferedReader(
        // new InputStreamReader(process.getErrorStream()));
        // while (true) {
        //     String result = bufferedReader.readLine();
        //     if (result == null) break;
        //     System.out.println(result);
        // }
    }

    public static void main(String[] args) {
        text("6504474476", "Java still works");
    }
}
