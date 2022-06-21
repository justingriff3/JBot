import java.util.*;
import java.io.*;

public class dinnerGenerator{

    
    public static String ans;
    public static boolean know = true;
    public static dinnerGenerator dg = new dinnerGenerator();
    Map<String, ArrayList<String>> foodList = new HashMap<String, ArrayList<String>>();
    public static boolean confirm = false;
    Scanner keyboard = new Scanner(System.in);

    public void createfoodList() throws FileNotFoundException
    {   
        try{
        File fList = new File("foodList.txt");
        Scanner reader = new Scanner(fList); 
        String food;
        while(reader.hasNextLine())
        {   food = reader.nextLine();
            System.out.println(food);
            foodList.put(food, new ArrayList<String>());
            foodList.get(food).add("dough");
            foodList.get(food).add("cheese");
            foodList.get(food).add("tomato sauce");
        }
             } catch (FileNotFoundException e)
             { System.out.println("NO"); }
    }

    public void ingCheck()
    {
        System.out.println("Do you have these ingredients? " + 
            foodList.get(ans));
            String ing = keyboard.nextLine();
            ing = ans.toLowerCase();
            ing = ing.replaceAll("\\s", "");

            if(ing == "yes")
            {
                confirm = true;
                dg.solution();
            }        
    }

public void solution()
{
    System.out.println("Looks like you are having " +
        foodList.get(ans) + ", Enjoy!");
}

    public void ask()
    {
        System.out.println("What do you want to eat today?");
        ans = keyboard.nextLine();
        ans = ans.toLowerCase();
        ans = ans.replaceAll("\\s","");

    }

    public void know(String k)
    {    
        if(k.contains("dnt") || k.contains("know"))
            know = false;

        switch(k)
        {
            case "idontknow":
                know = false;
                break;
            case "imnotsure":
                know = false;
                break;
            case "no":
                know = false;
                break;
        }        
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {   
         dinnerGenerator dg = new dinnerGenerator();

        dg.createfoodList();     
        dg.ask();
        dg.know(ans);
        dg.ingCheck();
       


    }
    
}
