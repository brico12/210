package persistence;

import model.Scoutlist;
import model.Player;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;


// Represents a reader that reads scoutlist from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads scout list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Scoutlist read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseScoutlist(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses scoutlist from JSON object and returns it
    private Scoutlist parseScoutlist(JSONObject jsonObject) {
        Scoutlist sl = new Scoutlist();
        addPlayers(sl, jsonObject);
        return sl;
    }

    // MODIFIES: sl
    // EFFECTS: parses players from JSON object and adds them to the scoutlist
    private void addPlayers(Scoutlist sl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("scoutlist");
        for (Object json : jsonArray) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(sl, nextPlayer);
        }
    }

    // MODIFIES: sl
    // EFFECTS: parses player from JSON object and adds it to scoutlist
    private void addPlayer(Scoutlist sl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        String hometeam = jsonObject.getString("hometeam");
        String position = jsonObject.getString("position");
        int rating = jsonObject.getInt("rating");
        Player.Foot foot = Player.Foot.valueOf(jsonObject.getString("foot"));
        Player.Status status = Player.Status.valueOf(jsonObject.getString("status"));
        Player player = new Player(name, age, hometeam, position, rating, foot, status);
        sl.addPlayer(player);
    }
}


// reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo