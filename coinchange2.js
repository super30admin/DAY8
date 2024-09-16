/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
    //edge case 
   if(!coins) return 0;
   var dp = new Array(coins.length+1);
   var m = dp.length;
   
   for(i=0;i<m;i++){
      dp[i] = new Array(amount+1);
      dp[i][0] = 1;

   }
   
   var n = dp[0].length;
   for(i = 1; i<n;i++){
       //To avoid integer overflow, assign 99999
       dp[0][i] = 0;
       
   }
   for(i = 1; i<m; i++){
       for ( j = 1; j < n ; j++){
           //i-1 since we used dummy row with 0 //coins[i-1] is denomination of the coin
           if(j < coins[i-1]){
               dp[i][j] = dp[i-1][j];
           } else {
               dp[i][j] = dp[i-1][j]+ ( dp[i][j-coins[i-1]]);  
           }
       }
   }   
  
   var result = dp[m-1][n-1];
   return result; 
           
};

//time complexity : O(mn), where m is the amount and n is the no of coins.
//space cpmplexity : O(1)