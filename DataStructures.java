import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class DataStructures {

    public static void main(String[] args) {

        //Variables
        Scanner questChoice = new Scanner(System.in);
        
        //Greeting
        System.out.println("Welcome to the \"Java Basics\" outpost, Traveler!");
        System.out.println("Tibbs:\"I am the Almighty Tiberius Thistlebottom! But you may call me Tibbs.\"");
        System.out.println("Tibbs:\"These quests laid before you show the basics of Java usage and tests in Junit framework! Be prepared Traveler, this is just the start!\"");
        System.out.println("Tibbs:\"Now Traveler, which quest will it be today?\"");
        int choice = questChoice.nextInt();
        
        switch(choice){

            default:
            System.err.println("Tibbs: My goodness, I didn't know reading was so difficult! What a shame...\n(Invalid Choice)");
        }

        questChoice.close();
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
    private stackNode head;
    private Integer top;

    public Navigation(){
        head = null;
        top = 0;
    }

    /**
     * @param notif The navigation to be added to the stack
     */
    public Integer addNavigation(String nav){
        //If no notifications
        if(head == null){
            head = new stackNode();
            head.setNav(top, nav);
            ++top;
            return 0;
        }
        //If more than one node
        else{
            //Max notifications in the array of the node
            if(top == 5){
                top = 0;
                stackNode temp = new stackNode();
                temp.setNext(head);
                temp.setNav(top, nav);
                head = temp;
                ++top;
                return top;
            }
            //Normal add
            else{
                head.setNav(top, nav);
                ++top;
                return top;
            }

        }
    }

    /**
     * Goal: Removes the most recent navigation from the stack after it's viewed
     */
    public int viewLatestNavigation(){
        if(head == null){
             throw new IllegalArgumentException("Navigation is Empty");
        }
        else{
            System.out.println("Notification:" + head.getMostRecentNavigation(top - 1));
            --top;

            //if the node is empty
            if(top == 0){
                if(head.getNext() != null){
                    head = head.getNext();
                    top = 5;
                }
                else{
                    head = null;
                    top = 0;
                }
            }
        }
        return top;

    }

    /**
     * Goal: View and remove all notifications
     */
    public Integer viewAllNavigation(){
        if(head == null){
            throw new IllegalArgumentException("Navigation is Empty");
        }

        while(head != null & top > 0){
            viewLatestNavigation();
        }
        return 1;
    }

    /**
     * Goal: To check if Head is null
     */
    public int isHeadNull(){

        if(head == null){
            return 0;
        }
        else{
            return 1;
        }
    }

    public int getTop(){
        return top;
    }
}

/**
 * This class is for the sepearte queue node
 */
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

    public void setNotification(String notif){
        notification = notif;
    }

    public void setNext(queueNode setter){
        next = setter;
    }

}

/**
 * This is the queue. Using a queue we will cycle through notifications
 */
class Notifications{
    queueNode rear;

    public Notifications(){
        rear = null;
    }

    /**
     * Enqueue
     */
    public void addNotification(String notif){
            queueNode addNotif = new queueNode();
            addNotif.setNotification(notif);

            if(rear == null){
                rear = addNotif;
                rear.setNext(rear);
            }
            else{
                queueNode first = rear.getNext();
                rear.setNext(addNotif);
                addNotif.setNext(first);
                rear = addNotif;
            }
    }

    /**
     * Dequeue
     */
    public String viewNotification(){
        String notif = "";
        if(rear == null){
            throw new IllegalArgumentException("Notifications are empty");
        }
        if(rear == rear.getNext()){
            notif = rear.getNotification();
            rear = null;
            return notif;
        }
        else{
            queueNode temp = rear.getNext();
            rear.setNext(temp.getNext());
            notif = temp.getNotification();
            return notif;
        }
    }

    /**
     * Dequeue All
     */
    public ArrayList<String> viewAllNotifications(){
        ArrayList<String> notifications = new ArrayList<>();

        if(rear == null){
            throw new IllegalArgumentException("Notifications are empty");
        }
        
        while(rear != null){
           notifications.add(viewNotification());
        }

        return notifications;
    }

    public int isRearNull(){
        if(rear == null){
            return 0;
        }
        else{
            return 1;
        }
        
    }

    public int notifCount(){
        if(rear == null){
            return 0;
        }
        
        int count  = 1;
        queueNode temp = rear.getNext();
        while(temp != rear){
            ++count;
            temp = temp.getNext();
        }
        return count;
        
    }
}   