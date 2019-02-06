package pl.michalak.adam.clientserver.client.view;

import pl.michalak.adam.clientserver.client.communication.Message;

/**
 * Displays user interface and messages
 */
public interface ChatView {

    void displayMessage(Message message);

    static ChatView newConsoleView() {
        return new ConsoleView();
    }
}
