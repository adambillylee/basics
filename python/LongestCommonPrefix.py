def longest_common_prefix(arr):
    size = float("inf")

    # find the shortest string length, since lcp cannot be longer than this
    for i in arr:
        size = min(size, len(i))

    # make pre to be first string in array
    pre = arr[0]

    # outer: loop through arr[1] to end
    for i in xrange(1, len(arr)):
        tmp = arr[i]

        # loop through all chars in array up to size
        for j in xrange(size):
            # if char j cannot be find in pre, cut pre up to j
            if pre.find(tmp[j]) == -1:
                pre = pre[:j]

    print pre


if __name__ == '__main__':
    arr = ["aaa", "aab", "aac", "aaad"]
    longest_common_prefix(arr)

