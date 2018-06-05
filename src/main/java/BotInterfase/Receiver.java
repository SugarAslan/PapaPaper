package BotInterfase;

public class Receiver{
    private String update_id;
    private String chat_id;
    private String messageText;
    private String answer;



    public Receiver(String update_id, String chat_id, String text) {
        this.update_id = update_id;
        this.chat_id = chat_id;
        this.messageText = text;

    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUpdate_id() {
        return this.update_id;
    }

    public void setUpdate_id(String update_id) {
        this.update_id = update_id;
    }

    public String getChat_id() {
        return this.chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public String getText() {
        return this.messageText;
    }

    public void setText(String text) {
        this.messageText = text;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "update_id='" + update_id + '\'' +
                ", chat_id='" + chat_id + '\'' +
                ", messageText='" + messageText + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
