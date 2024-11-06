# RC: O(m*n)
# SC: O(n)

def change(amount: int, coins) -> int:
    a = [1] + [0] * amount
    for i in range(1, len(coins) + 1):
        for j in range(amount + 1):
            if (j < coins[i - 1]):
                # Don't choose
                a[j] = a[j]
            else:
                # choose 
                a[j] = a[j] + a[j - coins[i-1]]
    return a[-1]


coins = [1, 2, 5]
amount = 5

print(change(amount, coins))

amount = 3
coins = [2]

print(change(amount, coins))

amount = 10
coins = [10]

print(change(amount, coins))