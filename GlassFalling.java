/**
 * Glass Falling
 */
public class GlassFalling {
    //Function to find maximum of two values
    int max(int a,int b) {
      if (a>b)
          return a;
      else 
          return b;
}
    //Function to find minimum of two values
    int min(int a,int b) {
      if (a<b)
          return a;
      else 
          return b;
}
    
  // Do not change the parameters!
     public int glassFallingRecur(int floors, int sheets) {
    // Fill in here and change the return
         
         if ( floors == 0 || floors == 1 || sheets==1)  //0 floors = 0 trials needed, 1 floor = 1 trial needed, 1 sheet needs trials=floors
             return floors;
        
        
         // Assigning the highest possible value to variable minimum 
         int minimum = Integer.MAX_VALUE;  
         int result , counter = 1 ;
         
         // Recursion to find glassFallingRecur(floors,sheets)
         while( counter <= floors){
             // Find max from both case, add 1 and assigns it to variable result
             result = 1+ max(glassFallingRecur(counter-1,sheets-1), glassFallingRecur(floors-counter,sheets));
               minimum = min(minimum,result);
             counter++ ;
         }
         
        return minimum++;
  }
     // Optional:
     // Pick whatever parameters you want to, just make sure to return an int.
    /* public int glassFallingMemoized() {
       // Fill in here and change the return
       return 0;
     }*/
     
   // Do not change the parameters!
    public int glassFallingBottomUp(int floors, int sheets) {
   // Fill in here and change the return
        // 
        int sheetFloor[][]= new int[sheets+1][floors+1];
        int result , i , j , x;
        
        for (i =1 ;i <= sheets; i++){
            sheetFloor[i][0]= 0;
            sheetFloor[i][1]= 1;
        }
        
        for (j =1 ;j <= floors; j++)
            sheetFloor[1][j]= j;
       
        // This loop fills up the matrix
        i = 2;
        while(i <= sheets){
            for(j=2 ; j<= floors; j++){
                int minimum = Integer.MAX_VALUE;
                for ( x =1 ;x<= j ; x++)
                {
                    result = 1 + max(sheetFloor[i-1][x-1],sheetFloor[i][j-x]);
                    minimum = min(minimum, result);
                }
                // Defines the minimum value for sheetFloor[i][j]
                sheetFloor[i][j] = minimum ;
            }
            i++;
        }
        return sheetFloor[sheets][floors];
  }
    

  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
  }
}
