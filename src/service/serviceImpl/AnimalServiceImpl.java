package service.serviceImpl;

import model.Animal;
import model.Person;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnimalServiceImpl implements GenericService<Animal> {
    int num;
    Scanner scanner=new Scanner(System.in);
    private List<Animal>animals=new ArrayList<>();
    @Override
    public String add(List<Animal> t) {
        animals.addAll(t);
        return "animal successfully saved";
    }
    @Override
    public Animal getById(Long id) {
        for (int i = 0; i < animals.size(); i++) {
            if(id==animals.get(i).getId()){
                System.out.println(animals.get(i));
            }
        }
        return null;
    }
    @Override
    public List<Animal> getAll() {
        return animals;
    }

    @Override
    public List<Animal> sortByName() {
        System.out.println("""
                    choose 1-by ascending
                    choose 2-by descending""");
        switch (num = scanner.nextInt()) {
            case 1:
                animals.sort(byNameAscending);
                for (int i = 0; i < animals.size(); i++) {
                    System.out.println(animals.get(i).getName());
                }
                break;
            case 2:
                animals.sort(byNameDescending);
                for (int i = 0; i < animals.size(); i++) {
                    System.out.println(animals.get(i).getName());
                }
                break;

        }
        return null;
    }
    public Comparator<Animal>byNameAscending=new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public Comparator<Animal>byNameDescending=new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    @Override
    public List<Animal> filterByGender() {
//        System.out.println("Введите gender для фильтрации");
//        String gender = scanner.nextLine();
//        System.out.println("Students with inputed genders are:");
//        for (int i = 0; i < animals.size(); i++) {
//            if (gender.equalsIgnoreCase(animals.get(i).getGender().name())) {
//                System.out.println(animals.get(i));
//            }
//        }
        return null;
    }
    @Override
    public List<Animal> clear() {
        animals.clear();
        return animals;
    }
}
