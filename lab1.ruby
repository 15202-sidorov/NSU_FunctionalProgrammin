letters = ['a', 'b', 'c']
n = 4
proc = []

def generateStrings(letters, n)
  def generateStringsOfLength(proc, letters, n, len)
    if len < n 
      proc = letters
                 .map{|letter|
                   proc.select{|str| str[-1] != letter}.map{|str| str + letter} 
                 }
                 .reduce([]) {|acc, val| acc + val}
      generateStringsOfLength(proc, letters, n, len + 1)
    else
      proc
    end
  end
  generateStringsOfLength(letters, letters, n, 1)
end

p generateStrings(letters, n)