package Routing;

/**
 * Created by Martin.Flekna on 3.2.2017.
 */
public enum Messages {
    ERROR("Error", "Error message"),
    INFO("Info", "Info message"),
    WARNING("Warning", "Warning message");

    private final String code;
    private final String text;

    Messages(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public static Messages getAccountTypeByCode(String code) {
        for (Messages accountType : Messages.values()) {
            if (code.equals(accountType.code)) return accountType;
        }

        throw new IllegalArgumentException(String.format("Code is not in the enum %s", code));
    }

    public static Messages getAccountTypeByText(String text) {
        for (Messages accountType : Messages.values()) {
            if (text.equals(accountType.text)) return accountType;
        }

        throw new IllegalArgumentException(String.format("Text is not in the enum %s", text));
    }

    public String getText() {
        return this.text;
    }

    public String getCode() {
        return this.code;
    }
}
