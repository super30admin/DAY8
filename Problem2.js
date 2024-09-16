//Coin Change 2 (LC 518)

// Time Complexity : O(nk) where k is amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes initially I had problems coming up with solution

//Set empty array to zeros then set initial 0 amount to 1 way and then use the loops to generate the table dynamically
/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
    let table = new Array(amount + 1);
    table.fill(0);
    table[0]=1;
    
    coins.forEach(coin => {
        for(let i = coin; i < table.length; i++){
            table[i] += table[i-coin];
        }
    })
    return table[table.length - 1];
};