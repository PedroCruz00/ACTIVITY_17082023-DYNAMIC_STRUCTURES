package model;

public class Task {
    String description;
    String dueDate;
    User assignedTo;

    public Task(String description, String dueDate, User assignedTo) {
        this.description = description;
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    @Override
    public String toString() {
        return "Descripcion: " + description + ", Fecha de Vencimiento: " + dueDate + ", Asignada a: " + assignedTo.getName();
    }
}



