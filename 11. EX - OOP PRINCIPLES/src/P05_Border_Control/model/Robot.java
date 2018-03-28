package P05_Border_Control.model;

public class Robot extends AbstractIdentable {
    private final String model;

    public Robot(String id, String model) {
        super(id);
        this.model = model;
    }
}
