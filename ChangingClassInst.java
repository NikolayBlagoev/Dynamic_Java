public class ChangingClassInst implements ChangingClass {

    public static void po(){
        System.out.println("Hee");
    }
    //Uncomment this before pressing enter
//    public static void poes(){
//        System.out.println("Heello");
//    }
    @Override
    public int calc(Integer a, Integer b) {
        //Change return before pressing enter
        return a+b+10;
    }

    @Override
    public int calc(int[] arr) {
        return arr.length;
    }
}
