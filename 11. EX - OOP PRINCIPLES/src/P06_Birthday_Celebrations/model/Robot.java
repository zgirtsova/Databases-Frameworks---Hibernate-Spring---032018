package P06_Birthday_Celebrations.model;

public class Robot extends AbstractIdentable {

    private final String model;

    public Robot(String id, String model) {
        super(id);
        this.model = model;
    }
}
