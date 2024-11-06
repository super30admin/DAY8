# TC: o(n)
# Space: o(1)

def paint_house(cost):
    cost_r, cost_b, cost_g = 0, 0, 0
    for r, g, b in cost:
        new_cost_r = min(cost_b, cost_g) + r
        new_cost_b = min(cost_r, cost_g) + b 
        new_cost_g = min(cost_r, cost_b) + g

        cost_r, cost_g, cost_b = new_cost_r, new_cost_g, new_cost_b

    return min(cost_r, cost_b, cost_g)

print(paint_house([[17,2,17],[16,16,5],[14,3,19]]))