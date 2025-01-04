import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class DataStructures {

    public static void main(String[] args) {
        // Your code here
    }

}

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

class Notifications{
    stackNode head;
    Integer top;

    public Notifications(){
        head = null;
        top = 0;
    }

    /**
     * @param notif The notification to be added to the stack
     */
    public void addNotif(String notif){
        //If no notifications
        if(head == null){
            head = new stackNode();
            head.setNav(top, notif);
            ++top;
        }
        //If more than one node
        else{
            //stackNode current = head;

            /*while(current.getNext() != null){
                current = current.getNext();
            }*/

            //Max notifications in the array of the node
            if(top == 5){
                top = 0;
                stackNode temp = new stackNode();
                temp.setNext(head)
                temp.setNav(top, notif);
                ++top;
            }
            //Normal add
            else{
                head.setNav(top, notif);
                ++top;
            }

        }
    }

    /**
     * Goal: Removes the most recent notification from the stack after it's viewed
     */
    public void viewLatestNotif(){
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
}

class queueNode{

}