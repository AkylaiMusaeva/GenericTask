package enums;

public enum Gender {
    FEMALE("FEMALE"),
    MALE("MALE");
    final String  diff;

    Gender(String diff) {
        this.diff = diff;
    }
}
