import java.util.ArrayList;
import java.util.Scanner;

public class ChatApp {
    private ArrayList<User> users;
    private ArrayList<Message> messages;

    public ChatApp() {
        users = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void sendMessage(String sender, String receiver, String content) {
        User senderUser = findUser(sender);
        User receiverUser = findUser(receiver);
        if (senderUser != null && receiverUser != null) {
            Message message = new Message(sender, receiver, content);
            messages.add(message);
            System.out.println("Message sent from " + sender + " to " + receiver);
        } else {
            System.out.println("Sender or receiver not found.");
        }
    }

    public void viewMessages(String username) {
        for (Message message : messages) {
            if (message.getReceiver().equals(username) || message.getSender().equals(username)) {
                System.out.println(message.getTimestamp() + " [" + message.getSender() + " to " + message.getReceiver() + "]: " + message.getContent());
            }
        }
    }

    private User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ChatApp chatApp = new ChatApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Send Message");
            System.out.println("3. View Messages");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    User user = new User(username);
                    chatApp.addUser(user);
                    System.out.println("User added: " + username);
                    break;
                case 2:
                    System.out.print("Enter sender username: ");
                    String sender = scanner.nextLine();
                    System.out.print("Enter receiver username: ");
                    String receiver = scanner.nextLine();
                    System.out.print("Enter message content: ");
                    String content = scanner.nextLine();
                    chatApp.sendMessage(sender, receiver, content);
                    break;
                case 3:
                    System.out.print("Enter username to view messages: ");
                    String userToView = scanner.nextLine();
                    chatApp.viewMessages(userToView);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

