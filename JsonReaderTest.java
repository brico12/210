package persistence;

import model.Scoutlist;
import model.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Scoutlist sl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyScoutlist() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyScoutlist.json");
        try {
            Scoutlist sl = reader.read();
            assertEquals(0, sl.numScoutlist());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralScoutlist() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralScoutlist.json");
        try {
            Scoutlist sl = reader.read();
            ArrayList<Player> scoutlist= sl.getList();
            assertEquals(2, scoutlist.size());
            checkPlayer("Roy", scoutlist.get(0));
            checkPlayer("Terry", scoutlist.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}


// reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

