package pl.michalak.adam.clientserver.client;

import pl.michalak.adam.clientserver.client.communication.InputListener;
import pl.michalak.adam.clientserver.client.communication.Message;
import pl.michalak.adam.clientserver.client.communication.UsersInputReader;
import pl.michalak.adam.clientserver.client.serverconnection.ServerConnectionAPI;
import pl.michalak.adam.clientserver.client.view.ChatView;
import pl.michalak.adam.clientserver.client.view.OutputProvider;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

class ClientAdministrator {

    void startClient(){
        ChatView view = ChatView.newConsoleView();
        UsersInputReader inputReader = UsersInputReader.newConsoleReader();
        final TransferQueue<Message> messagesFromServer = new LinkedTransferQueue<>();
        try {
            ServerConnectionAPI serverConnectionAPI = ServerConnectionAPI.create("localhost", 8081, messagesFromServer);
            Executors.newSingleThreadExecutor().execute(new InputListener(inputReader, serverConnectionAPI));
            Executors.newSingleThreadExecutor().execute(new OutputProvider(messagesFromServer, view));
        } catch (IOException e) {
            System.err.println("Socket connection was disrupted!");
        }
    }
}
