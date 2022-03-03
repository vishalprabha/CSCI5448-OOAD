public abstract class Staff {
    String name;
    boolean isSick;

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
