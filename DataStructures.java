import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class DataStructures {

    public static void main(String[] args) {
        // Your code here
    }

}

/**
 * This class is a hash map of contacts
 */
class Contacts{
    HashMap<String, Integer> contacts = new HashMap<String, Integer>();

    public Contacts(){
        contacts = new HashMap<String, Integer>();
    }

    public void addContact(String name, int number){
        contacts.put(name, number);
    }

    public void removeContact(String name){
        contacts.remove(name);
    }

    public int getNumber(String name){
        return contacts.get(name);
    }

    public void listContacts(){
        for(String i : contacts.keySet()){
            System.out.println("Name:" + i + "Phone Number:" + contacts.get(i));
        }
    }

    public int sizeOfContacts(){
        return contacts.size();
    }
}
/*
 * This is the stack node
 */
class stackNode{
    private String[] history = new String[5];
    private stackNode next;

    public stackNode(){
        next = null;
    }

    public void setNext(stackNode nextNode){
        next = nextNode;
    }

    public stackNode getNext(){
        return next;
    }

    public String getMostRecentNavigation(Integer top){
        return history[top];
    }

    public void setNav(Integer top, String nav){
        history[top] = nav;
    }

}

/*
 * The Stack class itself
 */

class Navigation{
    stackNode head;
    Integer top;

    public Navigation(){
        head = null;
        top = 0;
    }

    /**
     * @param notif The navigation to be added to the stack
     */
    public void addNavigation(String nav){
        //If no notifications
        if(head == null){
            head = new stackNode();
            head.setNav(top, nav);
            ++top;
        }
        //If more than one node
        else{
            //Max notifications in the array of the node
            if(top == 5){
                top = 0;
                stackNode temp = new stackNode();
                temp.setNext(head)
                temp.setNav(top, nav);
                ++top;
            }
            //Normal add
            else{
                head.setNav(top, nav);
                ++top;
            }

        }
    }

    /**
     * Goal: Removes the most recent navigation from the stack after it's viewed
     */
    public void viewLatestNavigation(){
        if(head == null){
            System.err.println("There are no notifications");
        }
        else{
            System.out.println("Notification:" + head.getMostRecentNavigation(top - 1));
            --top;

            //if the node is empty
            if(top == 0){
                head = head.getNext();
                top = 4;
            }
        }

    }

    /**
     * Goal: View and remove all notifications
     */
    public void viewAllNavigation(){
        if(head == null){
            System.out.println("There are no notifications.");
        }

        while(head != null & top < 0){
            head.getMostRecentNavigation(top - 1);
            --top;
            if(top == 0){
                head = head.getNext();
                top = 5;
            }
        }
    }

}

class queueNode{
    String notification;
    queueNode next;

    public queueNode(){
        notification = "";
        next = null;
    }

    public queueNode getNext(){
        return next;
    }

    public String getNotification(){
        return notification;
    }

}

class Notifications{

}