package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.*;


public class Scoutlist implements Writable {
    private ArrayList<Player> scoutlist;

    public Scoutlist() {
        this.scoutlist = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: add new player to the scout list.
    public void addPlayer(Player player) {
        Event event = new Event("The player has been added successfully");
        EventLog.getInstance().logEvent(event);
        scoutlist.add(player);
    }

    //REQUIRES: the scoutlist is not empty
    //MODIFIES: this
    //EFFECTS: delete selected player from my scoutlist
    public void removePlayer(int index) {
        Event event = new Event("The player has been removed successfully");
        EventLog.getInstance().logEvent(event);
        this.scoutlist.remove(index - 1);
    }

    //REQUIRES: the scoutlist is not empty, the 0 <= index < scout list size, the player status is INMARKET.
    //MODIFIES: this
    //EFFECTS: change the status of selected player to signed
    public void signPlayer(int index) {
        Player player = scoutlist.get(index);
        player.editStatus(Player.Status.SIGNED);
    }


    //EFFECTS: return my scout list
    public ArrayList<Player> getList() {
        return scoutlist;
    }



    // EFFECTS: returns a unmidifiable scout list.
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(scoutlist);
    }


    // EFFECTS: returns number of players in this scout list.
    public int numScoutlist() {
        return scoutlist.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("scoutlist", playersToJson());
        return json;
    }

        // EFFECTS: returns things in this scout list as a JSON array
    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player p : scoutlist) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }


    public static void printLog() {
        Iterator iterator = EventLog.getInstance().iterator();

        while (iterator.hasNext()) {
            Event event = (Event)iterator.next();
            System.out.println(event.toString());
        }
    }

}
// reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo