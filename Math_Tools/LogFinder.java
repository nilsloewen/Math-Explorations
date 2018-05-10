package Math_Tools;
import java.util.Scanner;

public class LogFinder 
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
                        
      printEulersMethod();
   
      logFinder();
   }

// Euler's Method
   public static void printEulersMethod()
   {
      System.out.printf(    "—————————————————————————————————————————————————————————————————————————"
                        + "\n# Nils Loewen's Log Finder using Euler's Method                          "  
                        + "\n#                                                                        "
                        + "\n# Scope: Inputs and output are limited by Java's double type.            " 
                        + "\n#        Can compute Natural Logs by inputing base 'e'.                  "
                        + "\n#        Input of subject can take exponent form: a^b.                   "
                        + "\n                                                                         "   
                        + "\n Euler's Method of finding a Log is Greasy. He pins the unknown Log bet- "
                        + "\n ween two known Limits, then Moves the Goalposts until the unknown gives "
                        + "\n up its secrets. Using Log Property 1: Sum of Logs, ingeniously paired   "   
                        + "\n with square roots expressed as fractional exponents, the midpoint of     "   
                        + "\n the limits is found. By a simple test to see which side of the midpoint "
                        + "\n the unknown is on we choose which limit to update with the new value and" 
                        + "\n then the process is repeated. Thus narrowing the answer down by as many " 
                        + "\n digits as desired.                                                      "
                        + "\n                                                                         "   
                        + "\n Property 1: Sum of Logs                                                 "
                        + "\n                                                                         "   
                        + "\n    Log[base](a) + Log[base](b) = Log[base](a * b)                       "
                        + "\n                                                                         "   
                        + "\n                                                                         "
                        + "\n Euler's insight is that the square root of the product of the limits    "
                        + "\n is linked to the midpoint of the the Log of the limits.                 "
                        + "\n                                                                         "
                        + "\n   Log(√ab) = Log(√a) + Log(√b) = Log(a)^½ + Log(b)^½ = Log(a) + Log(b)  "
                        + "\n                                                        ———————————————  "  
                        + "\n                                                               2         "
                        + "\n                                                                       \n");

      pressEnterKeyToContine();
   
      System.out.printf(  "\n By operating both ends of this equation at once, we can find both the   "
                        + "\n decimal value of z and the Log of z.                                    "
                        + "\n                                                                         " 
                        + "\n                                                                         " 
                        + "\n   Log(√a*b) = z                                                         "
                        + "\n                                                                         " 
                        + "\n   a                           <  z  <                            b      " 
                        + "\n   |—————————————————————————————*|*——————————————————————————————|      "
                        + "\n   Log(a)                    <  Log(z)  <                         Log(b) "      
                        + "\n                                                                         " 
                        + "\n   Log(a) + Log(b) = Log(z)                                              " 
                        + "\n   ———————————————                                                       " 
                        + "\n          2                                                              " 
                        + "\n                                                                     \n\n"); 

 //     pressEnterKeyToContine();

      System.out.printf(  "\n   Steps of Euler's Method (for Log base 10):                            " 
                        + "\n                                                                         " 
                        + "\n      *  If x > 10, separate out magnitudes of 10.                       " 
                        + "\n         Ex. Log(1618) = Log(1.618) + Log(10^3) = Log(1.618) + 3         "
                        + "\n                                                                         "
                        + "\n      *  a = 1, b = 10                                                   "
                        + "\n                                                                         "
                        + "\n      1. Log(√a*b) = z                                                   "
                        + "\n                                                                         " 
                        + "\n      2. Log(a) + Log(b) = Log(z)                                        " 
                        + "\n         ———————————————                                                 " 
                        + "\n                2                                                        " 
                        + "\n                                                                         " 
                        + "\n      3. if   (x < z)                                                    " 
                        + "\n         then {b = z}                                                    " 
                        + "\n                                                                         " 
                        + "\n         if   (z < x)                                                    " 
                        + "\n         then {a = z}                                                    "
                        + "\n                                                                         " 
                        + "\n      4. if   (z is accurate enough)                                     "
                        + "\n         then {stop}                                                     " 
                        + "\n         else {Go to step 1}                                             "
                        + "\n                                                                         " 
                        + "\n—————————————————————————————————————————————————————————————————————————\n\n");
   
      pressEnterKeyToContine();
   }
   
   // print logFinder   
   public static void logFinder()
   {
      Scanner keyboard = new Scanner(System.in);
   
      double a    = 1, b    = 10, z    = 1;
      double loga = 0, logb = 1 , logz = 0;
      double base = 0, exponent = 1, x = 0;
   
      boolean ln = false;
      boolean reachedLimit = false;
      int count = 0;
   
   // Interact 

      boolean validBase = false;
      while (!validBase)
      {      
         System.out.printf("\n\n Enter Log base: ");
         String baseString = keyboard.next();

         if (baseString.indexOf("e") > -1)
         {
            base = Math.E;
            ln = true;
            validBase = true;
         }
         else  
         {
            base = Double.parseDouble(baseString);
         }
   
         if (base == 1 || base <= 0)
         {
            System.out.println(" ¡Dude!: What would base " + base + " even like mean, dude?");
         }
         else
         {
             validBase = true;
         }
      }

      // Subject and Exponent split
      boolean validSubject = false;
      String subjectString = "";
      while (!validSubject)
      {
         System.out.print("\n Enter subject: ");
         subjectString = keyboard.next();
         
         if (subjectString.indexOf("^") > -1) 
         {   
                    x = Double.parseDouble(
                        subjectString.substring(
                        0, subjectString.indexOf("^") ));

             exponent = Double.parseDouble( 
                        subjectString.substring(
                        subjectString.indexOf("^") + 1, 
                        subjectString.length() ) );
         } 
         else 
         {
            x = Double.parseDouble(subjectString);
         }

         if (x >= 1)
         {
            validSubject = true;
         }
         else 
         { 
            validSubject = false;
            System.out.println(" ¡ERROR!: Cannot compute subject < 1! \n Try Again: ");
         }
      }   

      System.out.println("\n\n   Searching for: Log[" + base + "](" + subjectString + ") = x \n");
   
      pressEnterKeyToContine();
   
      x = Math.pow(x, exponent);
      double xOriginal = x;
   
      
      //Reduce subject to below 10
      int exp = 0;
      String xtemp = Double.toString(x);
      if (x > 10)
      {
         while (x > 10) 
         {
            x = x / 10;
            exp++;
         }   
        
         System.out.printf(  "\nUnknown must be reduced to be between 0 and 10."
                           + "\n   x = " + xtemp 
                           + "\n   x = " + xtemp + " * 10^" + exp 
                           + "\n   x = Log(" + x + ") + Log(10^" + exp + ")"      
                           + "\n   x = Log(" + x + ") + " + exp);
                     
      }
   
      boolean baseChange = false;
      if (base != 10)
      {
         baseChange = true;
         System.out.printf("\n\n Property 4: Changing the Base of a Log:"
                      
                         + "\n\n    Log[a](x) = Log[b](x)"
                           + "\n                —————————"
                           + "\n                Log[b](a)"

                         + "\n\n   Log[%-16s](%-16s) = Log[10](%s)", Double.toString(base), Double.toString(x), Double.toString(x));
         System.out.printf(  "\n                                             —————————————————————————— "
                           + "\n                                             Log[10](%s)\n", Double.toString(base));
      }

      pressEnterKeyToContine();

      // Euler's Method
      while (!reachedLimit)
      {
         count++;

         z = Math.sqrt(a*b);
         logz = (loga + logb)/2;

         System.out.println(   "------------------------------------------------------------------------");
         System.out.println(   " " + count + " Iterations");
         
         System.out.printf(  "\n                                                                        " 
                           + "\n1. √(a                  * b                 )     = z                   ");
         System.out.printf(  "\n   √(%-18s * %-18s)     = %-18s \n", Double.toString(a), Double.toString(b), Double.toString(z));

         System.out.printf(  "\n2.  (Log(a)             + Log(b)            ) / 2 = Log(z)               ");
         System.out.printf(  "\n    (%-18s + %-18s) / 2 = %-18s \n\n\n", Double.toString(loga), Double.toString(logb), Double.toString(logz));   
         System.out.printf(  "\n3.                                x                                 "
                           + "\n              ? 🡯 ?               %-18s ? 🡮  ? ", Double.toString(x));

         System.out.printf("\n\n    a                             z                                b    ");
         System.out.printf(  "\n    %-18s     %-18s     %18s", Double.toString(a), Double.toString(z), Double.toString(b));

         System.out.printf(  "\n    |————————————————————————————*|*———————————————————————————————|    "
                           + "\n    Log(a)                    Log(z)                          Log(b) "
                           + "\n    %-18s     %-18s     %18s\n", Double.toString(loga), Double.toString(logz), Double.toString(logb));
         if (x < z)
         {
         System.out.printf(  "\n                                          *z replaces b*"
                           + "\n                                           %-18s", Double.toString(z));
            b    = z;
            logb = logz;
         }
         else if (z < x) 
         {
         System.out.printf(  "\n           *z replaces a*"
                           + "\n           %18s", Double.toString(z));
            a    = z;
            loga = logz;
         }
      
         if (z == x)
         {
            reachedLimit = true;
         }
      
      System.out.print("\n\n4. ");
   
      pressEnterKeyToContine();
      }
   
      System.out.println("\n\n***   Accuracy of Java's type double has been reached   ***");

      System.out.println("\n\n      Searched for: Log[" + base + "](" + subjectString + ") = x \n");
   
      if (baseChange)
      {
          if (exp != 0)
         {
            System.out.println(  "\n      Log(" + x + ") + " + exp + " = " + (logz + exp));      
         }
         else
         {
            System.out.println(  "\n      Log(" + x + ") = " + (logz));      
         }     
         
            System.out.printf( "\n\n      Log(%-18s) = ", xtemp); System.out.print( (logz + exp) / Math.log10(base));      
            System.out.printf(   "\n      ———————————————————————"
                               + "\n      Log(%-18s)\n\n", Double.toString(base));
      }  

 
      System.out.print("Print Java Math Answer? y/n... ");
      String temp = keyboard.next();
      
      if (temp.charAt(0) == 'y')
      {
         printJavaMath(base, xOriginal, ln);   
      }
      
   }

   public static void printJavaMath(double base, double x, boolean ln)
   {
      double log = 1;
      
      if (ln)
      {   
         log = Math.log(x);
         System.out.print("\n Log[" + base + "](" + x +  ")"
   
                      + "\n\n Java's internal Natural Log function:"
                        + "\n Math.log(" + x + ") = " + log + "\n\n");
      }
      else
      {
         log = Math.log10(x) / Math.log10( base);
         System.out.print("\n Log[" + base + "](" + x + ")"
   
                      + "\n\n Java's internal Common Log function:"
                      + "\n\n Math.log10(" + x + ")       = " + log 
                        + "\n ————————————————————————" 
                        + "\n Math.log10(" + base + ")\n\n");
      }
   }


   private static void pressEnterKeyToContine()
   { 
      System.out.println("Press Enter key to continue...");
      try
      {
         System.in.read();
      }  
      catch(Exception e)
      {
      }  
   }

}
