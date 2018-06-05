package BotInterfase;

import java.io.IOException;

//public class JacksonParse {
//    public static void main(String[] args) throws IOException {
//        String jsonString = "[\n" +
//                "  {\"update_id\":418672078,\"message\":\n" +
//                "  {\"message_id\":24,\"from\":\n" +
//                "  {\"id\":300759932,\"is_bot\":false,\"first_name\":\"Aslan\",\"last_name\":\"Sugarov\",\"language_code\":\"ru-ru\"},\n" +
//                "    \"chat\":{\"id\":300759932,\"first_name\":\"Aslan\",\"last_name\":\"Sugarov\",\"type\":\"private\"},\n" +
//                "    \"date\":1525940847,\"text\":\"/update\",\"entities\":[{\"offset\":0,\"length\":6,\"type\":\"bot_command\"}]}}]";
//        BotInterfase botInterfase = new BotInterfase();
//        System.out.println(botInterfase.initiate(jsonString));
//    }
//}
public class BotInterfase{
    public Receiver initiate(String jsonString) throws IOException {
        BotAnswer botAsk = new BotAnswer(jsonString);
        return botAsk.botAnswer();
    }
}
