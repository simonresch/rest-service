package hello.model;

public class Greeting {

    private final long id;
    private final String content;

    private final char specialChar;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
        this.specialChar = content.charAt(3);
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
