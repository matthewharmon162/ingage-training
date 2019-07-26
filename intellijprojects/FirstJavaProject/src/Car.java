import java.awt.*;

public class Car {

    double averageMilesPerGallon;
    String licensePlate;
    Color paintColor;
    boolean areTailingWorking;

    public Car(double inputAverageMPG,
               String inputLicensePlate,
               Color inputPaintColor,
                boolean inputAreTailligntsWorking){

        this.averageMilesPerGallon = inputAverageMPG;
        this.licensePlate = inputLicensePlate;
        this.paintColor = inputPaintColor;
        this.areTailingWorking = inputAreTailligntsWorking;

    }

    public void changePaintColor(Color newPaintColor){
        this.paintColor = newPaintColor;
    }

    public double speedingUp(double currentSpeed){
        currentSpeed += 100;
        return currentSpeed;
    }
}
