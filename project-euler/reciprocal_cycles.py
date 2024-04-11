def reciprocal_cycles(max_divisor):
    longest_recurring_cycle = 0
    longest_recurring_cycle_d = 0

    for d in range(1, max_divisor):
        remainders = [1]
        dividend = 1

        while dividend > 0:
            while(d > dividend):
                dividend *= 10

            remainder = dividend % d

            if(remainder != 0):
                if(remainder in remainders):
                    cycle_length = len(remainders) - remainders.index(remainder)
                    if(cycle_length > longest_recurring_cycle):
                        longest_recurring_cycle = cycle_length
                        longest_recurring_cycle_d = d
                    break
                else:
                    remainders.append(remainder)
                    dividend = remainder
            else:
                break

    return longest_recurring_cycle_d


print(reciprocal_cycles(1000))