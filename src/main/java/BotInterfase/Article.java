package BotInterfase;

public class Article{
    private String url;


    public Article(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return  url;
    }

}
