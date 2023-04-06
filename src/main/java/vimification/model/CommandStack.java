package vimification.model;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import vimification.internal.command.logic.UndoableLogicCommand;

public class CommandStack {

    private static int MAX_SIZE = 20;

    private Deque<UndoableLogicCommand> commands;

    public CommandStack() {
        this.commands = new ArrayDeque<>();
    }

    public CommandStack(Collection<? extends UndoableLogicCommand> commands) {
        this.commands = new ArrayDeque<>(commands);
        ensureSize();
    }

    private void ensureSize() {
        while (commands.size() > MAX_SIZE) {
            commands.pollFirst();
        }
    }

    public void push(UndoableLogicCommand cmd) {
        commands.offerLast(cmd);
        ensureSize();
    }

    public UndoableLogicCommand pop() {
        return commands.pollLast();
    }

    public int size() {
        return commands.size();
    }

    public boolean isEmpty() {
        return commands.isEmpty();
    }

    @Override
    public String toString() {
        return "CommandStack [commands=" + commands + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommandStack)) {
            return false;
        }
        CommandStack otherStack = (CommandStack) other;
        return commands.equals(otherStack.commands);
    }
}
