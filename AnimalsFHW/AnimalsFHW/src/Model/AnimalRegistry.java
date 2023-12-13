package Model;

import java.util.ArrayList;

public class AnimalRegistry {

    private ArrayList<Animals> Regestry;
    public AnimalRegistry() {
        Regestry = new ArrayList<Animals>();
    }

    public boolean AddAnimal(Animals animal){
        boolean successfully = false;

        if(!animal.name.isEmpty()&&!animal.birthDate.isEmpty()){
            successfully = true;
        }

        Regestry.add(animal);

        return  successfully;
    }

    public ArrayList<Animals> getAllAnimals(){
        ArrayList<Animals> retArray = new ArrayList<Animals>();
        retArray.addAll(Regestry);
        return  retArray;
    }

}
