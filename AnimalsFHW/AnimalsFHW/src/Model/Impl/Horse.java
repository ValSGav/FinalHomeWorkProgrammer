package Model.Impl;

import Model.Animals;
import Model.Commands;
import Model.PackAnimals;

import java.util.ArrayList;

public class Horse extends Animals implements PackAnimals {
    public Horse() {
        this("", "");
    }

    public Horse(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.availableCommands = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.availableCommands.add(Commands.gallop);
        this.availableCommands.add(Commands.stop);
        this.availableCommands.add(Commands.jump);
        this.availableCommands.add(Commands.walk);

        this.commands.add(Commands.walk);
        this.commands.add(Commands.stop);

    }

    @Override
    public String toString() {
        return "Horse " + super.toString();
    }



}
