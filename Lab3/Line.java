package thrainn.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {
    private double x2, y2;

    public Line(double x, double y, double x2, double y2, Color color) {
        super(x, y, color);
        this.x2 = x2;
        this.y2 = y2;
    }

    public Line() {
        super();
        this.x2 = 100;
        this.y2 = 100;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeLine(getX(), getY(), x2, y2);
    }

    @Override
    public void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
        x2 += getDx() * elapsedTimeNs / BILLION;
        y2 += getDy() * elapsedTimeNs / BILLION;

    }


    @Override
    public void constrain(double boxX, double boxY, double boxWith, double boxHight) {
        //double x = getX();
        //double y = getY();
        super.constrain(boxX, boxY, boxWith, boxHight);
        double dx = getDx();
        double dy = getDy();

        if (x2 < boxX) {
            dx = Math.abs(dx);
        } else if (x2 > boxWith) {
            dx = -Math.abs(dx);
        }
        if (y2 < boxY) {
            dy = Math.abs(dy);
        } else if (y2 > boxHight) {
            dy = -Math.abs(dy);
        }
        setVelocity(dx, dy);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", x2=" + x2 +
                ", y2=" + y2;
    }
}
