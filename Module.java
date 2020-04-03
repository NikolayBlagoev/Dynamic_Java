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

        if (arguments > 0) {
            try {
                if (Executor.args[Executor.arg].matches("[0-9]+")) {
                    if (Executor.args[Executor.arg + 1].matches("[0-9]+")) {
                        Integer a = Integer.parseInt(Executor.args[Executor.arg]);
                        Integer b = Integer.parseInt(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        return f.execute(a, b);
                    } else {
                        Integer a = Integer.parseInt(Executor.args[Executor.arg]);
                        Module b = Executor.modules.get(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        return f.execute(a, b);
                    }
                } else {
                    if (Executor.args[Executor.arg + 1].matches("[0-9]+")) {
                        Module a = Executor.modules.get(Executor.args[Executor.arg]);
                        Integer b = Integer.parseInt(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        return f.execute(a, b);
                    } else {
                        Module a = Executor.modules.get(Executor.args[Executor.arg]);
                        Module b = Executor.modules.get(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        return f.execute(a, b);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Missing argument at position " + Executor.arg + " " + arguments+" "+moduleName);
                return 0;
            }
        } else {
            return f.execute(1, 1);
        }
        //.matches("[a-zA-Z0-9]+"
    }
    public Object execute(String[] args) {

            try {
                if (Executor.args[Executor.arg].matches("[0-9]+")) {
                    if (Executor.args[Executor.arg + 1].matches("[0-9]+")) {
                        Integer a = Integer.parseInt(Executor.args[Executor.arg]);
                        Integer b = Integer.parseInt(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        return f.execute(a, b);
                    } else {
                        Integer a = Integer.parseInt(Executor.args[Executor.arg]);
                        Module b = Executor.modules.get(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        return f.execute(a, b);
                    }
                } else {
                    if (Executor.args[Executor.arg + 1].matches("[0-9]+")) {
                        Module a = Executor.modules.get(Executor.args[Executor.arg]);
                        Integer b = Integer.parseInt(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        return f.execute(a, b);
                    } else {
                        Module a = Executor.modules.get(Executor.args[Executor.arg]);
                        Module b = Executor.modules.get(Executor.args[Executor.arg + 1]);
                        Executor.arg += 2;
                        return f.execute(a, b);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Missing argument at position " + Executor.arg + " " + arguments+" "+moduleName);
                return 0;
            }
        }


    public void generate(String[] args, int arg){
        Object output=null;

        //.matches("[a-zA-Z0-9]+"
    }
}
