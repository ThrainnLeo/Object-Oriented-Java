package thrainn.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape {

    private double diameter;

    public Circle(int diameter, boolean state) {
        super(state);
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        if (diameter < 0) {
            diameter = 0;
        }
        this.diameter = diameter;
    }

    @Override
    public void paint(GraphicsContext gc) {

        // Fyll endast när isFilled är true
        if (isFilled) {
            gc.setFill(Color.BLUE);
            gc.fillOval(getX(), getY(), diameter, diameter);
        }

        // Rita konturen alltid (efter fill så kanten syns ovanpå)
        gc.setStroke(Color.BLACK);
        gc.strokeOval(getX(), getY(), diameter, diameter);
    }

    @Override
    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        double x = getX();
        double y = getY();
        double dx = getDx();
        double dy = getDy();

        boolean bounced = false;

        if (x < boxX) {
            dx = Math.abs(dx);
            bounced = true;
        } else if (x + diameter > boxX + boxWidth) {
            dx = -Math.abs(dx);
            bounced = true;
        }

        if (y < boxY) {
            dy = Math.abs(dy);
            bounced = true;
        } else if (y + diameter > boxY + boxHeight) {
            dy = -Math.abs(dy);
            bounced = true;
        }

        setX(x);
        setY(y);
        setVelocity(dx, dy);

        if (bounced) {
            if (isFilled()) {
                setFilled(false);
            } else setFilled(true);
        }
    }


    @Override
    public String toString() {
        String info = "Circle: " + super.toString();
        info += ", diameter = " + diameter;
        return info;
    }
}