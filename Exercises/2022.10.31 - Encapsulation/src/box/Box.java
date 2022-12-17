package box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if(isValidInput(length)) {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if(isValidInput(width)) {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if(isValidInput(height)) {
            this.height = height;
        }
    }

    public double calculateSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (length * height + width * height);
    }

    public double calculateVolume() {
        return width * height * length;
    }

    private boolean isValidInput(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number cannot be zero or negative.");
        }
        return true;
    }
}
