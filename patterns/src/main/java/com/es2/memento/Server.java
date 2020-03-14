package com.es2.memento;

import java.util.ArrayList;

public class Server {
    // Attributes
    private ArrayList<String> studentNames = new ArrayList<String>();

    // Methods
    public void addStudent(String studentName) throws ExistingStudentException {
        if (studentNames.contains(studentName) == true) {
            throw new ExistingStudentException();
        }
        studentNames.add(studentName);
    }

    public Memento backup() {
        return new Memento(studentNames);
    }

    public void restore(Memento memento) {
        studentNames = memento.getState();
    }

    // Getters & Setters
    public ArrayList<String> getStudentNames() {
        return studentNames;
    }
}