package Model.Impl;

import Model.Animals;
import Model.Commands;
import Model.PackAnimals;

import java.util.ArrayList;

public class Camel extends Animals implements PackAnimals {
    public Camel() {
        this("", "");
    }

    @Override
    public String toString() {
        return "Camel " + super.toString();
    }

    public Camel(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.availableCommands = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.availableCommands.add(Commands.up);
        this.availableCommands.add(Commands.down);
        this.availableCommands.add(Commands.walk);
        this.availableCommands.add(Commands.stop);

        this.commands.add(Commands.walk);
        this.commands.add(Commands.stop);
    }
}
