package pl.michalak.adam.clientserver.client;

public class App {

    /**
     * Client socket is open and run until it is closed manually.
     * It sends messages from user to server
     * and receives messages from server displaying them appropriately.
     */
    public static void main(String[] args) {
        Thread.currentThread().setName("ClientMainThread");
        new ClientAdministrator().startClient();
    }
}