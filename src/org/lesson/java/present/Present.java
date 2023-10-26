package org.lesson.java.present;

public class Present {

    // Attributi
    private final String receiver;

    private final String description;

    // Costruttori

    public Present(String receiver, String description) {
        this.receiver = receiver;
        this.description = description;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return "Present{" +
                "receiver='" + receiver + '\'' +
                ", description='" + description + '\'' +
                "}";
    }
}
