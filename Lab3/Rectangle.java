package thrainn.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Rectangle extends FillableShape {

    private double length;

    public Rectangle(int length, boolean state) {
        super(state);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 0) {
            length = 0;
        }
        this.length = length;
    }

    @Override
    public void paint(GraphicsContext gc) {
        //gc.strokeRect(getX(),getY(),length, length );

        // Fyll endast när isFilled är true
        if (isFilled) {
            gc.setFill(Color.RED);
            gc.fillRect(getX(),getY(),length, length );
        }

        // Rita konturen alltid (efter fill så kanten syns ovanpå)
        gc.setStroke(Color.BLACK);
        gc.strokeRect(getX(),getY(),length, length );
    }

    @Override
    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        double x  = getX();
        double y  = getY();
        double dx = getDx();
        double dy = getDy();

        boolean bounced = false;

        if (x < boxX) {
            dx = Math.abs(dx);
            bounced = true;
        } else if (x + length > boxX + boxWidth) {
            dx = -Math.abs(dx);
            bounced = true;
        }

        if (y < boxY) {
            dy = Math.abs(dy);
            bounced = true;
        } else if (y + length > boxY + boxHeight) {
            dy = -Math.abs(dy);
            bounced = true;
        }

        setX(x);
        setY(y);
        setVelocity(dx, dy);

        if (bounced) {
            if (isFilled()) {
                setFilled(false);
            } else setFilled(true);        }
    }


    @Override
    public String toString() {
        String info = "Circle: " + super.toString();
        info += ", length = " + length;
        return info;
    }
}
