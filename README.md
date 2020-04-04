# Operation_Valkyrie
Samples for dynamic Java code
  
#### Syntax for the interpreter:  
  
add [par1] [par2]  - Gives the sum of par1+par2 (can be integers or other methods)  
print [par1] [par2] - Will output to the console par1-times the output of par2 (par1 must be an integer, par2 can be either)  
loop [par1] [par2] - Will run par2 par1-times (par1 must be an integer, par2 can be either)  
def - enter definition of a new method followed by:  
{  
[newFunctionName] [-exe] [Integer1] [Integer2] - will run Integer1-times par2 of the newly declared function on execution and   will output Integer2+par2+(result of running Integer-1 times par2).  
Syntax for these functions:  
[newFunctionName] [par1] [par2] - both parameters can be either an integer or a another function  
}  
OR  
{  
[newFunctionName] [method [par1ForMethod] [par2ForMethod]] - saves the output of the executed method  
Syntax for these functions:  
[newFunctionName] - returns the output saved  
}  

 

----
#### Example Inputs and outputs:  
  
print 1 loop 1 add 2 3  
5  
print 1 loop 2 add 2 3  
10  
print 1 add add 3 4 add 4 5  
16  
print 1 add add add 3 2 3 4  
12  
def  
mod -exe 4 3  
mod 2 print 1 3  
3  
3  
3  
3  
def  
three add 1 2  
print 2 three   
3  
3  
