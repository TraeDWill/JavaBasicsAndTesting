import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

import static org.junit.Assert.*;
    
public class DataStructuresTests {

    private Navigation test = new Navigation();
    private String stuff = "Halp";

    @Test
    public void addNavigationEmpty(){
        test.addNavigation(stuff);
        int result = test.isHeadNull();
        assertEquals(1, result);
    }

    @Test
    public void addNavigationNotFull(){
        int initial = test.getTop();
        test.addNavigation(stuff);
        assertNotEquals(initial, test.getTop());
    }

    @Test
    public void addNavigationFullNode(){
        for(int i = 0; i < 7; ++i){
            test.addNavigation(stuff);
        }

        assertEquals(1, test.getTop());
    }

    @Test(expected = IllegalArgumentException.class)
    public void viewNavigationEmpty(){
        test.viewLatestNavigation();
    }

    @Test
    public void viewNavigationNormal(){
        
    }

}

