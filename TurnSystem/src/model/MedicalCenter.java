package model;

import java.util.PriorityQueue;

public class MedicalCenter {
    private PriorityQueue<Patient> patients;

    public MedicalCenter() {
        this.patients = new PriorityQueue<>();
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }
    public Patient atendPatient(){
        return patients.poll();
    }

    public PriorityQueue<Patient> getPatients() {
        return patients;
    }
}
