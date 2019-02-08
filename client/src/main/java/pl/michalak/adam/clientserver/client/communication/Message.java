package pl.michalak.adam.clientserver.client.communication;

/**
 * Wrapper for String representing data sent between clients.
 */
public class Message {
    private final String content;

    public Message(String content) {

        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
