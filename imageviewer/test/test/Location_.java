package test;

import imageviewer.Location;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class Location_ {
    private Case c;
   
    public Location_(Case c) {
        this.c = c;
    }    
    
    @Test
    public void test() {
        Location location = new Location(c.imagew,c.imageh).update(c.panelw, c.panelh);
        assertEquals(c.x, location.x());
        assertEquals(c.y, location.y());
        assertEquals(c.w, location.width());
        assertEquals(c.h, location.height());
    }
     
    
    @Parameters
    public static List<Case> cases() {
        List<Case> result = new ArrayList<>();
        result.add(new Case(200,200,400,400,100,100,200,200));
        result.add(new Case(300,200,400,400,50,100,300,200));
        result.add(new Case(200,300,400,400,100,50,200,300));
        result.add(new Case(200,200,100,100,0,0,100,100));
        result.add(new Case(200,200,200,100,50,0,100,100));
        result.add(new Case(200,200,100,200,0,50,100,100));
        result.add(new Case(800,400,800,50,350,0,100,50));
        return result;
    }
    
    public static class Case {
        int imagew;
        int imageh;
        int panelw;
        int panelh;
        int x; 
        int y; 
        int w;
        int h;

        public Case(int imagew, int imageh, int panelw, int panelh, int x, int y, int w, int h) {
            this.imagew = imagew;
            this.imageh = imageh;
            this.panelw = panelw;
            this.panelh = panelh;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
        
        
        
    }
    
    
}
