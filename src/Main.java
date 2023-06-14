import enums.Gender;
import model.Animal;
import model.Person;
import service.serviceImpl.AnimalServiceImpl;
import service.serviceImpl.PersonServiceImpl;

import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        Person person1 = new Person(1L, "Akylai", 12, Gender.FEMALE);
        Person person2 = new Person(2L, "Tahir", 21, Gender.MALE);
        Person person3 = new Person(3L, "Madlen", 23, Gender.FEMALE);
        Person person4 = new Person(4L, "Aika", 46, Gender.FEMALE);
        Person person5 = new Person(5L, "Tereza", 18, Gender.FEMALE);
        Person person6 = new Person(6L, "Nikolai", 23, Gender.MALE);
        PersonServiceImpl personService = new PersonServiceImpl();

        Animal animal1 = new Animal(1L, "Hank", 2, Gender.FEMALE);
        Animal animal2 = new Animal(2L, "Tai", 4, Gender.MALE);
        Animal animal3 = new Animal(3L, "Reks", 2, Gender.MALE);
        Animal animal4 = new Animal(4L, "Kitty", 6, Gender.MALE);
        Animal animal5 = new Animal(5L, "Mops", 12, Gender.FEMALE);
        Animal animal6 = new Animal(6L, "Love", 1, Gender.FEMALE);
        AnimalServiceImpl animalService = new AnimalServiceImpl();
        while (true) {
            System.out.println("""
                    Choose operation:
                    1-add
                    2-get by id
                    3-get all
                    4-sort by name
                    5-filter by gender
                    6-clear all""");
            switch (num = scanner.nextInt()) {
                case 1:
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Add new person and animal");
                    System.out.println(personService.add(List.of(person1, person2, person3, person4, person5, person6)));
                    animalService.add(List.of(animal1, animal2, animal3, animal4, animal5, animal6));
                    break;
                case 2:
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Get by id person and animal");
                    System.out.println(personService.getById(1L));
                    System.out.println(animalService.getById(1L));
                    break;
                case 3:
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Get all people and animals");
                    System.out.println(personService.getAll());
                    System.out.println(animalService.getAll());
                    break;
                case 4:
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Sort by name");
                    System.out.println(personService.sortByName());
                    System.out.println(animalService.sortByName());
                    break;
                case 5:
                    System.out.println("Filter by gender");
                    System.out.println(personService.filterByGender());
//                    System.out.println(animalService.filterByGender());
                    break;
                case 6:
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Clear all");
                    System.out.println(personService.clear());
                    System.out.println(animalService.clear());
                    break;
            }
        }
    }
}
