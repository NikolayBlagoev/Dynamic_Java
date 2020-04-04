public class Module {
    SimpleFunction f;
    int arguments = 2;
    String moduleName;
    public Module(SimpleFunction func, String modulename) {
        f = func;
        moduleName=modulename;
    }

    public Module(SimpleFunction func, int arguments, String modulename) {
        f = func;
        this.arguments = arguments;
        moduleName=modulename;
    }

    public Module() {

    }

    public Object execute() {
        //System.out.println(" Entering "+moduleName+" with argument number "+Executor.arg);
        if (arguments > 0) {

            try {
                if (Executor.args[Executor.arg].matches("[0-9]+")) {
                    if (Executor.args[Executor.arg + 1].matches("[0-9]+")) {
                        Integer a = Integer.parseInt(Executor.args[Executor.arg]);
                        Integer b = Integer.parseInt(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        Object ob=  f.execute(a, b);

                        return ob;
                    } else {
                        Integer a = Integer.parseInt(Executor.args[Executor.arg]);
                        Module b = Executor.modules.get(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        Object ob=  f.execute(a, b);

                        return ob;
                    }
                } else {
                    Integer buff = Executor.arg;
                    Module a = Executor.modules.get(Executor.args[Executor.arg]);
                    Executor.arg += 1;
                    Integer res = (Integer) a.execute();

                    if (Executor.args[Executor.arg ].matches("[0-9]+")) {

                        Integer b = Integer.parseInt(Executor.args[Executor.arg ]);
                        Executor.arg += 1;
                        Object ob=  f.execute(res, b);

                        return ob;
                    } else {

                        Module b = Executor.modules.get(Executor.args[Executor.arg ]);
                        Executor.arg += 1;
                        Integer res2 = (Integer) b.execute();
                        Object ob=  f.execute(res,res2);
                        Executor.arg += 2;
                        return ob;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bounds "+Executor.arg);
                return 0;
            }
        } else {
            return f.execute(1, 1);
        }
        //.matches("[a-zA-Z0-9]+"
    }

    public void generate(String[] args, int arg){
        Object output=null;

        //.matches("[a-zA-Z0-9]+"
    }
}
