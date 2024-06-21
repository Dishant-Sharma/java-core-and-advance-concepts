public class V21BreakStatement {
    public static void main(String[] args) {
        executeSwitch(2,2);
    }
    static void executeSwitch(int a, int b){
        switch (a+b){
            case 1:
                System.out.println("Hey it's One");
                break;
            case 2:
                System.out.println("Hey it's Two");
                break;
            case 3:
                System.out.println("Hey it's Three");
                break;
            case 4:
                System.out.println("Hey it's Four");
            case 5:
                System.out.println("Hey it's Five");
            default:
                System.out.println("Hey it's "+ (a+b));
        }
    }
}
