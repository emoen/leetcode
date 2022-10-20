import collections


class Solution:
    def firstUniqChar(self, s: str) -> int:
        """
        :type s: str
        :rtype: int
        """
        # build hash map : character and how often it appears
        count = collections.Counter(s)

        # find the index
        for idx, ch in enumerate(s):
            if count[ch] == 1:
                return idx
        return -1

if __name__ == "__main__":
    example = "aaabbeccdfgfg";
    example2 = "abbeccdfgfga";
    example3 = "abbccdfgfga";

    f = Solution()

    expected_e = f.firstUniqChar(example)
    print( example[expected_e] )
    expected_e = f.firstUniqChar(example2)
    print(example2[expected_e] )
    expected_zero = f.firstUniqChar(example3)
    print(example3[expected_zero])
