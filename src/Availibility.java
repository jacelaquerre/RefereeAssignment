public class Availibility {

    private boolean satAvail;
    private boolean sunAvail;

    public Availibility() {
        satAvail = false;
        sunAvail = false;
    }
    public Availibility(boolean satAvail, boolean sunAvail) {
        this.satAvail = satAvail;
        this.sunAvail = sunAvail;
    }

    public boolean isSatAvail() {
        return satAvail;
    }

    public void setSatAvail(boolean satAvail) {
        this.satAvail = satAvail;
    }

    public boolean isSunAvail() {
        return sunAvail;
    }

    public void setSunAvail(boolean sunAvail) {
        this.sunAvail = sunAvail;
    }

    @Override
    public String toString() {
        return "Availibility{" +
                "satAvail=" + satAvail +
                ", sunAvail=" + sunAvail +
                '}';
    }
}
