package Model.Impl;

import Model.Animals;
import Model.Commands;
import Model.Pets;

public class Dog extends Animals implements Pets {
    public Dog() {
    }
    public Dog(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.availableCommands.add(Commands.sit);
        this.availableCommands.add(Commands.stay);
        this.availableCommands.add(Commands.place);
        this.availableCommands.add(Commands.down);
    }

}
