abstract class Stringed extends Instruments{

    boolean electric;

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    boolean tuned;

    public boolean isTuned() {
        return tuned;
    }

    public void setTuned(boolean tuned) {
        this.tuned = tuned;
    }

}