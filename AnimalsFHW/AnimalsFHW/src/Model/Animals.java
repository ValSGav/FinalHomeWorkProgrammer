package Model;

import java.util.ArrayList;

public class Animals {
    protected String name;
    protected String birthDate;
    protected ArrayList<Commands> commands;
    protected ArrayList<Commands> availableCommands;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "name: " + name +
                ", birthDate: " + birthDate;
    }

    public String getName() {
        return name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void addExecutableCommand(Commands command) throws Exception {
        boolean successfully = false;
        if (this.availableCommands.contains(command)) {
            successfully = true;
            this.commands.add(command);
        } else {
            throw new Exception("Животное не может выполнять такую команду!");
        }
    }

    public ArrayList<Commands> getExecutableCommands() {
        ArrayList<Commands> retArray = new ArrayList<Commands>();
        retArray.addAll(this.commands);
        return retArray;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public ArrayList<Commands> getAvailableCommands() {
        return this.availableCommands;
    }
}
