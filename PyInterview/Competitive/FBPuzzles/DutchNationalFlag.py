__author__ = 'Lucas'

# Facebook Interview Question One:

# Three possible numbers: 1, 2, 3
# Sort a list so all 1's are in beginning,
# 2's middle, 3's are in end
# - O(n)
# - No New list allocations

def sortList(array):
    lo, counter, hi = 0, 0, len(array) - 1
    while counter <= hi:
        if array[counter] == 1:
            array[counter], array[lo] = array[lo], array[counter]
            lo += 1
            counter += 1
        elif array[counter] == 3:
            array[counter], array[hi] = array[hi], array[counter]
            hi -= 1
        else:
            counter += 1
    return array

def main():
    raw_lst = [1, 2 ,2, 3, 3, 1, 2, 1, 3, 1, 1]
    #raw_lst = [3, 2, 3]
    raw_lst = [3, 2, 1, 2, 3]
    print "Original:", str(raw_lst)
    lst = sortList(raw_lst)
    print "After:", str(lst)

if __name__ == "__main__":
    main()