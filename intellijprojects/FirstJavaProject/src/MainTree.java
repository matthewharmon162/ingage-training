import java.awt.*;

public class MainTree {

    public static void main (String[] args){

        Tree myTree = new Tree("spruce", 20, Color.green);

        double myTreeHeight = 30;
        myTreeHeight = myTree.growingTaller(myTreeHeight);

        System.out.println(myTreeHeight);
        myTree.printTreeName();

    }
}
