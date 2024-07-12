package org.example;

import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;

public class BuilderState {
    private final Deque<String> history = new ConcurrentLinkedDeque<>();

    public void save(StringBuilder stringBuilder) {
        history.addFirst(stringBuilder.toString());
    }

    public String getPreviousState() {
        history.removeFirst();
        return Optional.ofNullable(history.pollFirst()).orElse("");
    }
}
