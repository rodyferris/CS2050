/*
 * Your name: Rhodes Ferris
 * Description: Program 2
 */
public class Program2 {
    // TODO #1: finish the method's implementation
    public static double add(double a, double b) {
        return a+b;
    }
    // TODO #2: finish the method's implementation
    public static double subtract(double a, double b) {
        return a-b;
    }
    // TODO #3: finish the method's implementation
    public static double multiply(double a, double b) {
        double product=a*b;
        if(product==-0){
            return 0;
        }else {
            return a * b;
        }
    }
    // TODO #4: finish the method's implementation
    public static double divide(double a, double b) {
        if(b==0){
            throw new ArithmeticException();
        }
        return a/b;
    }
    // TODO #5: finish the method's implementation - assume right triangle
    public static double sinOfAngle(double oppSide, double hyp) {
        return oppSide/hyp;
    }
    // TODO #6: finish the method's implementation - assume right triangle
    public static double hypOfTriangle(double sideA, double sideB) {
        return Math.sqrt((sideA*sideA)+(sideB*sideB));
    }
    public static void main(String[] args) {
        System.out.println(add(5,6));
        System.out.println(subtract(3,7));
        System.out.println(multiply(12,6));
        System.out.println(divide(34,7));
        System.out.println(sinOfAngle(30,45));
        System.out.println(hypOfTriangle(30,30));
    }
}