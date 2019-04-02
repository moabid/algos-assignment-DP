/**
 * Rod cutting problem described in Chapter 15 of textbook
 */
public class RodCutting {
    //Function to find maximum of two values
    int max(int a,int b) {
      if (a>b)
          return a;
      else 
          return b;
}
    
   
   // Do not change the parameters!
    /* Recursive Function that finds a way to cut a rod
       in a way that maximize the revenue 
    */
  
  public int rodCuttingRecur(int rodLength, int[] lengthPrices) {
      // Base case
/*      if( rodLength == 0)
          return 0; */
            int [] solution = new int[rodLength+1];
                    solution[0] = 0 ;

      int maxValue;
      
       // Assigning the smallest possible value to maxValue
           maxValue = Integer.MIN_VALUE;
          
          // Partitioning the given rod of length
          // n into two parts and take maximum
          for (int i =1 ; i <= rodLength; i++){
              // rod of length i has price[i-1]
              int profit = lengthPrices[i-1] + rodCuttingRecur(rodLength-i,lengthPrices);
              maxValue = max(maxValue,profit);
              solution[i] = maxValue;
          
      }
    return maxValue;
  }
  
  // Do not change the parameters!
  /* Dynamic Function that finds a way to cut a rod
       in a way that maximize the revenue  */
  public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {
       // Solution[] stores maximum profit acheived from rod
      int [] solution = new int[rodLength+1];
      solution[0] = 0 ;
      // Making solution[] in botton up way
      
      for( int i =1 ; i <= rodLength ; i++){
          
          // Divide the rod into two rods and take maximum
          for( int j =0 ; j<i ; j++)
         solution[i] = max(solution[i], lengthPrices[j] + solution[i-j-1] );
          
      }
      // returns maximum profit achieved
    return solution[rodLength];
  }
    

  public static void main(String args[]){
      RodCutting rc = new RodCutting();

      // In your turned in copy, do not touch the below lines of code.
      // Make sure below is your only output.
      int length1 = 7;
      int[] prices1 = {1, 4, 7, 3, 19, 5, 12};
      int length2 = 14;
      int[] prices2 = {2, 5, 1, 6, 11, 15, 17, 12, 13, 9, 10, 22, 18, 26};
      int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);
      int maxSell1Bottom = rc.rodCuttingBottomUp(length1, prices1);
      int maxSell2Recur = rc.rodCuttingRecur(length2, prices2);
      int maxSell2Bottom = rc.rodCuttingBottomUp(length2, prices2);
      System.out.println(maxSell1Recur + " " + maxSell1Bottom);
      System.out.println(maxSell2Recur + " " + maxSell2Bottom);
  }
}
