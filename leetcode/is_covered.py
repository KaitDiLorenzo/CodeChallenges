def isCovered(ranges, left, right):
    """
    :type ranges: List[List[int]]
    :type left: int
    :type right: int
    :rtype: bool
    """

    isCovered = None
    currentNum = left
    
    ranges.sort()
    
    for range in ranges:
        if currentNum > right:
            isCovered = True
            break
        elif currentNum < range[0]:
            isCovered = False
            break
        elif currentNum >= range[0] and currentNum <= range[1]:
            currentNum = range[1] + 1

    if isCovered is None:
        isCovered = currentNum > right
    
    return isCovered