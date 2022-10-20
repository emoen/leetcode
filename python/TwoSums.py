from typing import List

class TwoSums():
    '''
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    '''
    def twoSums(self, nums: List[int], target: int) -> List[int]:

        for i in range(0, len(nums)-1):
            for j in range(i+1, len(nums)):
                if (nums[i] + nums[j] == target):
                    return [i, j]
        return [0,0]


if __name__ == "__main__":
    f = TwoSums()

    nums1 = [2,7,11,15]
    target1 = 9

    expected = [0,1]
    actual = f.twoSums(nums1, target1)

    print(expected == actual)