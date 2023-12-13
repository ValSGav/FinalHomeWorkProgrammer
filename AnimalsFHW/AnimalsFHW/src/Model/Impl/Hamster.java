package Model.Impl;

import Model.Animals;
import Model.Commands;
import Model.Pets;

import java.util.ArrayList;

public class Hamster extends Animals implements Pets {
    public Hamster() {
        this("", "");
    }
    public Hamster(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.availableCommands = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.availableCommands.add(Commands.roll);
        this.availableCommands.add(Commands.spin);

        this.commands.add(Commands.spin);
    }

    @Override
    public String toString() {
        return "Hamster " + super.toString();
    }

}
