package service.serviceImpl;

import model.Person;
import service.GenericService;

import java.util.*;

public class PersonServiceImpl implements GenericService<Person> {
    private ArrayList<Person>people=new ArrayList<>();

    Scanner scanner=new Scanner(System.in);
    int num;
    @Override
    public String add(List<Person> t) {
        people.addAll(t);
        return "successfully added";
    }

    @Override
    public Person getById(Long id) {
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getId()==id){
                System.out.println(people.get(i));
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return people;
    }

    @Override
    public List<Person> sortByName() {
            System.out.println("""
                    choose 1-by ascending
                    choose 2-by descending""");
            switch (num = scanner.nextInt()) {
                case 1:
                    people.sort(byNameAscending);
                    for (int i = 0; i < people.size(); i++) {
                        System.out.println(people.get(i).getName());
                    }
                    break;
                case 2:
                    people.sort(byNameDescending);
                    for (int i = 0; i < people.size(); i++) {
                        System.out.println(people.get(i).getName());
                    }
                    break;

            }

//        System.out.println("All people just for information");
            return null;
    }

    public Comparator<Person>byNameAscending=new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public Comparator<Person>byNameDescending=new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    @Override
    public List<Person> filterByGender() {
        System.out.println("Введите gender для фильтрации");
        String gender = scanner.nextLine();
        System.out.println("Students with inputed genders are:");
        for (int i = 0; i < people.size(); i++) {
            if (gender.equalsIgnoreCase(people.get(i).getGender().name())) {
                System.out.println(people.get(i));
            }
        }
        return null;
    }

    @Override
    public List<Person> clear() {
        people.clear();
        return people;
    }
}
