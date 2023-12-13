import Controller.Controller;
import Model.AnimalRegistry;
import View.View;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        View view = new View();
        AnimalRegistry registry = new AnimalRegistry();
        Controller controller = new Controller(view, registry);
        controller.run();

    }
}