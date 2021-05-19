def lattice_paths(height, width):
    print(height, width)
    if height == 0 or width == 0:
        return 1
    elif height == 1 and width == 1:
        return 2
    else:
        return lattice_paths(height - 1, width) + lattice_paths(height, width - 1)


print(lattice_paths(6, 6))
