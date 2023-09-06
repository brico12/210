package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ScoutlistTest {
    Scoutlist sl1;
    Scoutlist sl2;
    Player p1;
    Player p2;
    Player p3;

    @BeforeEach
    void setting() {
        p1 = new Player("Jesse",
                16,
                "PGSS",
                "ST",
                4,
                Player.Foot.RIGHT,
                Player.Status.INMARKET);
        p2 = new Player("Harry",
                17,
                "HAHS",
                "B",
                3,
                Player.Foot.RIGHT,
                Player.Status.SIGNED);
        p3 = new Player("Kevin",
                18,
                "EPSHS",
                "MF",
                5,
                Player.Foot.LEFT,
                Player.Status.INMARKET);

        sl1 = new Scoutlist();
        sl2 = new Scoutlist();

        sl1.addPlayer(p1);
        sl1.addPlayer(p2);
        sl2.addPlayer(p3);
    }
    @Test
    public void addPlayerTest() {
        assertEquals(2 ,sl1.getList().size());
        sl1.addPlayer(p3);
        assertEquals(3, sl1.getList().size());
    }

    @Test
    public void removePlayerTest() {
        assertEquals(2 ,sl1.getList().size());
        sl1.removePlayer(2);
        assertEquals(1, sl1.getList().size());
    }

    @Test
    public void signPlayerTest() {
        sl1.signPlayer(0);
        assertEquals(p1.getStatus(), Player.Status.SIGNED);
    }

    @Test
    public void getListTest() {
        ArrayList<Player> testlist = new ArrayList<>();
        testlist.add(p3);
        assertEquals(testlist, sl2.getList());
    }

}
