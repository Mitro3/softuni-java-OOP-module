package workingWithAbstraction.jediGalaxy;

public class Jedi {
    public long move(int rowJedi, int colJedi, Field field) {
        long starsCollected = 0;

        while (rowJedi >= 0 && colJedi < field.getColLength()) {
            if (field.isInBounds(rowJedi, colJedi)) {
                starsCollected += field.getValue(rowJedi, colJedi);
            }

            colJedi++;
            rowJedi--;
        }

        return starsCollected;
    }
}
