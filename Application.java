import java.util.Scanner;

public class Application {
    public static void main(String ars[]){

        SimpleFunction func1 = generate(2,1, 1, 3);
        System.out.println(func1.execute("hi","world"));
        System.out.println(func1.execute("hello","there"));
        SimpleFunction func2 = generate(10,0, 3, 5);
        System.out.println(func2.execute("hello","there"));
        SimpleFunction <String, String, SimpleFunction> func3 = generate2(10,0);
        System.out.println(func3.execute("hello","there").execute("ho","ho"));
        Scanner sc = new Scanner(System.in);
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

    public static SimpleFunction generate(int a, int b, int c, int d){

        SimpleFunction<String, String, String> smp = (par1,par2)->{
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
    public static SimpleFunction<String, String, SimpleFunction> generate2(int a, int b){

        SimpleFunction<String, String, SimpleFunction> smp = (par1,par2)->{
            SimpleFunction test = generate(a,b,1,2);
            return test;
        };
        return smp;
    }

}


