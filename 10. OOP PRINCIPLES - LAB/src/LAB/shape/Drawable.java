package LAB.shape;

public interface Drawable {
    public abstract void draw();

    public default void msg() {
        System.out.println("Default void: ");
    }
}
