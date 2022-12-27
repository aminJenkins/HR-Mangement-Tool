package com.hsaugsburg.HRManagementTool.models;

public enum Priority {
    HIGH("high"),
    MIDDLE("middle"),
    LOW("low");
    public String label;

    private Priority(String label) {
        this.label = label;
    }
}
