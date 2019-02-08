package pl.michalak.adam.clientserver.server;

/**
 * Server socket is open and run until it is closed manually.
 * Handles multiple connections (up to about 2000)
 * and allocates clients in rooms.
 */
public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setName("MainThread");
        new ServerAdministrator().runServer();
    }

}
