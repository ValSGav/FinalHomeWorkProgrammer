package Controller;

import Model.AnimalRegistry;
import Model.Animals;
import Model.Commands;
import Model.Counter;
import Model.Impl.*;
import View.View;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    private View view;

    private AnimalRegistry registry;

    public Controller(View view, AnimalRegistry registry) {
        this.view = view;
        this.registry = registry;
    }

    public void run() {
        Character answer = ' ';
        try (Counter myCounter = new Counter()) {
            do {
                answer = view.showMenu(getMenu(), "Регистр животных: ");
                switch (answer) {
                    case '1' -> {
                        if (runMenuAddAnimals()) {
                            myCounter.add();
                        }
                    }
                    case '2' -> runMenuShowAnimals();
                    case '3' -> System.out.println(myCounter.getCount());
                    case '4' -> view.showMessage("Exit");
                    default -> view.showMessage("Error");
                }
            } while (answer != '4');
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean runMenuAddAnimals() {
        Character answer = ' ';
        boolean retStatus = false;
        do {
            answer = view.showMenu(getMenuAddAnimal(), "Добавление животных в регистр: ");
            switch (answer) {
                case '1' -> {
                    Animals addedAnimal = new Camel();
                    retStatus = addAnimalInRegistry(addedAnimal);
                }
                case '2' -> {
                    Animals addedAnimal = new Horse();
                    retStatus = addAnimalInRegistry(addedAnimal);
                }
                case '3' -> {
                    Animals addedAnimal = new Donkey();
                    retStatus = addAnimalInRegistry(addedAnimal);
                }
                case '4' -> {
                    Animals addedAnimal = new Cat();
                    retStatus = addAnimalInRegistry(addedAnimal);
                }
                case '5' -> {
                    Animals addedAnimal = new Dog();
                    retStatus = addAnimalInRegistry(addedAnimal);
                }
                case '6' -> {
                    Animals addedAnimal = new Hamster();
                    retStatus = addAnimalInRegistry(addedAnimal);
                }
                case '7' -> view.showMessage("Exit");
                default -> view.showMessage("Error");
            }
        } while (answer != '7');

        return retStatus;
    }

    public void runMenuShowAnimals() {

        String answer = "0";
        ArrayList<Animals> allAnimals = registry.getAllAnimals();
        int numbExit = allAnimals.size() + 1;
        do {
            answer = view.showMenuBig(getMenuAllAnimals(), "Выберите животное: ");
            if (!answer.equals(Integer.toString(numbExit))) {
                Animals selectedAnimals = allAnimals.get(Integer.parseInt(answer) - 1);
                runMenuActionWitnAnimals(selectedAnimals);
            }



        } while (!answer.equals(Integer.toString(numbExit)));

    }

    private void runMenuActionWitnAnimals(Animals animal) {
        Character answer = ' ';
        do {
            answer = view.showMenu(getMenuActionWithAnimals(), "Выберите что нужно сделать с " + animal + ":");
            switch (answer) {
                case '1' -> System.out.println(animal.getExecutableCommands());
                case '2' -> {
                    try {
                        animal.addExecutableCommand(GetAvailableCommandForAnimal(animal));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }


                default -> view.showMessage("Error");
            }
        } while (answer != '3');
    }

    private boolean addAnimalInRegistry(Animals addedAnimal) {
        String name = view.getAnswer("Введите имя животного");
        String birthDate = view.getAnswer("Введите дату рождения животного");
        addedAnimal.setName(name);
        addedAnimal.setBirthDate(birthDate);
        registry.AddAnimal(addedAnimal);

        if (name.isEmpty() || birthDate.isEmpty())
            return false;
        else
            return true;
    }



    private Commands GetAvailableCommandForAnimal(Animals animal) {
        Commands retCommand = Commands.stop;

        String answer = "0";
        ArrayList<Commands> allAvailableCommanda = animal.getAvailableCommands();
        int numbExit = allAvailableCommanda.size() + 1;
        do {
            answer = view.showMenuBig(getMenuAllAvailableCommands(allAvailableCommanda), "Добавление новой команды: ");
            if (!answer.equals(Integer.toString(numbExit))) {
                try {
                    animal.addExecutableCommand(allAvailableCommanda.get(Integer.parseInt(answer) - 1));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }


        } while (!answer.equals(Integer.toString(numbExit)));

        return retCommand;
    }

    private HashMap<Character, String> getMenuActionWithAnimals() {
        HashMap<Character, String> menu = new HashMap<>();
        menu.put('1', ". - Show commands");
        menu.put('2', ". - Add commands");
        menu.put('3', ". - Exit");
        return menu;
    }

    private HashMap<String, String> getMenuAllAvailableCommands(ArrayList<Commands> availableCommands) {
        HashMap<String, String> menu = new HashMap<>();

        int menuCounter = 1;

        for (Commands oneCommand : availableCommands
        ) {
            menu.put(String.format("%s", Integer.toString(menuCounter)), ". - " + oneCommand.toString());
            menuCounter++;
        }

        menu.put(String.format("%s", Integer.toString(menuCounter)), ". - Exit");
        return menu;
    }

    private HashMap<String, String> getMenuAllAnimals() {
        HashMap<String, String> menu = new HashMap<>();

        int menuCounter = 1;
        ArrayList<Animals> allAnimals = registry.getAllAnimals();
        for (Animals oneAnimal : allAnimals
        ) {
            menu.put(String.format("%s", Integer.toString(menuCounter)), ". - " + oneAnimal.toString());
            menuCounter++;
        }

        menu.put(String.format("%s", Integer.toString(menuCounter)), ". - Exit");
        return menu;
    }

    private HashMap<Character, String> getMenu() {
        HashMap<Character, String> menu = new HashMap<>();
        menu.put('1', ". - Add animal");
        menu.put('2', ". - Show all animal");
        menu.put('3', ". - Show count of added animals");
        menu.put('4', ". - Exit");
        return menu;
    }

    private HashMap<Character, String> getMenuAddAnimal() {
        HashMap<Character, String> menu = new HashMap<>();
        menu.put('1', ". - Add camel");
        menu.put('2', ". - Add horse");
        menu.put('3', ". - Add donkey");
        menu.put('4', ". - Add cat");
        menu.put('5', ". - Add gog");
        menu.put('6', ". - Add hamster");
        menu.put('7', ". - Go back");
        return menu;
    }
}
