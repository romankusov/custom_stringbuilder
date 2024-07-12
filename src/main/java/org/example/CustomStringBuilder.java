package org.example;

public class CustomStringBuilder  {
    private final StringBuilder stringBuilder;
    private final BuilderState state = new BuilderState();

    public CustomStringBuilder() {
        stringBuilder = new StringBuilder();
    }
    public CustomStringBuilder(String str) {
        stringBuilder = new StringBuilder(str);
        state.save(stringBuilder);
    }

    public CustomStringBuilder append(String str) {
        stringBuilder.append(str);
        state.save(stringBuilder);
        return this;
    }

    public CustomStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        state.save(stringBuilder);
        return this;
    }

    public void undo(){
        stringBuilder.setLength(0);
        stringBuilder.append(state.getPreviousState());
        state.save(stringBuilder);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
