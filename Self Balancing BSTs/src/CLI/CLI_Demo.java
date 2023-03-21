package CLI;

import AVL_Tree.AVL_Tree;
import Abstractions.Super_Tree;
import RB_Tree.RB_Tree;
import java.util.Scanner;

public class CLI_Demo {

    public Super_Tree<String> myTree;

    public void WrongMessage() {
        System.out.println("Wrong Command");
    }

    public void Cmd() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true) {
            input = scanner.nextLine();
            String[] args = input.split(" ");
            switch (args[0]) {
                case "exit":
                    System.exit(0);
                case "new":
                    if(args[1] == null) {
                        WrongMessage();
                        break;
                    }
                    if(args[1].equalsIgnoreCase("AVL"))
                        myTree = new AVL_Tree<String>();
                    else if(args[1].equalsIgnoreCase("RB"))
                        myTree = new RB_Tree<String>();
                    break;
                case "insert":
                    if(args[1] == null) {
                        WrongMessage();
                        break;
                    }
                    if(myTree.insert(args[1]))
                        System.out.println(args[1] + " was inserted successfully");
                    break;
                case "delete":
                    if(args[1] == null) {
                        WrongMessage();
                        break;
                    }
                    if(myTree.delete(args[1]))
                        System.out.println(args[1] + " was deleted successfully");
                    break;
                case "search":
                    if(args[1] == null) {
                        WrongMessage();
                        break;
                    }
                    if(myTree.search(args[1]))
                        System.out.println(args[1] + " was found successfully");
                    break;
                case "batch":
                    if(args[1] == null) {
                        WrongMessage();
                        break;
                    }
                    if(args[1].equals("insert"))
                        myTree.batchInsert(args[2]);
                    else if(args[1].equals("delete"))
                        myTree.batchDelete(args[2]);
                    else WrongMessage();
                    break;
                case "size":
                    System.out.println(myTree.getSize());
                    break;
                case "height":
                    System.out.println(myTree.getHeight());
                    break;
                default:
                    WrongMessage();
            }
        }
    }

    public static void main(String[] args) {
        CLI_Demo CLI = new CLI_Demo();
        CLI.Cmd();
    }
}