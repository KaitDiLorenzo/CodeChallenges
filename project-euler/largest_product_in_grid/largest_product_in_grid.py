def largest_product_in_grid():
    grid = []
    with open("project-euler/largest_product_in_grid/grid.txt") as f:
        for line in f.readlines():
            grid.append([int(v) for v in line.split(" ")])

    max_product = 0
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            max_product_candidates = [max_product]

            if i < len(grid) - 3 and j > 2:
                diagonal_left_product = grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2] * grid[i + 3][j - 3]
                max_product_candidates.append(diagonal_left_product)

            if i < len(grid) - 3 and j < len(grid[i]) - 3:
                diagonal_right_product = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3]
                max_product_candidates.append(diagonal_right_product)

            if j < len(grid[i]) - 3:
                horizontal_product = grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3]
                max_product_candidates.append(horizontal_product)

            if i < len(grid) - 3:
                vertical_product = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j]
                max_product_candidates.append(vertical_product)

            max_product = max(max_product_candidates)

    return max_product


print(largest_product_in_grid())
