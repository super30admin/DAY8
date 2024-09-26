// Time Complexity : O(2^n) - exponential
// Space Complexity : O(n) - recursive stack
// Did this code successfully run on Leetcode : no, because tc was exponential
// Any problem you faced while coding this : no

var change = function (amount, coins) {
  let count = 0;
  if (!coins.length) return result;

  const helper = (amount, coins, index) => {
    // base conditions
    if (amount === 0) {
      count++;
      return;
    }

    if (amount < 0 || index === coins.length) {
      return;
    }

    // logic
    // Zero case - do not choose
    helper(amount, coins, index + 1);

    // One case - choose
    helper(amount - coins[index], coins, index);
  };

  helper(amount, coins, 0);
  return count;
};

console.log(change(500, [3, 5, 7, 8, 9, 10, 11]));

// iterative recursion:
var change = function (amount, coins) {
  let count = 0;
  if (!coins.length) return result;

  const helper = (amount, coins, index) => {
    // base conditions
    if (amount === 0) {
      count++;
      return;
    }

    if (amount < 0 || index === coins.length) {
      return;
    }

    // logic
    for (let i = index; i < coins.length; i++) {
      helper(amount - coins[i], coins, i);
    }
  };

  helper(amount, coins, 0);
  return count;
};

console.log(change(500, [3, 5, 7, 8, 9, 10, 11]));
