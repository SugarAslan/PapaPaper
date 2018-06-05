package BotInterfase;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedList;

class BotAnswer{

    private String jsonString;

    public BotAnswer(String jsonString) {
        this.jsonString = jsonString;
    }

    public Receiver botAnswer() throws IOException {

        RandomArticle ran = new RandomArticle();
        JSonParser jSonParser = new JSonParser(jsonString);
        LinkedList<Receiver> messages;
        CommandsTest commands;
        String ask,answer = "";
        messages = jSonParser.getMessages();
        Receiver reqwest = messages.get(0);

        for (Receiver message:messages) {
            commands = new CommandsTest(message.getText());
            ask = commands.checCommand();
            reqwest = message;
            if(ask.equals("Next article")){
                answer =(ran.getRandomArticle()).toString();
                reqwest.setAnswer(answer);
            }
            else reqwest.setAnswer(ask);
        }
        return reqwest;
    }


}

class JSonParser{
    private String jsoString;
    private String update_id;
    private String chat_id;
    private String messageText;
    private Receiver receive;

    LinkedList<Receiver> messages = new LinkedList<Receiver>();

    public JSonParser(String jsoString) {
        this.jsoString = jsoString;
    }

    public void setJsoString(String jsoString) {
        this.jsoString = jsoString;
    }

    public LinkedList<Receiver> getMessages() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actObj = mapper.readTree(jsoString);
        for (int i = 0; i < actObj.size(); i++) {
            update_id = (actObj.get(i)).get("update_id").toString();
            chat_id = (((actObj.get(i)).get("message")).get("chat")).get("id").toString();
            messageText = ((actObj.get(i)).get("message")).get("text").toString();
            receive = new Receiver(update_id,chat_id,messageText);
            messages.add(receive);
        }

        return messages;
    }


}
