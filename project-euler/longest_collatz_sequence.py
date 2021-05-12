chain_lengths = {}


def get_collatz_chain_length(starting_number):
    chain_length = 1
    link_value = starting_number
    while link_value != 1:
        if link_value in chain_lengths:
            return chain_length - 1 + chain_lengths[link_value]

        if link_value % 2 == 0:
            link_value = link_value / 2
        else:
            link_value = 3 * link_value + 1

        chain_length += 1

    chain_lengths[starting_number] = chain_length
    return chain_length


def longest_collatz_sequence(max_value):
    longest_chain = 0
    longest_starting_number = 0
    for i in range(1, max_value + 1):
        chain_length = get_collatz_chain_length(i)
        if chain_length > longest_chain:
            longest_chain = chain_length
            longest_starting_number = i

    return longest_starting_number


print(longest_collatz_sequence(999999))
