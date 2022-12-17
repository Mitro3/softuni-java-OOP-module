package workingWithAbstraction.jediGalaxy;

public class Galaxy {
    private Field field;
    private Jedi jedi;
    private EvilPower evilPower;

    public Galaxy(Field field) {
        this.field = field;
        jedi = new Jedi();
        evilPower = new EvilPower();
    }

    public long moveJedi(int rowJedi, int colJedi){
        return jedi.move(rowJedi, colJedi, field);
    }

    public void moveEvil(int rowEvil, int colEvil) {
        evilPower.move(rowEvil, colEvil, field);
    }
}
