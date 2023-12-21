def lattice_paths(grid_width):
    if(grid_width < 2):
        return 0
    
    grid = [[2, 1], [1, 0]]
    while len(grid) <= grid_width:
        grid.insert(0, [1])
        grid[-1]. insert(0, 1)

        for i in range(-2, (len(grid[1]) + 1) * -1, -1):
            grid[0].insert(0, grid[1][i] + grid[0][0])
            grid[i].insert(0, grid[0][0])

        grid[0].insert(0, grid[0][0] + grid[1][0])    

    return grid[0][0];

print(lattice_paths(20))