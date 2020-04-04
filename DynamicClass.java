package CustomLoading;

import java.util.HashMap;

public class DynamicClass {
    public HashMap<String, ComplexFunction> methods;
    public DynamicClass(){
        methods = new HashMap<>();


        ComplexFunction<Integer> add =(par)->{
            Integer output = 0;
            for(int i=0; i<par.length;i++){
                output+=(Integer) par[i];
            }
            return output;
        };

        methods.put("add",add);

        ComplexFunction<Integer> print =(par)->{
            Integer output = 0;
            String printJob="";
            for(int i=0; i<par.length;i++){
                if(par[i] instanceof Integer){
                   printJob+=(Integer) par[i];
                   printJob+=" ";
                }else{
                    printJob+=(Integer) ((ComplexFunction) par[i]).execute(new Integer[]{5, 5});
                }

            }
            System.out.println(printJob);
            return output;
        };
        methods.put("print",print);


    }
}
