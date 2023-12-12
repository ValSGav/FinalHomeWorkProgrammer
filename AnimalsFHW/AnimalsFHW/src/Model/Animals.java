package Model;

import java.util.ArrayList;

public class Animals {
    protected String name;
    protected String birthDate;
    protected ArrayList<Commands> commands;
    protected ArrayList<Commands> availableCommands;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean addCommand(Commands command) {
        if (this.availableCommands.contains(command)){
          this.commands.add(command);
          return true;
        };
        return false;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public ArrayList<Commands> getAvailableCommands() {
        return this.availableCommands;
    }
}
