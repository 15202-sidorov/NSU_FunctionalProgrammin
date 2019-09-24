letters = ['a', 'b', 'c', 'd']
n = 4
proc = []

def generate(letters, n)
  proc = letters.clone
  gen_rec(proc, letters, n, 1)
end

def gen_rec(proc, letters, n, len)
  if len < n 
    proc = letters
               .map { |letter|
                 proc.select{|str| str[-1] != letter}.map{|str| str + letter}
               }
               .reduce([]) {|acc, val| acc + val }
    return gen_rec(proc, letters, n, len + 1)
  else
    return proc
  end
end

p generate(letters, n)


