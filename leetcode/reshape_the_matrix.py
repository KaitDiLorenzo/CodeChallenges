def matrixReshape(mat, r, c):
    """
    :type mat: List[List[int]]
    :type r: int
    :type c: int
    :rtype: List[List[int]]
    """

    if len(mat) * len(mat[0]) == r * c:
        reshapedMatrix = list()
        matI = 0
        matJ = 0

        for i in range(r):
            row = list()

            for j in range(c):
                if matJ >= len(mat[0]):
                    matI += 1
                    matJ = 0
                
                row.append(mat[matI][matJ])
                matJ += 1

            reshapedMatrix.append(row)
    else:
        reshapedMatrix = mat

    return reshapedMatrix