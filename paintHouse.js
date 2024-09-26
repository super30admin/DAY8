// Time Complexity : Exponential - O(3^n)
// Space Complexity : Constant - O(1)
// Did this code successfully run on Leetcode : I do not have lc premium
// Any problem you faced while coding this : Still struggling with recursion. Do not know what final output should be.

const helper = (costs, houseNum, color, costSoFar) => {
  if (houseNum >= costs.length) {
    return costSoFar;
  }

  if (color === 0) {
    return Math.min(
      helper(costs, houseNum + 1, 1, costSoFar + costs[houseNum][0]),
      helper(costs, houseNum + 1, 2, costSoFar + costs[houseNum][0])
    );
  }
  if (color === 1) {
    return Math.min(
      helper(costs, houseNum + 1, 0, costSoFar + costs[houseNum][1]),
      helper(costs, houseNum + 1, 2, costSoFar + costs[houseNum][1])
    );
  }
  if (color === 2) {
    return Math.min(
      helper(costs, houseNum + 1, 0, costSoFar + costs[houseNum][2]),
      helper(costs, houseNum + 1, 1, costSoFar + costs[houseNum][2])
    );
  }
};

const paintHouse = (costs) => {
  const case1 = helper(costs, 0, 0, 0); // paint house red
  const case2 = helper(costs, 0, 1, 0); // paint house blue
  const case3 = helper(costs, 0, 2, 0); // paint house green

  return Math.min(case1, Math.min(case2, case3));
};

console.log(
  paintHouse([
    [17, 2, 17],
    [16, 16, 5],
    [14, 3, 19],
  ])
);
