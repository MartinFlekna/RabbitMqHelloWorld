package AnimalsSort;

/**
 * Created by Martin.Flekna on 3.2.2017.
 */
public enum Color {
    ORANGE("Orange"),
    GREEN("Green"),
    RED("Red"),
    BLUE("Blue");

    private final String text;

    Color(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
