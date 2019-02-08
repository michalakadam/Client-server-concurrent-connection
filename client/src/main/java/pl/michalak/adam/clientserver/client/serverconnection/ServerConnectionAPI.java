package pl.michalak.adam.clientserver.client.serverconnection;

import pl.michalak.adam.clientserver.client.communication.Message;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TransferQueue;

/**
 * Provides a method for sending Message to the server.
 */

public class ServerConnectionAPI {

    private final MessageSender messageSender;

    private ServerConnectionAPI(MessageSender messageSender){
        this.messageSender = messageSender;
    }

    public void sendMessageToServer(Message message){
        messageSender.sendToServer(message);
    }

    /**
     * Fabric method for creating an instance of ServerConnectionAPI.
     * It starts listening thread and initializes other objects from this package.
     * @param hostName defines address of the server
     * @param portNumber defines port on which the server is listening
     * @param messagesFromServer is a shared Queue for receiving and displaying messages from server.
     * @return new ServerConnectionAPI object
     * @throws IOException
     */
    public static ServerConnectionAPI create(String hostName, int portNumber, TransferQueue<Message> messagesFromServer) throws IOException {
        ConnectionHandler connectionHandler = ConnectionHandler.create(hostName, portNumber);
        Listener listener = Listener.create(connectionHandler.openInputStream(), messagesFromServer);
        Executors.newSingleThreadExecutor().execute(listener);
        MessageSender messageSender = MessageSender.create(connectionHandler.openOutputStream());
        return new ServerConnectionAPI(messageSender);
    }
}
