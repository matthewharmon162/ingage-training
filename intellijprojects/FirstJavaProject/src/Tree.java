import java.awt.*;

public class Tree {

    String species;
    double heightInFeet;
    Color treeColor;

    public Tree(String inputSpecies,
               double inputHieghtInFeet,
               Color  inputTreeColor){

        this.species = inputSpecies;
        this.heightInFeet = inputHieghtInFeet;
        this.treeColor = inputTreeColor;

    }
    public void changeTreeAlive(Color newTreeColor){
        this.treeColor = newTreeColor;

    }
    public void printTreeName(){
        System.out.println(species);
    }
    public double growingTaller(double currentHeight){
        currentHeight += 20;
        return currentHeight;


    }
}
