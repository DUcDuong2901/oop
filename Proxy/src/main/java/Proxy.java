import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

interface Graphic {
    void draw(Point position);
    Dimension getExtent();
    Point getPosition();
    void handleMouse(MouseEvent mouseEvent);
    void store();
    void load();
}
class Picture implements Graphic {
    private Point position;
    private Dimension extent;

    public Picture() {

    }

    public void draw(Point position) {

        this.position = position;
    }

    public Dimension getExtent() {
        return extent;
    }

    public Point getPosition() {
        return position;
    }

    public void handleMouse(MouseEvent mouseEvent) {

    }

    public void store() {

    }

    public void load() {

    }
}
class PictureProxy implements Graphic {
    private String fileName;
    private Dimension extent;
    private Point position;
    private Picture picture;

    public PictureProxy(String fileName) {
        this.fileName = fileName;
    }

    protected Picture getPicture() {
        if (picture == null) {
            picture = new Picture();
        }
        return picture;
    }

    public void draw(Point position) {
        getPicture().draw(position);
        this.position = position;
    }

    public Dimension getExtent() {
        if (picture != null) {
            return picture.getExtent();
        } else {
            return new Dimension(0, 0);
        }
    }

    public Point getPosition() {
        if (picture != null) {
            return picture.getPosition();
        } else {
            return new Point(0, 0);
        }
    }

    public void handleMouse(MouseEvent mouseEvent) {
        if (picture != null) {
            picture.handleMouse(mouseEvent);
        }
    }

    public void store() {
        if (picture != null) {
            picture.store();
        }
    }

    public void load() {
        if (picture != null) {
            picture.load();
        }
    }
}
class Client {

}