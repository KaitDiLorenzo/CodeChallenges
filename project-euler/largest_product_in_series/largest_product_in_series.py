def largest_product_in_series(num_of_factors):
    with open("project-euler/largest_product_in_series/series.txt") as f:
        series = f.read()

    series = series.replace("\n", "")

    max_product = 0
    starting_index = 0
    while starting_index <= len(series) - num_of_factors:
        product = 1
        for i in range(starting_index, starting_index + num_of_factors):
            if series[i] == "0":
                starting_index = i + 1
                break

            product *= int(series[i])
        else:
            max_product = max(max_product, product)
            starting_index += 1

    return max_product


print(largest_product_in_series(13))
