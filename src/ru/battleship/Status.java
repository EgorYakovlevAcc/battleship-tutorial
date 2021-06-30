package ru.battleship;

public enum  Status {
    FREE(" "),
    MISS("*"),
    HIT("#"),
    SHIP("1");

    private String picture;

    Status(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }
}
