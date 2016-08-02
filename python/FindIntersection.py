def find_intersection_sorted(list_l, list_s):
    if len(list_l) < len(list_s):
        tmp = list_l
        list_l = list_s
        list_s = tmp

    rst = []
    start = 0

    for i in xrange(len(list_l)):
        target = list_l[i];
        tmp = binary_search(start, len(list_s)-1, target, list_s)
        if tmp != -1:
            start = tmp
            rst.append(target)
        else:
            continue

    print rst

# find the last index of target in list_s
def binary_search(start, end, target, list_s):
    while start + 1 < end:
        mid = start + (end - start) / 2

        if target > list_s[mid]:
            start = mid
        elif target < list_s[mid]:
            end = mid
        else:
            start = mid

    if target == list_s[end]:
        return end
    elif target == list_s[start]:
        return start
    else:
        return -1


if __name__ == '__main__':
    list_s = [0, 3, 5]
    list_l = [0, 1, 2, 3, 4, 5]
    find_intersection_sorted(list_s, list_l)
