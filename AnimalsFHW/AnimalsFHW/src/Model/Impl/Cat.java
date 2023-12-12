package Model.Impl;

import Model.Animals;
import Model.Commands;
import Model.Pets;

public class Cat extends Animals implements Pets {

    public Cat() {
        this("", "");
    }

    public Cat(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.availableCommands.add(Commands.jump);
        this.availableCommands.add(Commands.roll);
        this.availableCommands.add(Commands.sayMeow);

    }
}
