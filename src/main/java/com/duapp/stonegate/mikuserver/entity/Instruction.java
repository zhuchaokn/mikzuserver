package com.duapp.stonegate.mikuserver.entity;

public class Instruction {
    private int instructionId;
    private String keyword;
    private int command;
    private String action;
    private int nextInstruction;
    private String clientAction;

    public void setClientAction(String clientAction) {
        this.clientAction = clientAction;
    }

    public String getClientAction() {
        return clientAction;
    }

    public String getAction() {
        return action;
    }

    public int getCommand() {
        return command;
    }

    public int getInstructionId() {
        return instructionId;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getNextInstruction() {
        return nextInstruction;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public void setInstructionId(int instructionId) {
        this.instructionId = instructionId;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setNextInstruction(int nextInstruction) {
        this.nextInstruction = nextInstruction;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "instructionId=" + instructionId +
                ", keyword='" + keyword + '\'' +
                ", command=" + command +
                ", action='" + action + '\'' +
                ", nextInstruction=" + nextInstruction +
                ", clientAction='" + clientAction + '\'' +
                '}';
    }
}
