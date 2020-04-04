package CustomLoading;

import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class Executor {
    public static HashMap<String, Module>   modules = new HashMap<>();
    public static String[] args;
    public static Integer arg;
   public static SimpleFunction<Object,Object, Integer> add=(a,b)->{

       Integer a1 = 0;
       if(a instanceof Module){
           a1 =(Integer) ((Module) a).execute();
       }else{
           a1=(Integer) a;
       }
       Integer b1 = 0;
       if(b instanceof Module){
           b1 =(Integer) ((Module) b).execute();
       }else{
          b1=(Integer) b;
       }

        return a1+b1;
   };
    public static SimpleFunction<Object,Object, Integer> print=(a,b)->{
        Integer a1 = (Integer) a;

        if(b instanceof Module){
            Module b1 =((Module) b);
            Integer cp = arg;
            Integer output=0;

            for(;a1>0;a1--) {
                output=(Integer) b1.execute();
                System.out.println(output);
                arg=cp;
            }
            return output;
        }else{
            Integer b1=(Integer) b;
            for(;a1>0;a1--) System.out.println(b1);
            return b1;
        }

    };
    public static SimpleFunction<Object,Object, Integer> loop=(a,b)->{
        Integer a1 = (Integer) a;
        Module b1 = (Module) b;
        Integer output=0;
        Integer cp = arg;
        for(;a1>0;a1--){
            output+=(Integer) b1.execute();

            arg=cp;
        }

        return output;
    };
   public static Module addition = new Module(add,"add");
    public static Module output = new Module(print,"print");
    public static Module iterate = new Module(loop,"loop");
   static {
       modules.put("add", addition);
       modules.put("loop", iterate);
       modules.put("print", output);

   }
    public Executor(){

    }
    public Object execute(String command){
       try {
           args = command.split(" ");
           arg = 1;
           return modules.get(args[0]).execute();
       }catch (NullPointerException e){
           System.out.println("Invald module name");
       }catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Invald parameter number");
       }
       return null;
    }
    public SimpleFunction generate(int a, int b){

        SimpleFunction<Object, Object, Integer> smp = (par1,par2)->{
            Integer a1 = 0;
            if(par1 instanceof Module){
                a1 =(Integer) ((Module) par1).execute();
            }else{
                a1=(Integer) par1;
            }

           Integer output=0;
            if(par2 instanceof Module){
               // System.out.println("Test 90 " +output);
                Integer cp = arg;
               Module b1 = (Module) par2;
                int i = a;
                for(;i>0;i--) {
                    output+=(Integer) b1.execute();
                   // System.out.println("Test " +output+" "+b1.moduleName);
                    arg=cp;
                }
            }else{
                output=(Integer) par2;
                output*=a;
            }
          //  System.out.println("Test 102 " +output);
            return output+a1+b;

        };
        return smp;
    }

    public SimpleFunction<String, String, SimpleFunction> generate2(int a, int b){

        SimpleFunction<String, String, SimpleFunction> smp = (par1,par2)->{
            SimpleFunction test = generate(a,b);
            return test;
        };
        return smp;
    }



    public void add(String[] arguments){
       args=arguments;
       String customName=args[0];
       if(args[1].equals("-exe")) {
           SimpleFunction smp = generate(Integer.parseInt(args[2]),Integer.parseInt(args[3]));
           Module mod = new Module(smp, 2, customName);
           modules.put(customName, mod);
       }else {
           String command = args[1];
           arg = 2;
           Integer output = (Integer) modules.get(command).execute();
           SimpleFunction<Integer, Integer, Integer> smp = (a, b) -> {
               return output;
           };
           Module mod = new Module(smp, 0, customName);
           modules.put(customName, mod);
       }
    }


}
