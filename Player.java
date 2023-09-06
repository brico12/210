package model;

import org.json.JSONObject;
import persistence.Writable;

public class Player implements Writable {

    public enum Status { SIGNED, INMARKET }

    public enum Foot { LEFT, RIGHT }

    private String name;
    private int age;
    private String hometeam;
    private String position;
    private int rating;
    private Foot foot;
    private Status status;


    // REQUIRES: foot is either "left" or "right". rating is a integer between 1-5. Position is one of ST, MF, B, GK.
    // EFFECTS: constructs a player with all the basic information.
    public Player(String name, int age, String hometeam, String position, int rating, Foot foot, Status status) {
        this.name = name;
        this.age = age;
        this.hometeam = hometeam;
        this.position = position;
        this.rating = rating;
        this.foot = foot;
        this.status = status;
    }

    // REQUIRES: the int is an integer between 1-5.
    // MODIFIES: this
    // EFFECT: update the rating of the player
    public Player editRating(int newrating) {
        this.rating = newrating;
        return this;
    }


    // MODIFIES: this
    // EFFECT: update the status of the player
    public Player editStatus(Status newstatus) {
        this.status = newstatus;
        return this;
    }

    // MODIFIES: this
    // EFFECT: update the age of the player.
    public Player editAge(int newage) {
        this.age = newage;
        return this;
    }

    // EFFECTS: returns the player's age
    public int getAge() {
        return this.age;
    }

    // EFFECTS: returns the player's rating
    public int getRating() {
        return this.rating;
    }

    public String getHometeam() {
        return this.hometeam;
    }

    public Foot getFoot() {
        return this.foot;
    }

    public String getPosition() {
        return this.position;
    }

    // EFFECTS: returns the player's status.
    public Status getStatus() {
        return this.status;
    }

    // EFFECTS: returns the player's name.
    public String getName() {
        return this.name;
    }

    // EFFECTS: returns string representation of this Player
    public String toString() {
        return  name + "," + age + "," + hometeam + "," + position + "," + rating + "," + foot + "," + status;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("age", age);
        json.put("hometeam", hometeam);
        json.put("position", position);
        json.put("rating", rating);
        json.put("foot", foot);
        json.put("status", status);
        return json;
    }
}
// reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

