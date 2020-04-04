public class ChangingClassInst implements ChangingClass {

    @Override
    public int calc(Integer a, Integer b) {
        return a+b+10;
    }

    @Override
    public int calc(int[] arr) {
        return arr.length;
    }
}
