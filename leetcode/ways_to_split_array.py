def waysToSplitArray(nums):
    """
    :type nums: List[int]
    :rtype: int
    """

    leftSum = 0
    rightSum = 0
    validSplits = 0

    for x in nums:
        rightSum += x

    for i in range(len(nums) - 1):
        leftSum += nums[i]
        rightSum -= nums[i]

        if leftSum >= rightSum:
            validSplits += 1

    return validSplits