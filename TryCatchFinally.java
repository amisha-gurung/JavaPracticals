public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println("A demo of using try-catch-finally blocks.");
        try{
            int n1 = 10/5;
            int n2 = 5/0;

            System.out.println("Try block");
            System.out.println("Result of 10/5 is: " + n1);
            System.out.println("Result of 5/0 is: " + n2);
        }catch(ArithmeticException e){
            System.out.println("Error message: " + e.getMessage());
        }finally{
            System.out.println("This is finally block, The program is terminated");
        }
    }
}
