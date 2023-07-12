package model;

public class Calculator {
    public static float calculate(float firtnumber, float secondnumber, char opera){
        switch (opera){
            case '+':
                return firtnumber + secondnumber;
            case '-':
                return firtnumber - secondnumber;
            case '*':
                return firtnumber * secondnumber;
            case '/':
                if (secondnumber != 0){
                    return firtnumber / secondnumber;
                }
                else {
                    throw new RuntimeException("Cant divide by zero");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
