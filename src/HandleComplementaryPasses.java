import java.util.Scanner;
import java.util.Stack;
public class HandleComplementaryPasses {
    Scanner reader = new Scanner(System.in);
    Stack<ComplementaryPasses> compPasses=new Stack<>();
    public void handleComplementaryPasses(){
        int choice = 0;
        do{
            System.out.println("\n"+"Here are the complementary passes operations available to you:"+"\n");
            System.out.println("Type 1 to redeem complementary passes:"+"\n");
            System.out.println("Type 2 to display the list of redeemed complementary passes:"+"\n");
            System.out.println("Type 3 to display the last redeemed complementary passe:"+"\n");
            System.out.println("Type 4 to undo the redeemed complementary passe:"+"\n");
            System.out.println("Type 5 to QUIT:"+"\n");
            choice = reader.nextInt();
            reader.nextLine();
            switch(choice){
                case 1:
                    System.out.println("How many complementary passes would you like to redeem?");
                    int num = reader.nextInt();
                    reader.nextLine();
                    redeemComplementaryPasses(num);
                    break;
                case 2:
                    displayComplementaryPasses();
                    break;
                case 3:
                    displayLastRedeemedComplementaryPass();
                    break;
                case 4:
                undoRedeemedComplementaryPass();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (choice!=5);
    }
    public void redeemComplementaryPasses(int num){
        if(compPasses.size()>=10){
            System.out.println("Invalid operation. All the passes have been redeemed");
            return;
        }
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the pass ID of the complementary pass " + (i + 1) + ": ");
            String passID = reader.nextLine();
            System.out.println("Enter the access level of the complementary pass " + (i + 1) + ": ");
            String accessLevel = reader.nextLine();
            compPasses.push(new ComplementaryPasses(passID,accessLevel));
        }
    }
    public void displayComplementaryPasses(){
        if(compPasses.isEmpty()){
            System.out.println("No complementary passes have been redeemed");
            return;
        }
        System.out.println("The details of the redeemed complementary passes are: ");
        for (ComplementaryPasses compPass : compPasses) {
            System.out.println(compPass);
        }
    }
    public void displayLastRedeemedComplementaryPass(){
        if(compPasses.isEmpty()){
            System.out.println("No complementary passes have been redeemed");
            return;
        }
        System.out.println("The details of the last redeemed complementary pass are: ");
        System.out.println(compPasses.peek());
    }
    public void undoRedeemedComplementaryPass(){
        if(compPasses.isEmpty()){
            System.out.println("No complementary passes have been redeemed");
            return;
        }
        System.out.println("The Pass ID you want to undo:");
        String passID = reader.nextLine();
        int flag=0;
        Stack<ComplementaryPasses> temp=new Stack<>();
        while (!compPasses.isEmpty()){
            if(compPasses.peek().getPassID().equals(passID)){
                compPasses.pop();
                flag=1;
                break;
            }
            temp.push(compPasses.pop());
        }
        while (!temp.isEmpty()){
            compPasses.push(temp.pop());
        }
        if(flag==0){
            System.out.println("The pass ID is not found");
        }else {
            System.out.println("The pass ID has been undone");
        }
    }
}