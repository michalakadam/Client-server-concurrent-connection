package pl.michalak.adam.clientserver.server;

class Message {
    private String content;

    Message(String content) {

        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
