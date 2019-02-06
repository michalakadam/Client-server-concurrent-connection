package pl.michalak.adam.clientserver.client.communication;

/**
 * Reads input from user
 */
public interface UsersInputReader{

    String readLine();

    static UsersInputReader newConsoleReader() {
        return new ConsoleInputReader();
    }
}
