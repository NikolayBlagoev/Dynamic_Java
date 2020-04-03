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
        args = command.split(" ");
        arg=1;
        return modules.get(args[0]).execute();
    }

    public void add(String[] arguments){
       args=arguments;
       String customName=args[0];
       if(args[1].equals("-exe")) {
           String command = args[2];
           arg = 3;

           SimpleFunction<Integer, Integer, Integer> smp = (a, b) -> {
               return (Integer) modules.get(command).execute();
           };
           Module mod = new Module(smp, 0, customName);
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
