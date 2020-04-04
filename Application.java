import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.util.Scanner;

public class Application {
    public static void main(String ars[]) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        //Example 1 - a function generated with custom parameters
        DemoFunction func1 = generate(2, 1, 1, 3);

        System.out.println(func1.execute("hi", "world"));

        System.out.println(func1.execute("hello", "there"));

        //Example 2 - a function similar to example 1 but with different parameters given on initialisation
        DemoFunction func2 = generate(10, 0, 3, 5);
        System.out.println(func2.execute("hello", "there"));

        //Example 3 - a function that returns a function
        DemoFunction<String, String, DemoFunction> func3 = generate2(10, 0);
        System.out.println(func3.execute("hello", "there").execute("ho", "ho"));

        //Example 4 - a function with varying length of parameters
        ComplexFunction<Integer> add = (par) -> {
            Integer output = 0;
            for (int i = 0; i < par.length; i++) {
                output += (Integer) par[i];
            }
            return output;
        };

        Integer[] arr = {4, 5, 10, 3, 5}; //sums to 27
        System.out.println(add.execute(arr));

        //Example 5 - a class with appended methods to it
        DynamicClass dynamicClass = new DynamicClass();
        dynamicClass.methods.get("print").execute(new Object[]{dynamicClass.methods.get("add").execute(arr)});
        Scanner sc = new Scanner(System.in);


        //Example 6 - Dynamically recompiling a class
        ChangingClass inst1 = get();
        sc.nextLine();

        ChangingClass inst2 = get();

        System.out.println(inst1.calc(4, 5) + " " + inst2.calc(4, 5));



        //Example 7 - an interpreter-like thing. WARNING: It is a bit buggy so don't use it other than to fool around

        Executor ex = new Executor();
        while (true){
           String com = sc.nextLine();
           if(com.equals("def")) {
               com = sc.nextLine();
               String[] inp = com.split(" ");
               ex.add(inp);
           }else {
               ex.execute(com);
           }

        }


    }




    public static DemoFunction generate(int a, int b, int c, int d){

        DemoFunction<String, String, String> smp = (par1,par2)->{
            String output="";
            for(int i=0; i<a;i++) {
                output+=par1;
            }
            for(int i=0; i<b;i++) {
                output+=" ";
            }
            for(int i=0; i<c;i++) {
                output+=par2;
            }
            if(par1.length()>3) output+=d;
            if(par2.length()>d) output+=par2;
            return output;
        };
        return smp;
    }
    public static DemoFunction<String, String, DemoFunction> generate2(int a, int b){

        DemoFunction<String, String, DemoFunction> smp = (par1,par2)->{
            DemoFunction test = generate(a,b,1,2);
            return test;
        };
        return smp;
    }

    public static ChangingClass get() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        reCompile();
        ClassLoader parentClassLoader2 = CustomClassLoader.class.getClassLoader();
        CustomClassLoader classLoader2 = new CustomClassLoader(parentClassLoader2);
        return  ( ChangingClass) classLoader2.loadClass().newInstance();


    }
    public static void reCompile(){
        File classFile = new File("src/ChangingClassInst.java");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int res = compiler.run(null, System.out, System.out, classFile.getPath());
        //System.out.println(res);
    }


}

