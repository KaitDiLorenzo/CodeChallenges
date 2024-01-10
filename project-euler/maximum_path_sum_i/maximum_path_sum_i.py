def maximum_path_sum_i():
    triangle = []
    with open("project-euler/maximum_path_sum_i/triangle.txt") as f:
        for line in f.readlines():
            triangle.append([int(i) for i in line.split(" ")])

    return get_max_path_sum(triangle)

def get_max_path_sum(triangle):
    if(len(triangle) == 1):
        return triangle[0][0]
    
    left_triangle = []
    right_triangle = []
    for i in range(1, len(triangle)):
        left_triangle.append(triangle[i].copy())
        right_triangle.append(triangle[i].copy())

    for line in left_triangle:
        line.pop()

    for line in right_triangle:
        line.pop(0)

    return max(triangle[0][0] + get_max_path_sum(left_triangle), triangle[0][0] + get_max_path_sum(right_triangle))

print(maximum_path_sum_i())