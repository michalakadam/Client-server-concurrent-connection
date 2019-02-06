package pl.michalak.adam.clientserver.client.view;

import pl.michalak.adam.clientserver.client.communication.Message;

import java.io.PrintStream;

class ConsoleView implements ChatView {

    private final PrintStream out = System.out;

    @Override
    public void displayMessage(Message message) {
        out.println(message);
    }
}
