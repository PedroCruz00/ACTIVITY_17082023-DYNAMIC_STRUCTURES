package presenter;

import model.MedicalCenter;
import model.Patient;
import model.SeverityLevel;
import view.View;

public class Presenter {

    private MedicalCenter medicalCenter;
    private View view;



    public Presenter() {
        this.medicalCenter = new MedicalCenter();
        this.view = new View();
        menu();
    }

    private void menu() {
        while (true) {
            view.showMessage("1. Agregar turno");
            view.showMessage("2. Mostrar pacientes en espera");
            view.showMessage("3. Atender paciente ");
            view.showMessage("4. Salir");
            view.showMessage("Seleccione una opción: ");
            int option = view.readInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    view.getConsole().nextLine();
                    String name = view.readString();
                    view.showMessage("\nSeleccione el nivel de gravedad del paciente");
                    SeverityLevel severityLevel = selectSeverityLevel();
                    medicalCenter.addPatient(new Patient(name,severityLevel));
                    view.showMessage("Paciente agregado al a la sala de espera.");
                    break;
                case 2:
                    view.showMessage("Sala de espera:");
                    for (Patient patient : medicalCenter.getPatients()) {
                        view.showMessage( "Nombre: " + patient.getName() + "  ------  Nivel de Gravedad: " + patient.getSeverityLevel() + "\n");
                    }

                    break;
                case 3:
                    Patient patient = medicalCenter.atendPatient();
                    view.showMessage("El paciente atendido fue: " + "Nombre: " + patient.getName() + "  ------  Nivel de Gravedad: " + patient.getSeverityLevel()  );
                    break;
                case 4:
                    view.getConsole().close();
                    System.exit(0);
                default:
                    view.showMessage("Opción no válida.");
            }
        }
    }
    private SeverityLevel selectSeverityLevel(){
        while (true) {
            view.showMessage("1. Alto");
            view.showMessage("2. Medio");
            view.showMessage("3. Bajo");
            view.showMessage("4. Salir");
            int option = view.readInt();

            switch (option) {
                case 1:
                    return SeverityLevel.HIGHT;
                case 2:
                    return  SeverityLevel.MEDIUM;
                case 3:
                    return SeverityLevel.LOW;
                case 4:
                    menu();
                default:
                    view.showMessage("Opción no válida.");

            }
        }
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
