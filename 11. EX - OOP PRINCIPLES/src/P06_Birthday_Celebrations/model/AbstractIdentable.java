package P06_Birthday_Celebrations.model;

import P06_Birthday_Celebrations.contracts.Identable;

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
