package Training.JavaDemos.Lab_Assignment.lab_2;

public class q3 {
    
    public static int largestNumber(int num1, int num2, int num3) {
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int num3 = 15;
        
        int largest = largestNumber(num1, num2, num3);
        System.out.println("The largest number is: " + largest);
    }
}
