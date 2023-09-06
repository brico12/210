package persistence;

import model.Player;
import model.Scoutlist;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Scoutlist sl = new Scoutlist();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyScoutlist() {
        try {
            Scoutlist sl = new Scoutlist();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyScoutlist.json");
            writer.open();
            writer.write(sl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyScoutlist.json");
            sl = reader.read();
            assertEquals(0, sl.numScoutlist());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralScoutlist() {
        try {
            Scoutlist sl = new Scoutlist();
            sl.addPlayer(new Player("Roy" ,
                    16,
                    "PGSS",
                    "ST",
                    2,
                    Player.Foot.LEFT,
                    Player.Status.INMARKET));
            sl.addPlayer(new Player("Terry" ,
                    16,
                    "MDSS",
                    "GK",
                    3,
                    Player.Foot.RIGHT,
                    Player.Status.SIGNED));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralScoutlist.json");
            writer.open();
            writer.write(sl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralScoutlist.json");
            sl = reader.read();
            List<Player> scoutlist = sl.getPlayers();
            assertEquals(2, scoutlist.size());
            checkPlayer("Roy", scoutlist.get(0));
            checkPlayer("Terry", scoutlist.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}


// reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
