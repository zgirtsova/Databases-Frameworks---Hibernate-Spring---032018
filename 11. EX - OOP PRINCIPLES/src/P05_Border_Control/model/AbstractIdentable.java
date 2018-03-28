package P05_Border_Control.model;

import P05_Border_Control.contracts.Identable;

public class AbstractIdentable implements Identable {

    private final String id;

    public AbstractIdentable(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
