def distinct_powers(a_start, a_end, b_start, b_end):
    distinct_powers = set()

    for a in range(a_start, a_end + 1):
        for b in range(b_start, b_end + 1):
            distinct_powers.update([a ** b])

    return len(distinct_powers)

print(distinct_powers(2, 5, 2, 5))