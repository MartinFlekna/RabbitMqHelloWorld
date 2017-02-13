package AnimalsSort;

/**
 * Created by Martin.Flekna on 3.2.2017.
 */
public enum Speed {
    FAST("Fast"),
    SLOW("Slow");

    private final String text;

    Speed(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
