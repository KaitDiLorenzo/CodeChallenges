def coin_sums(sum):
    total_valid_coin_combos = 0

    for a in range(0, sum + 1):
        for b in range(0, sum // 2 + 1):
            if a + 2*b > sum:
                break

            for c in range(0, sum // 5 + 1):
                if a + 2*b + 5*c > sum:
                    break

                for d in range(0, sum // 10 + 1):
                    if a + 2*b + 5*c + 10*d > sum:
                        break

                    for e in range(0, sum // 20 + 1):
                        if a + 2*b + 5*c + 10*d + 20*e > sum:
                            break

                        for f in range(0, sum // 50 + 1):
                            if a + 2*b + 5*c + 10*d + 20*e + 50*f > sum:
                                break

                            for g in range(0, sum // 100 + 1):
                                if a + 2*b + 5*c + 10*d + 20*e + 50*f + 100*g > sum:
                                    break
                                
                                if (sum - 100*g - 50*f - 20*e - 10*d - 5*c - 2*b - a) % 200 == 0:
                                    total_valid_coin_combos += 1

    return total_valid_coin_combos

print(coin_sums(200))