package com.java.laba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileReader {

    private static final String PATH = "src/main/java/com/java/laba/data.bat";
    private static final File FILE = new File(PATH);

    public void clearFile() {
        try {
            FILE.delete();
            FILE.createNewFile();
        } catch (IOException e) {
            System.out.println("File Exeption");
        }
    }

    public List<Person> findAll() throws CustomFileException {
        FileInputStream fileInputStream = null;
        List<Person> userList = new ArrayList<>();
        try {
            if (FILE.length() != 0) {
                fileInputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                PersonsToSerialization persons = (PersonsToSerialization) objectInputStream.readObject();
                userList = persons.getPersonList();
                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new CustomFileException();
        }
        return userList;
    }

    public Person findPersonByName(String name) throws PersonNotFoundedException, CustomFileException {
        for (Person element :findAll()) {
            if (element.getUsername().equals(name)) {
                return element;
            }
        }
        throw new PersonNotFoundedException();
    }

    public void addToFile(Person person) throws CustomFileException {
        FileOutputStream outputStream = null;
        List<Person> usersList = findAll();
        try {

            outputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            usersList.add(person);
            objectOutputStream.writeObject(new PersonsToSerialization(usersList));

            objectOutputStream.close();

        } catch (IOException e) {
            throw new CustomFileException();
        }
    }

    public void deletePerson(Person user) throws CustomFileException {
        List<Person> personList = findAll();
        clearFile();
        for (int i = 0; i < personList.size(); i++) {
            if (Objects.equals(personList.get(i), user)) {
                personList.remove(user);
                break;
            }
        }

        for (Person element: personList) {
            addToFile(element);
        }
    }

    public void updatePerson(String name, Person updatedPerson) throws PersonNotFoundedException, CustomFileException {
        deletePerson(findPersonByName(name));
        addToFile(updatedPerson);
    }
}
