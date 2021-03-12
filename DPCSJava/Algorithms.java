/*** Sample Algorithms *******************************************
   This program contains sample algorithms for the 
   International Baccalaureate Computer Science syllabus.
  
   The program demonstrates many algorithms contained in the syllabus,
   as well as some "novel" algorithms appropriate for examinations.
   These examples are NOT intended to show how students would
   write their dossiers.  Rather they demonstrate how algorithms
   might be presented in IB examinations.  
  
   In examinations, algorithms will most likely appear as rather  
   short, single methods (or a few methods) - not as entire programs. 
   Some sections of this program consist of many methods 
   (e.g. the RPN calculator).  Such algorithms are unlikely to appear 
   in their entirety on exams.
  
   Notice there is little or no error handling in this code.
   It illustrates functional algorithms, not "good" programming 
   techniques.  The code should be clear and easily readable, and 
   follow the standards outlined in the JETS section of the syllabus.
 
   The Java code has been compiled and run successfully 
   under Sun's Java SDK versions 1.3 and 1.4.
 
 ********************************************************************/

import java.io.*;

public class Algorithms
{  public static void main(String[] args)
   {  new Algorithms();
      System.exit(0);
   }

   public Algorithms()
   {
      char choice = ' ';
      do
      {  output("Please read comments in source code before running.");
         output("----- Standard Sorting and Searching -----");
         output("1 - Selection Sort A");
         output("2 - Selection Sort B");
         output("3 - Bubble Sort A");
         output("4 - Bubble Sort B");
         output("5 - QuickSort");
         output("6 - Sequential Search");
         output("7 - Binary Search Iterative");
         output("8 - Binary Serach Recursive");
         output("----- Other Algorithms -------------------");
         output("A - Runtime Errors");
         output("B - Encrypt");
         output("C - Decimal to Binary");
         output("D - Insertion Sort");
         output("E - Binary Search");
         output("F - Round Units");
         output("G - Sort and Remove Duplicates");
         output("H - Valid Pin");
         output("I - Mystery");
         output("J - RPN Calculator");
         output("K - Truth Table");
         output("L - Fractions");
         output("M - Binary Tree");
         output("N - Random Access File");
         output("O - Indexed File - use Random Access File first to make data file");
         output("P - Hashing");
         output("Q - Dinner - class hierarchy");
         output("X - Exit");
         choice = inputChar("Choice:");
         if (choice >'Z') { choice = (char)(choice - 32);}    // change to UPPER CASE
         if (choice >='1' && choice <='5')
         {  int[] nums = {5,3,9,7,1,6,4,8};
            System.out.print("Before sorting:");
            for(int p=0; p < 8; p=p+1){ System.out.print(nums[p]+" ");}
            System.out.println();
            if (choice =='1') {selectionSortA(nums,8);}
            else if (choice =='2') {selectionSortB(nums,8);}
            else if (choice =='3') {bubbleSortA(nums,8);}
            else if (choice =='4') {bubbleSortB(nums,8);}
            else if (choice =='5') {quickSort(nums,0,7);}
            System.out.print("After sorting: ");
            for(int p=0; p < 8; p=p+1){ System.out.print(nums[p]+" ");}
            System.out.println();
         }
         else if (choice >='6' && choice <='8')
         {  int[] nums = {10,20,30,40,50,60,70,80};
            output("The array contains 10,20,30,...,70,80");
            int target = inputInt("Type a number to search for:");
            int pos = -1;
            if (choice =='6') { pos = sequentialSearch(target,nums,8);}
            else if (choice =='7') { pos = binarySearchA(target,nums,8);}
            else if (choice =='8') { pos = binarySearchB(target,nums,0,7);}
            if (pos >= 0)
            {  output("Found in position " + pos); }
            else
            {  output("Not found"); }
         }
         else if (choice =='A') { runTimeErrors(); }
         else if (choice =='B') { encrypt(); }
         else if (choice =='C') { tryDecToBin(); }
         else if (choice =='D') { tryInsertionSort(); }
         else if (choice =='E') { tryBinarySearch(); }
         else if (choice =='F') { tryRoundUnits(); }
         else if (choice =='G') { trySortAndRemoveDuplicates(); }
         else if (choice =='H') { tryValidPin(); }
         else if (choice =='I') { mystery(); }
         else if (choice =='J') { rpnCalc(); }
         else if (choice =='K') { truthTable(); }
         else if (choice =='L') { fractions(); }
         else if (choice =='M') { binaryTree(); }
         else if (choice =='N') { employees(); }
         else if (choice =='O') { tryIndex(); }
         else if (choice =='P') { tryHashing(); }
         else if (choice =='Q') { new Dinner(); }
         input("-- press [Enter] to continue --");
      } while (choice != 'X');

   }

//=============================================================//

   /*** Standard Sorting and Searching ************************/

   public void selectionSortA(int[] nums,int size)
   {
      //  Sorts ARRAYOFINT in descending order by finding
      //  the largest element and swapping it into position 1,
      //  then finding the next largest and swapping intoo 2, etc.

      int first, current, least, temp;

      for(first = 0; first < size; first = first + 1)
      {
         least = first;
         for(current = first+1; current < size; current = current + 1)
         {  if (nums[current] > nums[least])
            {  least = current; }
         }
         temp = nums[least];
         nums[least] = nums[first];
         nums[first] = temp;
      }
   }

   public void selectionSortB(int[] nums,int size)
   {
      //  Same as version A, but sorts in ascending order

      int first, current, least, temp;

      for(first = 0; first < size; first = first + 1)
      {
         least = first;
         for(current = first+1; current < size; current = current + 1)
         {  if (nums[current] < nums[least])
            {  least = current; }
         }
         temp = nums[least];
         nums[least] = nums[first];
         nums[first] = temp;
      }
   }

   public void bubbleSortA(int[] nums, int size)
   {
      //  Sorts into descending order, by comparing direct neighbours and
      //  swapping them if they are out of order.  This performs NUMVALUES
      //  passes.  LAST is decreasing, because a sorted sub-list builds
      //  up at the bottom of the array.

      int last, current, temp;

      for(last = size-1; last > 0; last = last - 1)
      {  for(current = 0; current < last; current = current + 1)
         {  if (nums[current] < nums[current + 1])
            {
               temp = nums[current];
               nums[current] = nums[current+1];
               nums[current+1] = temp;
            }
         }
      }
   }

   public void bubbleSortB(int[] nums, int size)
   {
      //  An ascending bubble sort, but this does not perform a
      //  specific number of passes.  Instead, it stops if an entire pass
      //  completes WITHOUT any swaps occurring.

      int current, temp;
      boolean done;

      do
      {
         done = true ;
         for(current = 0; current < size-1 ; current = current + 1)
         {  if (nums[current] > nums[current + 1])
            {
               temp = nums[current];
               nums[current] = nums[current+1];
               nums[current+1] = temp;
               done = false;
            }
         }
      } while (!done);
   }

   public void quickSort(int[] nums, int start, int finish)
   {
      // A recursive procedure to sort an array into ascending order
      // using the quick-sort algorithm.

      int mid, left, right, temp;

      left = start;
      right = finish;
      mid = nums[(start + finish)/2];  // pivot element chosen from
                                       // the middle of the list
      while (right > left)
      {  while (nums[left] < mid)
         {  left = left + 1;  }
         while (mid < nums[right])
         {  right = right - 1;  }
         if (left <= right)
         {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left = left + 1;
            right = right - 1;
         }
      }
      if (start < right)
      {  quickSort(nums, start, right);  }
      if (left < finish)
      {  quickSort(nums, left, finish); }
   }

   public int sequentialSearch(int target, int[] nums, int size)
   {
      boolean found = false;
      int place = 0;

      while (place < size && !found)
      {
         if (target == nums[place])
         {  found = true; }
         else
         {  place = place + 1; }
      }

      if (found)
      {  return place; }
      else
      {  return -1;  }
   }

   public int binarySearchA(int target, int[] nums, int size)
   {
      //  An iterative binary search.  Size = size of num array.
      //  If found, returns position.  Else returns -1.

      int middle, low, high;
      boolean found = false;

      low = 0;
      high = size-1;
      middle = -1;

      while (high >= low && !found)
      {  middle = (low + high) / 2;
         if (target < nums[middle])
         {  high = middle - 1; }
         else if (target > nums[middle])
         {  low = middle + 1;  }
         else
         {  found = true;  }
      }

      if (found)
      {  return middle; }
      else
      {  return -1;  }
   }

   public int binarySearchB(int target, int[] nums, int low, int high)
   {
      //  A recursive binary search.  Start with low = 0, high = nums.length-1
      //  If found, returns position.  Else returns -1.

      int middle = (low+high)/2;

      if (low>high)
      {  return -1; }
      else if (target == nums[middle])
      {  return middle; }
      else if (target < nums[middle])
      {  return binarySearchB(target, nums, low, middle - 1); }
      else
      {  return binarySearchB(target, nums, middle+1, high); }
   }



//=============================================================//

/*** Runtime Errors **************************************************

   Some inputs will cause ERRORS in this algorithm.
   Determine what inputs might cause errors,
   and correct the algorith to HANDLE these bad inputs properly,
   without run-time exceptions.
 *********************************************************************/

   public void runTimeErrors()
   {
      String name = input("What is your name?");
      String abbrev = name.substring(0,3);
      output( "An abbreviation for your name is " + abbrev );

      int num = inputInt("How many children do you have?");
      int total = 0;
      for (int c=0; c < num; c = c+1)
      {
         int weight = inputInt("Type the weight of child #" + c + ":");
         total = total + weight;
      }
      double average = total / num;
      output("The average weight of your children is " + average);

      String born = input("What month were you born?");
      String[] months = {"Jan","Feb","Mar","Apr","May","Jun",
                         "Jul","Aug","Sep","Oct","Nov","Dec"};
      int m = 0;
      while (!months[m].equals(born))
      { m = m+1; }
      output("That month is # " + m);
   }
/*********************************************************************
   Possible answers for error situations:
    name : any input shorter than 3 letters causes an error in substring
    average : If num is zero, the calculation of average causes
                a division by zero error.
              The calculation of average is usually incorrect, as the
                division operator is polymorphic, and performs an integer
                division for the two integer operands, throwing away
                any decimals in the answer.  But this is a logic error,
                not a run-time error.
    born : The search loop only finds a month if the user types 3 letters.
            If they type the whole name, or misspell the abbreviation,
            the search loop will run past 11 and generate an error.
            This should not be confused with the logic error which
            is caused by the zero-based indexing of the array -
            this algorithm calls "Jan" month # 0.

   Appropriate corrections involve using an if command to prevent
     execution of dangerous code .  For example:

       if (num>0)
       { double average = total / num;
         output("The average weight of your children is " + average);
       }

   It is also appropriate to use good USER INSTRUCTIONS (prompts)
      so the user knows what is expected.  This is especially useful
      when inputting the name of a month.
   Another possibility is error-correction - e.g. using substring
      to extract the first 3 letters of the month name when
      the user types the whole word.
 *************************************************************************/

//=======================================================================//

/*** Encrypt *************************************************************
   Show what ENCRYPT does to each of the following strings:
           "test"           "Bobo"
 *************************************************************************/
   public void encrypt()
   {
      String source,cipher;
      char oldChar, newChar;

      output("Type in a message, and it will be encrypted.");
      source = input("");
      cipher  =  "";
      for (int c=0; c<source.length(); c=c+1 )
      {
         oldChar = source.charAt(c);
         newChar = ' ';
         if ( (oldChar >= 'a') && (oldChar <= 'z') )
         {
            int ascii = (int)oldChar;
            int pos = ascii - (int)'a';
            int code = ((int)'z') - pos;
            newChar = (char)code;
         }
         else
         {
            newChar = oldChar;
         }
         cipher = newChar + cipher;
      }
      output(cipher);
   }
/*************************************************************************
   Notice that only small letters are encrypted -
    capital letters are not changed.
 *************************************************************************/

//=======================================================================//

/*** Decimal to Binary ***************************************************
  
   Convert a decimal integer to binary (returned as a string).
   For negative numbers, returns "negative".
 *************************************************************************/

   public void tryDecToBin()
   {
      output( "Binary = " + decToBin( inputInt("Type an integer:") ) );
   }

   public String decToBin(int num)
   {  String answer = "";
      if (num < 0)
      { answer = "negative"; }
      else if (num == 0)
      { answer = "0"; }
      else
      {  answer = "";
         while (num > 0)
         {  if (num % 2 == 0)
            {  answer = "0" + answer; }
            else
            {  answer = "1" + answer; }
            num = num / 2;
         }
      }
      return answer;
   }

//=======================================================================//

/*** Insertion Sort ***************************************************

   Takes each element, and moves it upward through the list until
   reaching the correct position, stopping when it "bumps" agains
   a smaller value. The resulting list is in ascending order.
 **********************************************************************/
   public void tryInsertionSort()
   {
      int[] nums = {15,7,20,13,25,18};
      for (int c=0; c < nums.length; c = c+1)
      {  output(c + " : " + nums[c]);  }
      output("Sorting");
      insertionSort(nums);
      for (int c=0; c < nums.length; c = c+1)
      {  output(c + " : " + nums[c]);  }
   }

   public void insertionSort( int[] nums)
   {
      for (int newest = 1; newest < nums.length; newest++)
      {  int newValue = nums[newest];
         int current = newest;
         while ( (current > 0) && (nums[current - 1] > newValue) )
         {  nums[current] = nums[current - 1];
            current = current - 1;
        }
         nums[current] = newValue;
      }
   }

//=======================================================================//

/*** Binary Search ****************************************************

   in a sorted array (iterative, non-recursive version)
   Returns the position of the desired string.
   Returns -1 if the string is not found.
 **********************************************************************/

   public void tryBinarySearch()
   {
      String[] names = {"Alpha","Beta","Epsilon","Delta",
                        "Gamma","Lambda","Mu","Omega"};
      output("The list is:");
      for (int c=0; c < names.length; c = c+1)
      {  output( c + " : " + names[c]); }
      int lambda = binarySearch(names,"Lambda");
      output("Lambda found in position " + lambda);
      int camel = binarySearch(names,"Camel");
      output("Camel found in position " + camel);
      int omega = binarySearch(names,"Omega");
      output("Omega found in position " + omega);
   }


   public int binarySearch(String[] list,String find)
   {
      int mid = 0;
      int low = 0;
      int high = list.length-1;
      boolean found = false;

      while ( !found && (high >= low))
      {  mid = (low + high) / 2;
         if ( find.compareTo(list[mid]) < 0 )
         {  high = mid - 1; }
         else if (find.compareTo(list[mid]) > 0)
         {  low = mid + 1;  }
         else
         {  found = true; }

      }
      if (!found)
      {  return -1; }
      else
      {  return mid; }
   }

//=======================================================================//

/*** Round Units *********************************************************

   Converts a number with standard SI prefix T,G,M,k,c,m,u,n rounded to
   an integer multiple of the unit. For example,
     ROUNDUNITS(1234567890,"M") returns "1235 M"
     ROUNDUNITS(1234567890,"G") returns "1 G"
     ROUNDUNITS(0.02,"m")       returns "20 m"
     ROUNDUNITS(1000,"M")       returns "0 M"
   This conversion uses powers of 10, not powers of 2, e.g. k = 1000
   not k = 1024. For printing convenience, 'u' represents micro (10^-6).
 *************************************************************************/

   public void tryRoundUnits()
   {
      output( 1.23 + " = " + roundUnits(1.23,'m') );
      output( 1.23 + " = " + roundUnits(1.23,'c') );
      output( 123456789 + " = " + roundUnits(123456789,'M') );
   }

   public String roundUnits(double num, char unit)
   {
      String units = "TGMKcmun";
      double[] values = new double[8];
      int x,p;
      double v = 1000;
      String result = "";

      for(x = 3; x >= 0; x = x-1)
      {
         values[x] = v;
         v = v * 1000;
      }

      values[4] = 0.01;
      v = 0.001;
      for(x = 5; x < 8; x = x+1)
      {  values[x] = v;
         v = v / 1000;
      }

      for(x = 0; x < 8; x = x+1)
      {
         if (units.charAt(x) == unit)
         {  v = Math.round(num/values[x]);
            result = v + " " + unit;
         }
      }
      return(result);
   }

//=======================================================================//

/*** Sort and Remove Duplicates ******************************************

   Sort and remove duplicate entries from a linear array.
   Inputs names until 'xxx' is typed. CLEANUP sorts the LIST, and then
   removes any duplicates.  Returns a new copy of the array, but
   shorter if items were removed.
 *************************************************************************/

   public void trySortAndRemoveDuplicates()
   {
      String[] names = new String[5];
      output("Type 5 names:");
      for (int c = 0; c < 5 ; c = c + 1)
      {  names[c] = input(c + ":");  }
      names = sortAndRemoveDuplicates(names);
      output("After removing duplicates and sorting:");
      for (int c = 0; c < names.length; c = c + 1)
      {  output(c + " : " + names[c]);  }
   }

   public String[] sortAndRemoveDuplicates(String[] list)
   {  if (list.length == 0)
      { return(list); }

      //---- Bubble Sort ---------------------------------------------
      boolean swapped = true;
      int     pass = 1;
      do
      {  swapped = false;
         for(int x = 0; x < list.length - pass; x++)
         {
            if (list[x].compareTo(list[x + 1]) > 0)
            {
               String temp = list[x];        // 3-way swap
               list[x] = list[x + 1];
               list[x+ 1] = temp;
               swapped = true;               // swapped, need another pass
            }
         }
         pass = pass + 1;
      } while (swapped);                     // Quits if no swaps occurred

      //---- Count non-duplicates -------------------------
      int unique = 1;
      for (int x=0; x < list.length-1; x = x+1)
      {  if (!list[x].equals(list[x+1]))        // counts if this item is
         { unique = unique + 1;}                //  different from next item
      }

      //---- Copy unique items into new results array -----
      String[] results = new String[unique];
      int p = 0;
      for (int x=0;x < list.length-1; x = x+1)
      {  if ( !list[x].equals(list[x+1]) )
         {  results[p] = list[x];
            p = p+1;
         }
      }
      results[p] = list[list.length-1];         // last item always counts
      return results;

   }

//=======================================================================//

/*** Check-Digit Validation *********************************************

   This algorithm validates a decimal integer PIN (Personal
   Identification Number) according to the rule:

   a PIN number is valid if the sum of all the digits has the
   same last digit as the product of all the non-zero digits.

   For example, 64 is not valid, because 6*4 = 24 which ends in a 4,
   but 6+4=10 which ends in 0. However, it is easy to turn 64 into a
   valid PIN number, by adding 1s (ones) until the sum and product
   match. Thus, 116141 is valid, as the sum of the digits is 14, and
   the product is 24. Since zeroes do not change the product or the
   sum, 1016010401 is also valid.
 *************************************************************************/

   public void tryValidPin()
   {
      int pin = 0;
      do
      {
         pin = inputInt("Pin:");
         output( validPin(pin) );
      } while (!validPin(pin) && pin>0);
   }

   public boolean validPin(int pin)
   {
       int sum = 0;
       int product = 1;

      while (pin>0)
      {
         int digit = pin % 10;
         sum = sum + digit;
         if (digit != 0)
         {
             product = product * digit;
         }
         pin = pin / 10;
      }
      if ( (sum % 10) == (product % 10) )
      { return true; }
      else
      { return false; }
   }

//=======================================================================//

/*** Mystery *************************************************************

   What is printed by SHOW the first time, and what the second time?
 *************************************************************************/
   int size;
   int[][] nums = new int[4][4];

   public void mystery()
   {  start();
      output("- Original -");
      show();
      change();
      output("- Changed -");
      show();
   }

   public void start()
   {
      int row,col,count;
      size = 4;
      count = 0;
      for (row = 0; row < size; row = row + 1)
      {  for (col = 0; col < size; col = col + 1)
         {  count = count + 1;
            if (row < col)
            {  nums[row][col] = row; }
            else
            {  nums[row][col] = count;}

         }
      }
   }

   public void show()
   {
      int row,col,count;
      for (row = 0;row < size; row = row + 1)
      {  for (col = 0; col < size; col = col + 1)
         {  System.out.print(nums[row][col] + "\t"); }
         System.out.println("");
      }
   }

   public void change()
   {
     int row,col,temp,half;
     half = size / 2;
     for (col = 0; col < half; col = col + 1)
     {
        for (row = 0; row < size; row = row + 1)
        {
           temp = nums[row][col];
           nums[row][col] = nums[row][size - 1 - col];
           nums[row][size - 1 - col] = temp;
        }
     }
   }

//=======================================================================//

/*** RPN Calculator ****************************************************

   A Reverse Polish Notation calculator that uses a dynamic stack.
   It uses the value method to convert strings into numbers.
   It uses a Dynamic Stack stored in a Linked-List.
 ***********************************************************************/

   public double value(String s)
   {
      // Changes a string into the equivalent double value
      // It returns 0 if the conversion causes an error.

      double answer = 0;
      try
      {  answer=Double.valueOf(s.trim()).doubleValue();
      }
      catch (Exception e) {};
      return answer;
   }


   class ListNode         // This inner class is used as a data structure
   {
      double data;
      ListNode next;
   }

   int error;

   ListNode stack = null;

   public void rpnCalc()
   {
      String term;
      double number = 0, answer = 0;
      String[] messages = {"No error",
                           "Division by zero",
                           "Stack underflow",
                           "Memory overflow"};
      error = -1;
      while (error < 0)
      {
         term = input("Next term:");
         if (term.equals("=") )
         {  error = 0;
            answer = pop();
         }
         else if (term.equals("+"))
         {  push(pop() + pop()); }
         else if (term.equals("-"))
         {  push(-1*pop() + pop()); }
         else if (term.equals("*"))
         {  push(pop() * pop()); }
         else if (term.equals("/"))
         {  number = pop();
            if (number == 0)
            {  error = 1; }
            else
            { push(pop()/number); }
         }
         else
         {  push(value(term));  }
      }
      if (error == 0)
      {  output("The result is " + answer); }
      else
      {  output("ERROR : " + messages[error]); }
   }

   public double pop()
   {
      double number;
      if (stack == null)
      {  error = 2;
         number = 0;
      }
      else
      {  number = stack.data;
         stack = stack.next;
      }
      return number;
   }

   public void push(double number)
   {
      ListNode temp = new ListNode();
      if (temp == null)
      {  error = 3; }
      else
      {
         temp.data = number;
         temp.next = stack;
         stack = temp;
      }
   }

//=======================================================================//

/*** Truth Table *********************************************************

   Generate a truth table for a Boolean expression.
   Uses escaped-TAB characters to line up columns.
 *************************************************************************/

   public void truthTable()
   {
      boolean A,B,C,truth;
      output(" A\tB\tC\t(A and not B) or not(B and C)");
      A = false;
      do
      {
         B = false;
         do
         {
            C = false;
            do
            {
               truth = (A && !B) || !(B && C) ;
               output(A + "\t" + B + "\t" + C + "\t" + truth);
               C = !C;
            } while (C);
            B = !B;
         } while (B);
         A = !A;
      }  while (A);
   }

/*************** Sample Output ******************************************

    A       B       C      (A and not B) or not(B and C)
   false   false   false   true
   false   false   true    true
   false   true    false   true
   false   true    true    false
   true    false   false   true
   true    false   true    true
   true    true    false   true
   true    true    true    false

 ************************************************************************/

//========================================================================

/*** Fractions ***************************************************

   An example of using an "inner class" to store several
   data fields - similar to a "record" structure in a
   traditional language.  Notice that methods can return a
   result as a new Fraction, or by changing the values in
   the input parameter object.  In Java, all parameters are
   are passed by value.  If an object is passed as a parameter,
   its value (address) cannot be changed, but the contents
   of the object it points to CAN be changed.

   A better version of this algorithm would prevent the user
   from entering 0 as the bottom of a fraction.
 *****************************************************************/

   class Fraction
   {
      int top;
      int bottom;

      public Fraction(int t, int b)
      {
         top = t;
         bottom = b;
      }
   }

   public void fractions()
   {
      Fraction fa = inputFraction("First fraction:");
      Fraction fb = inputFraction("Second fraction:");
      Fraction fc = addFractions(fa,fb);
      reduce(fc);
      output("Sum = " + fc.top + "/" + fc.bottom);
   }

   public Fraction inputFraction(String prompt)
   {
      output(prompt);
      return new Fraction(inputInt(" Top = "), inputInt(" Bottom = ") );
   }

   public Fraction addFractions(Fraction fa, Fraction fb)
   {
      int top = fa.top * fb.bottom + fa.bottom * fb.top;
      int bottom = fa.bottom * fb.bottom;
      return new Fraction( top, bottom );
   }

   public void reduce(Fraction frac)
   {  
      if (frac.top != 0)
      {  int f = frac.top;
         while ( (frac.top % f != 0) || (frac.bottom % f != 0) )
         {
            f = f - 1;
         }
         frac.top = frac.top / f ;
         frac.bottom = frac.bottom / f ;
      }   
   }

//=======================================================================//

/*** Binary Tree *********************************************************

   Reads strings from the keyboard, in any order. Each word is
   inserted into the binary search tree in the proper position.
   Then an in-order traversal prints the words in alphabetical order.
   This concept could be used to sort a text file, if the input came
   from a text file and the output went back into the same file.
 *************************************************************************/

   class TreeNode
   {
      String data;
      TreeNode leftChild;
      TreeNode rightChild;

      public TreeNode(String info)
      {
         data = info;
         leftChild = null;
         rightChild = null;
      }
   }

   TreeNode root = null;

   public void binaryTree()
   {
      makeTree();
      showTree(root);
   }

   public void makeTree()
   {
      root = null;
      String word = "";
      do
      {
         word = input("Type a word (xxx to quit):");
         if (!word.equals("xxx"))
         {  addTreeNode(word);  }
      } while(!word.equals("xxx"));
   }

   public void addTreeNode(String word)
   {
      boolean done = false;
      if (root == null)
      {
         root = new TreeNode(word);
         done = true;
      }

      TreeNode temp = root;
      while (!done)
      {
         if (temp.data.equals(word))
         {  done = true;  }             // word found, so don't add
         else if (word.compareTo(temp.data)<0)
         {
            if (temp.leftChild == null)
            {  temp.leftChild = new TreeNode(word);
               done = true;
            }
            else
            {  temp = temp.leftChild;  }
         }
         else
         {
            if (temp.rightChild == null)
            {  temp.rightChild = new TreeNode(word);
               done = true;
            }
            else
            {  temp = temp.rightChild;  }
         }
      }
      return;
   }

   public void showTree(TreeNode here)
   {
      if (here == null)
      {  return;  }
      else
      {
         showTree(here.leftChild);
         output(here.data);
         showTree(here.rightChild);
      }
   }

//=======================================================================//

/*** Random Access File *********************************************

   Creates a RandomAccessFile with names and salaries.
   Records are added to the file in order as they are input.
   Then a bubble sort exchanges records to put the salaries in order.
   At the end, it prints the the file.
 ********************************************************************/

   public void employees()
   {
      inputEmployees();
      sortEmployees();
      outputEmployees();
   }

   public void clearFile()
   {
      try
      {
         RandomAccessFile file = new RandomAccessFile("employees.dat","rw");
         file.setLength(0);
         file.close();
      }
      catch (IOException e) { output(e.toString()); }
   }

   public void writeName(long record,String name)
   {  try
      {  RandomAccessFile file = new RandomAccessFile("employees.dat","rw");
         if (name.length() > 40)
         { name = name.substring(0,40);}
         file.seek(50*record);
         file.writeUTF(name);
         file.close();
      }
      catch(IOException e) { output(e.toString()); }
   }

   public void writeSalary(long record,double salary)
   {
      try
      {
         RandomAccessFile file = new RandomAccessFile("employees.dat","rw");
         file.seek(50*record+42);
         file.writeDouble(salary);
         file.close();
      }
      catch (IOException e) { output(e.toString()); }
   }

   public long countRecords()
   {
      try
      {
         RandomAccessFile file = new RandomAccessFile("employees.dat","r");
         long records = file.length() / 50;
         file.close();
         return records;
      }
      catch (IOException e) { return -1; }
   }

   public String readName(long record)
   {
      String result=null;
      try
      {  RandomAccessFile file = new RandomAccessFile("employees.dat","r");
         if (record < countRecords())
         {
            file.seek(50*record);
            result = file.readUTF();
         }
         else
         {
            result = null;
         }
         file.close();
      }
      catch(IOException e) { output(e.toString()); }
      return result;
   }

   public double readSalary(long record)
   {
      double result=-1;
      try
      {  RandomAccessFile file = new RandomAccessFile("employees.dat","r");
         if (record < countRecords())
         {
            file.seek(50*record+42);
            result = file.readDouble();
         }
         else
         {
            result = -1;
         }
         file.close();
      }
      catch(IOException e) { output(e.toString()); }
      return result;
   }

   public void inputEmployees()
   {
      clearFile();
      long record = 0;
      String name = "";
      double salary = 0;
      while (salary >= 0 )
      {
         name = input("Name:");
         salary = inputDouble("Salary (-1 to quit):");
         if (salary >= 0)
         {
            writeName(record,name);
            writeSalary(record,salary);
            record = record + 1;
         }
      }
   }

   public void sortEmployees()
   { try
     {
      long recordCount = countRecords();
      for (long pass = 0; pass < recordCount-1; pass = pass + 1)
      {
         for (long c = 0; c < recordCount-1; c = c + 1)
         {
            String nameA = readName(c);
            double salaryA = readSalary(c);
            String nameB = readName(c+1);
            double salaryB = readSalary(c+1);
            if (salaryB > salaryA)
            {
               writeName(c,nameB);
               writeSalary(c,salaryB);
               writeName(c+1,nameA);
               writeSalary(c+1,salaryA);
            }
         }
      }
     }
      catch (Exception e){output(e.toString());return;}
   }

   public void outputEmployees()
   {
      for (long c = 0; c < countRecords(); c = c+1)
      {
         String name = readName(c);
         double salary = readSalary(c);
         output(name + "\t" + salary);
      }
   }

//=======================================================================//

/*** Fully Indexed File ***********************************************

   The class IndexedFile creates a FULL INDEX for the NAME field
   in the RandomAccessFile employees.dat.  There is an entry in the
   KEY array for each record in the file.  The index is created when
   the class is instantiated.  This is an oversimplified example,
   with a fixed-size array.  It also should permit adding new
   records to the file, but this is not included.  It also assumes
   the file is named "employees.dat" and records have 2 fields:
   a 40-character UTF name and a double salary.
   The sorting algorithm is inefficient.

   The getSalary method retrieves the salary by
   searching for an employee's name in the key[] array,
   following the matching pos[] pointer, and retrieving
   the salary from the file.
 *********************************************************************/

   class IndexedFile
   {
      String[] key = new String[1000];
      long[] pos = new long[1000];
      int size = 0;

      public IndexedFile()
      {
         // read names into key[] array
         try
         {
            RandomAccessFile file = new RandomAccessFile("employees.dat","r");
            long records = file.length() / 50;
            for (long c=0; c < records; c = c+1)
            {
               file.seek(c*50);
               key[size] = file.readUTF();
               file.seek(c*50+42);
               pos[size] = c;
               size = size + 1;
            }
            file.close();
         }
         catch (IOException e){ output(e.toString()); }

         // sort key[] array, moving pos[] entries to
         //  stay matched with key[] names
         for (int pass = 0; pass < size; pass = pass + 1)
         {
            for (int c = 0; c < size-1; c = c + 1)
            {
               if (key[c].compareTo(key[c+1])>0)
               {
                  String tempKey = key[c];
                  long tempPos = pos[c];
                  key[c] = key[c+1];
                  pos[c] = pos[c+1];
                  key[c+1] = tempKey;
                  pos[c+1] = tempPos;
               }
            }
         }
      }

      public double getSalary(String name)
      {
         double salary = -1;
         int lo = 0;
         int hi = size-1;
         int found = -1;
         while ( (hi >= lo) && (found < 0) )
         {
            int mid = (lo + hi) / 2;
            if ( key[mid].equals(name) )
            {  found = mid; }
            else if ( name.compareTo(key[mid]) < 0)
            {  hi = mid - 1; }
            else
            {  lo = mid + 1; }
         }
         if (found >= 0)
         {  try
            {
               RandomAccessFile file = new RandomAccessFile("employees.dat","r");
               file.seek(pos[found]*50+42);
               salary = file.readDouble();
               file.close();
            }
            catch(IOException e) { output(e.toString()); }
         }
         return salary;
      }
   }

   public void tryIndex()
   {
      String name;
      IndexedFile allNames = new IndexedFile();
      output("The file contains these names:");
      for(int x=0; x < allNames.size; x=x+1)
      {  output(allNames.key[x]); }
      do
      {
         name = input("Type a name (xxx to quit):");
         if (!name.equals("xxx"))
         {
            IndexedFile iFile = new IndexedFile();
            double salary = iFile.getSalary(name);
            if (salary>=0)
            {  output( "Salary = " + salary ); }
            else
            {  output( "Not found" ); }
         }
      } while (!name.equals("xxx"));
   }


//=======================================================================//

/*** Hashing *************************************************

    Creates random "words" by putting together random letters.
    Stores the words in a Hash-Table.  The Hash Code is
    calculated from the ASCII codes of the characters in the
    word.  If the corresponding position is full, the putHash
    method searches sequentially for the next free position
    and stores the word there.
 *************************************************************/

   public void tryHashing()
   {
      String[] data = new String[13];      // primes are LUCKY
      for (int c=0; c < 13; c = c+1)
      {  data[c] = ""; }
      for (int c=0; c < 10; c = c+1)
      {
         String word = randomConsonant() + randomVowel() +
                randomConsonant() + randomConsonant() + randomVowel();
         hashPut(data,word);
      }
      for (int c=0; c < 13; c = c+1)
      {  output(c + " : " + data[c]); }
   }

   public String randomConsonant()
   {
      String consonants = "BCDFGHJKLMNPQRSTVWXZ";
      int count = consonants.length();
      int random = (int)(Math.random()*count);
      return consonants.substring(random,random+1);
   }

   public String randomVowel()
   {
      String vowels = "AEIOUY";
      int count = vowels.length();
      int random = (int)(Math.random()*count);
      return vowels.substring(random,random+1);
   }

   public void hashPut(String[] data,String word)
   {
      int pos = hashCode(word);
      int full = 0;
      while ( (!data[pos].equals("")) && (full < 13) )
      {
         full = full + 1;  // searching for empty space
         pos = pos+1;
         if (pos >= 13)
         {  pos = 0; }     // wrap-around at end of array
      }
      if (full < 13)
      {  data[pos] = word; }
      else
      {  output("Data array is FULL"); }
   }

   public int hashCode(String word)
   {
      int code = word.length();
      if (word.length()>0)
      {  code = code + 7*word.charAt(0); }
      if (word.length() > 1)
      {  code = code + 5*word.charAt(1); }
      if (word.length() > 2)
      {  code = code + 3*word.charAt(2); }
      return code % 13;
   }

//=======================================================================//

/*** Dinner Tables - class decomposition ********************************
   
   Dinner is used to plan the seating of guests at tables for
   a formal dinner party.  It uses several classes.
   Some error trapping has been done, but some run-time errors
   can still occur.
   
   - Class Decomposition -

   In Object-Oriented programming (e.g. Java), we try to use
   CLASS decomposition to structure the solution.  This decomposition
   should be similar in both the design and implementation sections.
   In this problem, the identifiable objects are:

      Guests
      Tables
      Dining-room (a list of tables)
      Dinner event

   They are hierarchically related like this:

      Dinner
         TableList
            Table, Table, Table
         GuestList

 ************************************************************************/   
   
   class Dinner
   {
      GuestList guests ;
      TableList tables ;

      public Dinner()
      {
         inputGuests();
         output("-------");
         inputTables();
         output("-------");

         String done;
         do
         {
            assignTables();
            output("-------");
            output("- Guests -\n" + guests.toString());
            output("- Tables -\n" + tables.toString());
            done = input("Are you finished (Y/N)?");
         } while (done.equals("N") || done.equals("n"));
      }

      public void inputGuests()
      {
         int maxGuests = inputInt("How many guests maximum?");
         guests = new GuestList(maxGuests);

         String newName = "";
         output("Type the guest names (you can still add more later)");
         do
         {
            newName = input("Name (or QUIT):");
            if (!newName.equals("QUIT"))
            {  guests.add(newName); }
         }  while (!newName.equals("QUIT"));
      }

      public void inputTables()
      {  int maxTables = inputInt("How many tables?");
         int maxSeats  = inputInt("How many seats at each table?");

         tables = new TableList(maxTables, maxSeats);
      }

      public void assignTables()
      {
         output("Assigning Tables");
         String name;
         int table;
         do
         {  name = input("Name of guest (or QUIT):");
            if ( (guests.find(name) < 0) && (!name.equals("QUIT")))
            {  String addYN = input("Name not found - add it (Y/N)");
               if (addYN.equals("Y"))
               { guests.add(name);}
            }
            if (guests.find(name)>=0)
            {  int max = tables.tables.length - 1;
               table = inputInt("Number of table (0-" + max +"):");
               if ( table >=0 )
               { String result = tables.reserve(name,table);
                 if (result.equals(""))
                 {  guests.assign(name,table);}
                 else
                 {  output( result ); }
               }
            }
         }  while (!name.equals("QUIT"));
      }
   }

   class TableList
   {
      Table[] tables ;    // List of tables

      public TableList(int maxTables, int maxSeats)
      {
         tables = new Table[maxTables];
         for (int c = 0; c < maxTables; c = c+1)
         {  tables[c] = new Table(maxSeats); }
      }

      public String reserve(String name,int tableNum)
      {
         if (tables[tableNum].available() > 0)
         {  tables[tableNum].assign(name);
            return "";
         }
         else
         {  return "Table FULL"; }
      }

      public String toString()
      {
         String result = "";
         for (int t = 0; t < tables.length; t = t+1)
         {  result = result + t + ": " + tables[t].toString() + "\n"; }
         return result;
      }
   }

   class Table
   {
      String[] names;   // names of guests assigned to this table
      int count ;       // number of guests assigned

      public Table(int maxSeats)
      {
         names = new String[maxSeats];
         for (int c = 0; c < maxSeats; c = c+1)
         {  names[c] = "---";  }
         count = 0;
      }

      public boolean assign(String name)
      {
         if (count < names.length)
         {
            names[count] = name;
            count = count + 1;
            return true;
         }
         else
         {
            return false;
         }
      }

      public int available()
      {
         return names.length - count;
      }

      public String toString()
      {
         String result = "";
         for (int c = 0; c < names.length ; c = c + 1)
         {  result = result + names[c] + "  "; }
         return result;
      }
   }

   class GuestList 
   {
      String[] names;      // names of guests
      int[] seating;       // seats assigned
      int count;

      public GuestList(int maxGuests)    // constructor
      {
         names = new String[maxGuests];
         seating = new int[maxGuests];

         count = 0;
      }

      public int find(String name)       // search for a name in names[]
      {  int found = -1;
         for (int c = 0; c < count; c = c+1)
         {  if(names[c].equals(name))
            {  found = c;  }
         }
         return found;                   // return -1 if not found
      }

      public void assign(String name,int tableNum)
      {                                  // assign name to tableNum
         int pos = find(name);
         if (pos >=0 )
         {  seating[pos] = tableNum;  }  // put tableNum into seating[]
      }

      public void add(String name)       // add a new name into names[]
      {
         if (count < names.length)
         {
            names[count] = name;
            seating[count] = -1;         // seat is still unassigned
            count = count + 1;
         }
         else
         {  System.out.println("Guest list is FULL"); }
      }

      public String toString()          // create a string containing
      {  String result = "";            //  all names and seats
         for (int c = 0; c < count; c = c+1)
         {  result = result + names[c] + " at " + seating[c] + "\n"; }
         return result;
      }

   }

//===========================================================
//   IBIO Standard Input and Output
//===========================================================

   static void output(String info)
   { System.out.println(info);   }

   static void output(char info)
   { System.out.println(info);   }

   static void output(byte info)
   { System.out.println(info);   }

   static void output(int info)
   { System.out.println(info);   }

   static void output(long info)
   { System.out.println(info);   }

   static void output(double info)
   { System.out.println(info);   }

   static void output(boolean info)
   { System.out.println(info);   }

   static String input(String prompt)
   {  String inputLine = "";
      System.out.print(prompt);
      try
      {inputLine = (new java.io.BufferedReader(
              new java.io.InputStreamReader(System.in))).readLine();
      }
      catch (Exception e)
      { String err = e.toString();
      System.out.println(err);
      inputLine = "";
      }
      return inputLine;
   }

   static String inputString(String prompt)
   { return input(prompt);   }

   static String input()
   { return input("");       }

   static int inputInt()
   {  return inputInt(""); }

   static double inputDouble()
   { return inputDouble(""); }

   static char inputChar(String prompt)
   {  char result=(char)0;
      try{result=input(prompt).charAt(0);}
      catch (Exception e){result = (char)0;}
      return result;
   }

   static byte inputByte(String prompt)
   {  byte result=0;
      try{result=Byte.valueOf(input(prompt).trim()).byteValue();}
      catch (Exception e){result = 0;}
      return result;
   }

   static int inputInt(String prompt)
   {  int result=0;
      try{result=Integer.valueOf(
      input(prompt).trim()).intValue();}
      catch (Exception e){result = 0;}
      return result;
   }

   static long inputLong(String prompt)
   {  long result=0;
      try{result=Long.valueOf(input(prompt).trim()).longValue();}
      catch (Exception e){result = 0;}
      return result;
   }

   static double inputDouble(String prompt)
   {  double result=0;
      try{result=Double.valueOf(
      input(prompt).trim()).doubleValue();}
      catch (Exception e){result = 0;}
      return result;
   }

   static boolean inputBoolean(String prompt)
   {  boolean result=false;
      try{result=Boolean.valueOf(
      input(prompt).trim()).booleanValue();}
      catch (Exception e){result = false;}
      return result;
   }
//=========== end IBIO ===========================================//

}