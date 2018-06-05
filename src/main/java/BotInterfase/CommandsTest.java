package BotInterfase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandsTest {
    private String command;

    public CommandsTest(String command) {
        this.command = command;
    }

    public String checCommand() throws IOException {
        if(command.equals("\"/start\""))return startMessage();
        else{
            if(command.equals("\"/next\"")) return nextMessage();
            else {
                if (command.equals("\"/update\"")){updateMessage();return "Updating";}
                else return "Wrong command";}
        }
    }

    private String startMessage(){
        return "Hi! I'm Paper, now I send u interesting information about IT sphere in this time.\n" +
                "Enter /next to get new article";
    }

    private String nextMessage(){
        return "Next article";
    }

    private void updateMessage() throws IOException {

        ParserHabr parser = new ParserHabr();
        List<Article> articleList = new ArrayList<Article>();
        articleList = parser.articles();
        SaverCSV saveCSV = new SaverCSV();
        saveCSV.saverCSV(articleList);

    }
}
