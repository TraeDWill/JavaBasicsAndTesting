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
        System.out.println("Quest Board: \n1. Easy(Hash Map)\n2. Medium(Stack)\n3. Hard(Queue)\n4.Finish your traveling(Quit)");
        int choice = questChoice.nextInt();
        
        switch(choice){
            case(1):
                System.out.println("Tibbs:\"Easy huh? Well we all must start somewhere!\"");
                System.out.println("Tibbs:\"This quest uses a Hash Map in order to simulate a contact list for some witchcraft known as a cellphone!\"");
                firstQuest();
                break;

            case(2):
                System.out.println("Tibbs:\"Atta boy Traveler! Medium is much more the pace of an accomplished Traveler!\"");
                System.out.println("Tibbs:\"This quest uses a Stack in order to keep track of where one has navigated to on the mystical phone device!\"");
                secondQuest();
                break;
            case(3):
                System.out.println("Tibbs:\"HARD?!?! Traveler you are either incredibly brave or incredibly foolish!\"");
                System.out.println("Tibbs:\"Make sure to leave your name with the clerk on the way out so we can bet... I mean keep track of you!\"");
                System.out.println("Tibbs:\"This quest uses a Queue in order to keep track of a magically instant form of communication known as Notifications! Be careful of the Notifications Traveler!\"");
                thirdQuest();
                break;

            default:
                System.err.println("Tibbs: My goodness, I didn't know reading was so difficult! What a shame...\n(Invalid Choice)");
                break;
        }
        System.out.println("Be well until we next meet, Traveler! I will have plenty more for you soon!")
        questChoice.close();
    }

    /**
     * Goal: Showcase the usage of the Hashmap Implemented
     */
    public static void firstQuest(){

        // Variables
        Scanner use = new Scanner(System.in);
        int choice = 0;
        String sInput = "";
        int iInput = 0;
        Contacts list = new Contacts();

        do{
            System.out.println("Hash Map Uses:\n1.Insert\n2.Remove\n3.Retreieve number by name.\n4.Display all contacts.\n5.Display amount of contacts.\n6.Exit");
            choice = use.nextInt();

            switch(choice){
                case(1):
                    System.out.println("Name of the contact being added:");
                    sInput = use.nextLine();
                    System.out.println("The phone number of said contact:");
                    iInput = use.nextInt();
                    list.addContact(sInput, iInput);
                    break;

                case(2):
                    System.out.println("Name of the contact being removed:");
                    sInput = use.nextLine();
                    list.removeContact(sInput);
                    break;

                case(3):
                    System.out.println("Name of the contact being retrieved:");
                    sInput = use.nextLine();
                    int number = list.getNumber(sInput);
                    System.out.println("The number for " + sInput + "is: " + number);
                    break;
                    
                case(4):
                    System.out.println("List of contacts:");
                    list.listContacts();
                    break;

                case(5):
                    int size = list.sizeOfContacts();
                    System.out.println("The amount of contacts this list has is: " + size);
                    break; 

                case(6):
                    System.out.println("Tibbs:\"Great work at a... Gooooood starting task!\"")
                    break;

                default:
                    System.out.println("Tibbs:\"I know this is the easy quest, but come now Traveler! My great, great, great grandmother can still differentiate between numbers!\"\n(Invalid Choice)");
                    break;
            }
        }while(choice != 6);

        use.close();
        
    }

    /**
     * Goal: Showcase the usage of the Stack implemented
     */
    public static void secondQuest(){

        
        // Variables
        Scanner use = new Scanner(System.in);
        int choice = 0;
        String sInput = "";
        Navigation nav = new Navigation();

        do{
            System.out.println("Stack Uses:\n1.Push\n2.Pop\n3.Display all.\n4.Exit");
            choice = use.nextInt();

            switch(choice){
                case(1):
                    System.out.println("Name of the place being navigated to:");
                    sInput = use.nextLine();
                    nav.addNavigation(sInput);
                    break;

                case(2):
                    int result = nav.viewLatestNavigation();
                    if(result == 0){
                        System.out.println("No more navigation history available.");
                    }
                    break;

                case(3):
                    nav.viewAllNavigation();
                    break;

                case(4):
                    System.out.println("Tibbs:\"How surprising! Looks like there's more to you than meets the eye! Medium quest finished!\"");
                    break;

                default:
                    System.out.println("Tibbs:\"*Takes a deep breath* Look Traveler, you've been doing this for a while. You have less choices than fingers on your hands! Choose correctly!\"\n(Invalid Choice)");
                    break;
            }
        }while(choice != 4);

        use.close();
        

    }
    /**
     * Goal: Showcase the usage of the Queue implemented
     */
    public static void thirdQuest(){

        
        
        // Variables
        Scanner use = new Scanner(System.in);
        int choice = 0;
        String sInput = "";
        int iInput = 0;
        Notifications notif = new Notifications();

        do{
            System.out.println("Stack Uses:\n1.Enqueue\n2.Dequeue and display\n3.Dequeueu and display all.\n4.Amount of notifications\n5.Exit");
            choice = use.nextInt();

            switch(choice){
                case(1):
                    System.out.println("Notification contents:");
                    sInput = use.nextLine();
                    notif.addNotification(sInput);
                    break;

                case(2):
                    String result = notif.viewNotification();
                    System.out.println("Notification: "+ result);
                    break;

                case(3):
                    ArrayList<String> notifications = notif.viewAllNotifications();
                    for(String note : notifications){
                        System.out.println(note);
                    }
                    break;
                case(4):
                    int amount = notif.notifCount();
                    System.out.println("Notifications amount:" + amount);
                    break;

                case(5):
                    System.out.println("Tibbs:\"Tra..TRAVELER!!! YOU SURVIVED! Wait.. Oh no my bet... I mean....\n*Tibbs takes out a ticket and tears it up*\nWelcome home Traveler, you've done truly well!(For everyone except my pocket)\"");
                    break;

                default:
                    System.out.println("Tibbs:\"I'm surprised you even accepted this one, Traveler! It's never too early to back out!(And double my pocket change)\"\n(Invalid Choice)");
                    break;
            }
        }while(choice != 4);

        use.close();

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