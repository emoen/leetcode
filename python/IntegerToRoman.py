class IntegerToRoman():
    '''
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    '''

    one = 'I'
    five = 'V'
    ten = 'X'
    fifty = 'L'
    hundred = 'C'
    fivehundred = 'D'
    thousand = 'M'

    def intToRom(self, target: int) -> str:
        roman = ''
        toReduce = target
        roman, toReduce = self.doReduce( 1000, 'M', '',toReduce, roman)
        roman, toReduce = self.doReduce( 500, 'D', 'CM',toReduce, roman)
        roman, toReduce = self.doReduce( 100, 'C', 'CD',toReduce, roman)
        roman, toReduce = self.doReduce( 50, 'L', 'XC',toReduce, roman)
        roman, toReduce = self.doReduce( 10, 'X', 'XL',toReduce, roman)
        roman, toReduce = self.doReduce( 5, 'V', 'IX',toReduce, roman)
        roman, toReduce = self.doReduce( 1, 'I', 'IV',toReduce, roman)

        return roman

    def doReduce(self, num: int, romanChar: str, romanDown: str, reduce: str, roman: str):
        while (reduce % num < reduce):
            if int(str(reduce)[0]) == 9 or int(str(reduce)[0]) == 4:
                roman += romanDown
                if reduce > 10:
                    reduce = int(str(reduce)[1:])
                else:
                    reduce = 0
            else:
                roman += romanChar
                reduce = reduce - num

        print(reduce)
        return roman, reduce

if __name__ == "__main__":
    f = IntegerToRoman()

    #aRoman = f.intToRom(52)
    #print(aRoman)

    aRoman = f.intToRom(40)
    print(aRoman)

    print("DDDDDD")
    aRoman = f.intToRom(1994)
    print(aRoman)
    expected = "MCMXCIV"
