package thrainn.Shapes;

public abstract class FillableShape extends Shape {

    boolean isFilled;

    public FillableShape(boolean isFilled) {
        this.isFilled = isFilled;
    }


    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}
