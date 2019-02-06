package pl.michalak.adam.clientserver.client;

public class App {

    public static void main(String[] args) {
        Thread.currentThread().setName("ClientMainThread");
        new ClientAdministrator().startClient();
    }
}