package Model.Impl;

import Model.Animals;
import Model.Commands;
import Model.Pets;

import java.util.ArrayList;

public class Cat extends Animals implements Pets {

    public Cat() {
        this("", "");
    }

    public Cat(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.availableCommands = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.availableCommands.add(Commands.jump);
        this.availableCommands.add(Commands.roll);
        this.availableCommands.add(Commands.sayMeow);

        this.commands.add(Commands.jump);

    }

    @Override
    public String toString() {
        return "Cat " + super.toString();
    }
}
