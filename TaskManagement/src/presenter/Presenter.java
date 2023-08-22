package presenter;

import model.Task;
import model.User;
import view.View;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Presenter {
    private View view;
    public Presenter() {
        view = new View();
        menu();
    }


    private void menu(){
        LinkedList<Task> tasks = new LinkedList<>();
        Map<Integer, User> users = new HashMap<>();
        int userIdCounter = 1;

        while (true) {
            view.showMessage("1. Añadir usuario");
            view.showMessage("2. añadir tarea");
            view.showMessage("3. Ver tareas asignadas a usuario");
            view.showMessage("4. Salir");
            view.showMessage("ingresa tu opcion: ");
            int choice = view.readInt();
            view.getConsole().nextLine();
            if (choice == 1) {
                view.showMessage("Ingresa uel nombre de usuario: ");
                String userName = view.getConsole().nextLine();
                User user = new User(userIdCounter, userName);
                users.put(userIdCounter, user);
                userIdCounter++;
                view.showMessage("Usuario añadido satisfactoriamente!");
            } else if (choice == 2) {
                view.showMessage("Ingresa la descripcion de la tarea: ");
                String description = view.getConsole().nextLine();
                view.showMessage("Ingresa la fecha de vencimiento: ");
                String dueDate = view.getConsole().nextLine();
                view.showMessage("Usuarios disponibles:");
                for (User user : users.values()) {
                    view.showMessage(user.toString());
                }
                view.showMessage("Ingresa el Id del usuario: ");
                int assignedUserId = view.readInt();
                User assignedUser = users.get(assignedUserId);
                if (assignedUser == null) {
                    view.showMessage("Usuario no encontrado!");
                    continue;
                }
                Task task = new Task(description, dueDate, assignedUser);
                tasks.add(task);
                view.showMessage("tarea añadida satisfactoriamente!");
            } else if (choice == 3) {
                view.showMessage("Ingresa el id del usuario : ");
                int userIdToView = view.readInt();
                User userToView = users.get(userIdToView);
                if (userToView == null) {
                    view.showMessage("Usuario no encontrado!");
                    continue;
                }
                view.showMessage("Tarea asignada a " + userToView.getName() + ":");
                for (Task task : tasks) {
                    if (task.getAssignedTo().getId() == userIdToView) {
                        view.showMessage(task.toString());
                    }
                }
            } else if (choice == 4) {
                view.showMessage("Saliendo...");
                break;
            } else {
                view.showMessage("Opcion Incorrecta...Por favor ingresa otra opcion");
            }
        }
    }
    public static void main(String[] args) {
        new Presenter();
    }
}
