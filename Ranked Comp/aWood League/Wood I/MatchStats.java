/* ***************************************
  @author Kirishanth Pirathapan
  @SID       230612008
  @date      26 September 2023
  @version   1

    A program that prints my initials (KP)
    in big letters made out of small ones.
   ****************************************/

   class initials
   {
       public static void main (String [] a)
       {
           printKP();
           
           return;
           
       } // END main
       
       // Print a large letter P using P characters
       //
       public static void printP ()
       {
            System.out.println("PPPPPP");
            System.out.println("P    P");
            System.out.println("PPPPPP");
            System.out.println("P");
            System.out.println("P");
            System.out.println("P");
            System.out.println();
           
            return;
           
       } // END printP
   
       // Print a large letter K using K characters
       //
       public static void printK ()
       {
            System.out.println("K  KK");
            System.out.println("K KK");
            System.out.println("KK");
            System.out.println("K KK");
            System.out.println("K  KK");
            System.out.println();
           
            return;
           
       } // END printK
       //
       public static void printKP ()
       {
            printK();
            printP();
           
            return;
           
       } // END printKP
   
   } // END class initials
   