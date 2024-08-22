package app;

public class ConsolePrinter implements Printer {

    // Статичний внутрішній клас Message
    public static class Message {
        private String text;
        private String sender;

        public Message(String text, String sender) {
            this.text = text;
            this.sender = sender;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }
    }

    @Override
    public void print(String text, String sender) {
        if ((text == null || text.isEmpty()) &&
                (sender == null || sender.isEmpty())) {

            // Анонімний клас для обробки пустого повідомлення
            Printer emptyMessageHandler = new Printer() {
                @Override
                public void print(String text, String sender) {
                    System.out.println("Опрацьовується пусте повідомлення від анонімного користувача...");
                }
            };
            emptyMessageHandler.print(text, sender);

        } else if (sender == null || sender.isEmpty()) {
            System.out.println("Анонімний користувач відправив повідомлення: " + text);
        } else {
            System.out.println("Користувач " + sender + " відправив повідомлення: " + text);
        }
    }

    public static void main(String[] args) {
        ConsolePrinter printer = new ConsolePrinter();

        // Приклади використання
        Message message1 = new Message("Привіт!", "John");
        printer.print(message1.getText(), message1.getSender());

        Message message2 = new Message("Як справи?", "");
        printer.print(message2.getText(), message2.getSender());

        Message message3 = new Message("", null);
        printer.print(message3.getText(), message3.getSender());

        Message message4 = new Message(null, null);
        printer.print(message4.getText(), message4.getSender());
    }
}
