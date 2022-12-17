package catHouse;

import catHouse.core.Engine;
import catHouse.core.EngineImpl;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.ShorthairCat;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();

    }
}
