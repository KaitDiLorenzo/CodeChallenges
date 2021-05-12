def large_sum():
    sum = 0
    with open("project-euler/large_sum/numbers.txt") as f:
        for line in f.readlines():
            sum += int(line)

    return str(sum)[0:10]


print(large_sum())
