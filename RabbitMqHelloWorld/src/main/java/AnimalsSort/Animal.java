package AnimalsSort;

/**
 * Created by Martin.Flekna on 3.2.2017.
 */
public enum Animal {
    RABBIT("Rabbit"),
    FOX("Fox"),
    CAT("Cat"),
    DOG("Dog"),
    PIGEON("Pigeon"),
    ELEPHANT("Elephant");


    private final String text;

    Animal(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
