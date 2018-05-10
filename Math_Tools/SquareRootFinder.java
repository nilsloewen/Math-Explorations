package Math_Tools;

import java.util.Scanner;

public class SquareRootFinder	 
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);

// Introduction
      System.out.print("\n" + emDash(51) + "\nNils Loewen's Square Root finder:\n" 
                        + "Program to find Square Root of any* positive number \n"
                        + "   *limited to Java's number type double:           \n\n" 

                        + "   0  <  (2 - 2^52) * 2^1023                        \n"
                        + "   0  <  " + Double.MAX_VALUE +                    "\n\n\n"


                        + "The Babylonian Method is a recursive equation:      \n\n"

                        + "      BetterGuess  =  BestGuess  +    x             \n"
                        + "                                   " + emDash(8) + "\n"
                        + "                                   BestGuess        \n" 
                        + "                     " +  emDash(24) +             "\n" 
                        + "                                 2                  \n\n"

                        + "Where:               x = number to find square root \n"
                        + "                Guess = 'Best Guess' starting point \n"
                        + "         BetterGuess = 'Guess' for next time around \n\n"
   
                        + emDash(51) +                                        "\n\n"


// Interact
                        + "Enter number (double) to find Square Root of:       \n\n"
   
                        + "                        x  =  ");

      double x = keyboard.nextDouble();
      double bestGuess = 1; //Double.MIN_VALUE;

      if (x <= 0)
      {
         System.out.println("&^#ERROR%!#$!# Go play with your imaginary friends!\n");
         System.exit(0);   
      }


// 'Best Guess' Find Nearest Perfect Square
      
      for (double j = 0; j < bestGuess; j++) 
      {
         double distanceBelow = 0;
         double distanceAbove = 0;
         
         if (Math.pow(bestGuess, 2) < x 
           && Math.pow(bestGuess + 1, 2) > x)
         {


            if (Math.pow(bestGuess, 2) <= x) 
            {
               distanceBelow = x - Math.pow(bestGuess, 2);
            } 
      
            if (Math.pow(bestGuess + 1, 2) > x) 
            {
               distanceAbove = Math.pow(bestGuess + 1, 2) - x;
            }

            bestGuess = (distanceBelow > distanceAbove) ? bestGuess : (bestGuess + 1);
            break;
         }
         if (x == 1)
            break;   
         bestGuess++;
      }      

      System.out.printf("\n... Finding Nearest Perfect Square ...\n");
      System.out.printf("\n\n       %16.0f^2  =  %-16.0f", bestGuess, Math.pow(bestGuess, 2));
      System.out.print( "\n\n                      x    =  " + x);
      System.out.printf("\n\n       %16.0f^2  =  %-16.0f", bestGuess + 1, Math.pow(bestGuess + 1, 2));
      System.out.printf("\n\n\n   Nearest Perfect Square  =  %-16.0f\n", Math.pow(bestGuess, 2));
      System.out.printf("    \n                bestGuess  =  %-16.0f\n\n", bestGuess);
      System.out.printf(emDash(51) + "\n\n");   



// Cursions &  Recursions

      for (int k = 1; k < 100; k++)
       {
                  bestGuess = babylonianSQRTMethod(x, bestGuess);
         double betterGuess = babylonianSQRTMethod(x, bestGuess);
   
         System.out.println("After " + k + " Iterations: BetterGuess = " + bestGuess);
    
         if (bestGuess == betterGuess)   
            break;
      }
   
      System.out.print("\n My square root of " + x + "  is " + bestGuess
                     + "\n  Java's Math.sqrt(" + x + ") is " + Math.sqrt(x) + "\n\n");
   
       
      
   }


// The Actual Math: 
   public static double babylonianSQRTMethod(double x, double bestGuess)
   {

      double betterGuess = (bestGuess + (x / bestGuess))/2;
      return(betterGuess);
   }



// Dasher 
   public static String emDash(int x)
   {
      StringBuilder emDashes = new StringBuilder(x);
      for (int i = 0; i < x; i++)
      {
         emDashes.append("\u2014");
      }
      return emDashes.toString();
   }
}
