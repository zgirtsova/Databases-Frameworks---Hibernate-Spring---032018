package app.model.enums;

public enum Size {
    SMALL(0), MEDIUM(1), LARGE(2);

    private long value;
    private Size(int i){value = i;}
    public long getValue() { return value; }
}
