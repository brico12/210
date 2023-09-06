package ui;

import model.Scoutlist;
import model.Player;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


// Represents the Scout application
public class ScoutApp {
    private static final String JSON_STORE = "./data/scoutlist.json";
    private static Scanner input;
    private static Scoutlist read;
    private static JsonWriter jsonWriter;
    private static JsonReader jsonReader;

    public ScoutApp() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        read = new Scoutlist();
        new GUI();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runScoutlist() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }


    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add player");
        System.out.println("\tb -> print list");
        System.out.println("\tc -> save this list to file");
        System.out.println("\td -> load the list from file");
        System.out.println("\te -> sign a player");
        System.out.println("\tf -> remove a player from the list");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            inputPlayerinfo();
        } else if (command.equals("b")) {
            printlist();
        } else if (command.equals("c")) {
            saveList();
        } else if (command.equals("d")) {
            loadList();
        } else if (command.equals("e")) {
            signPlayer();
        } else if (command.equals("f")) {
            removeThisPlayer();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //EFFECT: to put information into the player class
    private void inputPlayerinfo() {
        System.out.println("player name:");
        String name = input.next();
        System.out.println("player age:");
        int age = Integer.parseInt(input.next());
        System.out.println("player hometeam:");
        String hometeam = input.next();
        System.out.println("player position:");
        String position = input.next();
        System.out.println("player rating:");
        int rating = Integer.parseInt(input.next());
        System.out.println("player foot:");
        Player.Foot foot = Player.Foot.valueOf(input.next());
        System.out.println("player status:");
        Player.Status status = Player.Status.valueOf(input.next());

        read.addPlayer(new Player(name, age, hometeam, position, rating, foot, status));
    }

    // EFFECT: to sign a player
    private void signPlayer() {
        printlist();
        System.out.println("which player to sign?");
        int index = input.nextInt();
        input.nextLine();
        read.signPlayer(index);
        Player p;
        p = read.getPlayers().get(index);
        String pname;
        pname = p.getName();
        System.out.println(pname + " has been signed successfully");
    }

    //EFFECT: to print a list
    private void printlist() {
        for (Player p : read.getList()) {
            System.out.println(p.getName());
        }
    }

    // EFFECTS: saves the scoutlist to file
    public static void saveList() {
        try {
            jsonWriter.open();
            jsonWriter.write(read);
            jsonWriter.close();
            System.out.println("Saved");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file");
        }
    }

    // EFFECT: to remove a player from scoutlist.
    static void removeThisPlayer() {
        System.out.println("which player to remove?");
        int index = input.nextInt();
        input.nextLine();
        read.signPlayer(index);
        Player p;
        p = read.getPlayers().get(index);
        String pname;
        pname = p.getName();
        System.out.println(pname + " has been removed successfully");
    }


    // MODIFIES: this
    // EFFECTS: loads scoutlist from file
    public static void loadList() {
        try {
            read =  jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file");
        }
    }

    public static Scoutlist getList() {
        return read;
    }

    public static void addPlayer(Player player) {
        read.addPlayer(player);
    }

    public static void addPlayer() {
        new AddPlayerGUI(new ScoutlistGUI(read));
    }

    public static void removePlayer(int index) {
        read.removePlayer(index);
    }

    public static void removePlayer() {
        new RemovePlayerGUI(new ScoutlistGUI(read));
    }


    public static void printList() {
        new ScoutlistGUI(read);
    }
}

// reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
