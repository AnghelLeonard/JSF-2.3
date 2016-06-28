package javaee8.jsf23;

/**
 *
 * @author Anghel Leonard
 */
public enum PlayerEnum {

    FIRST, SECOND, THIRD;

    public Integer getRank() {
        switch (name()) {
            case "FIRST":
                return 1;
            case "SECOND":
                return 2;
            case "THIRD":
                return 3;
            default:
                return 0;
        }
    }
}
