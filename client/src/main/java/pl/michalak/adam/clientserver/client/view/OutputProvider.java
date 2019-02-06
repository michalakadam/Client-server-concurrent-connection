package pl.michalak.adam.clientserver.client.view;

import pl.michalak.adam.clientserver.client.communication.Message;

import java.util.concurrent.TransferQueue;

public class OutputProvider implements Runnable{
    private final TransferQueue<Message> messagesFromServer;
    private final ChatView chatView;

    public OutputProvider(TransferQueue<Message> messagesFromServer, ChatView chatView) {
        this.messagesFromServer = messagesFromServer;
        this.chatView = chatView;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                chatView.displayMessage(messagesFromServer.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

