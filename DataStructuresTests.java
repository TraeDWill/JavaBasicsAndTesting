import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

import static org.junit.Assert.*;
    
public class DataStructuresTests {

    private Navigation test = new Navigation();
    private String stuff = "Halp";
    private Notifications otherTest = new Notifications();

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
        for(int i = 0; i < 6; ++i){
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
        test.addNavigation(stuff);
        test.viewLatestNavigation();
        assertEquals(0, test.getTop());
    }

    @Test
    public void viewNavigationNewNode(){
        for(int i = 0; i < 6; ++i){
            test.addNavigation(stuff);
        }
        assertEquals(5, test.viewLatestNavigation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void viewAllNavigationEmpty(){
        test.viewAllNavigation();
    }

    @Test
    public void viewAllNavigationNewNode(){
        for(int i = 0; i < 6; ++i){
            test.addNavigation(stuff);
        }
        test.viewAllNavigation();
        assertEquals(0, test.getTop());
    }

    @Test
    public void viewAllNavigationNormal(){
        for(int i = 0; i < 4; ++i){
            test.addNavigation(stuff);
        }
        test.viewAllNavigation();
        assertEquals(0, test.getTop());
    }

    @Test
    public void addNotificationEmpty(){
        otherTest.addNotification(stuff);
        assertNotEquals(0, otherTest.isRearNull());
    }

    @Test
    public void addNotificationNormal(){
        for(int i = 0; i < 3; ++i){
            otherTest.addNotification(stuff);
        }

        assertEquals(3, otherTest.notifCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void viewNotificationEmpty(){
        otherTest.viewNotification();
    }

    @Test
    public void viewNotificationNormal(){
        for(int i = 0; i < 3; ++i){
            otherTest.addNotification(stuff);
        }
        int count = otherTest.notifCount();
        otherTest.viewNotification();
        assertNotEquals(count, otherTest.notifCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void viewAllNotificationsEmpty(){
        otherTest.viewAllNotifications();
    }

    @Test
    public void viewAllNotificationsNormal(){
        for(int i = 0; i < 3; ++i){
            otherTest.addNotification(stuff);
        }

        otherTest.viewAllNotifications();

        assertEquals(0, otherTest.isRearNull());
    }
}

