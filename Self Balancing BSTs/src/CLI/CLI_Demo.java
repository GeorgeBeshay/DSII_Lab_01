package CLI;

import AVL_Tree.AVL_Tree;
import Abstractions.Super_Tree;
import RB_Tree.RB_Tree;
import java.util.Scanner;

public class CLI_Demo {

    public static Super_Tree<String> myDictionary;

    public CLI_Demo(String treeType) {
        myDictionary = null;
        if(treeType.equalsIgnoreCase("AVL"))
            myDictionary = new AVL_Tree<String>();
        else if(treeType.equalsIgnoreCase("RB"))
            myDictionary = new RB_Tree<String>();
        else WrongMessage();
    }
    public void WrongMessage() {
        System.out.println("Wrong Command");
    }

    public void Cmd() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true) {
            System.out.print("Enter the desired command: ");
            input = scanner.nextLine();
            String[] args = input.split(" ");

            switch (args[0]) {
                case "exit":
                    System.exit(0);
                case "insert":
                    if(args.length != 2) {
                        WrongMessage();
                        break;
                    }
                    if(myDictionary.insert(args[1]))
                        System.out.println(args[1] + " was inserted successfully");
                    break;
                case "delete":
                    if(args.length != 2) {
                        WrongMessage();
                        break;
                    }
                    if(myDictionary.delete(args[1]))
                        System.out.println(args[1] + " was deleted successfully");
                    break;
                case "search":
                    if(args.length != 2) {
                        WrongMessage();
                        break;
                    }
                    if(myDictionary.search(args[1]))
                        System.out.println(args[1] + " was found successfully");
                    break;
                case "batch":
                    if(args.length != 3) {
                        WrongMessage();
                        break;
                    }
                    if(args[1].equals("insert"))
                        myDictionary.batchInsert(args[2]);
                    else if(args[1].equals("delete"))
                        myDictionary.batchDelete(args[2]);
                    else WrongMessage();
                    break;
                case "size":
                    System.out.println(myDictionary.getSize());
                    break;
                case "height":
                    System.out.println(myDictionary.getHeight());
                    break;
                case "traverse":
                    myDictionary.traverse();
                    break;
                default:
                    WrongMessage();
            }
        }
    }

    public static void main(String[] args) {
        CLI_Demo CLI = null;
        while(myDictionary == null ) {
            System.out.print("Enter the desired tree type for your dictionary: ");
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            CLI = new CLI_Demo(input);
        }
        CLI.Cmd();
    }
}