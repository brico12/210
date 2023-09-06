package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player p1;
    Player pnew;


    @BeforeEach
    void setting() {
        p1 = new Player("Jesse",
                16,
                "PGSS",
                "ST",
                4,
                Player.Foot.RIGHT,
                Player.Status.INMARKET);
    }

    @Test
    void testEditRating(){
        pnew = p1.editRating(3);
        assertEquals(3, pnew.getRating());
    }

    @Test
    void testEditAge(){
        pnew = p1.editAge(17);
        assertEquals(17, pnew.getAge());
    }

    @Test
    void testEditStatus(){
        pnew = p1.editStatus(Player.Status.SIGNED);
        assertEquals(Player.Status.SIGNED, pnew.getStatus());
    }

    @Test
    void testToString(){
        assertEquals("Jesse,16,PGSS,ST,4,RIGHT,INMARKET",p1.toString());
    }

    @Test
    void testGetHometeam(){
        assertEquals("PGSS",p1.getHometeam());
    }

    @Test
    void testGetFoot(){
        assertEquals(Player.Foot.RIGHT,p1.getFoot());
    }

    @Test
    void testGetStatus(){
        assertEquals(Player.Status.INMARKET,p1.getStatus());
    }
}

