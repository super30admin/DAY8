/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function (amount, coins) {
  let array = new Array(amount + 1);
  array.fill(0);
  array[0] = 1;

  for (let coinIndex = 0; coinIndex < coins.length; coinIndex++) {
    let coin = coins[coinIndex];
    for (let runningAmt = 0; runningAmt <= amount; runningAmt++) {
      if (coin <= runningAmt) {
        array[runningAmt] = array[runningAmt] + array[runningAmt - coin];
      }
    }
  }

  return array[amount];
};

test("Scenario #2: Happy Path", () => {
  let coins = [1, 2, 5];
  let amount = 5;
  expect(change(amount, coins)).toStrictEqual(4);
});
