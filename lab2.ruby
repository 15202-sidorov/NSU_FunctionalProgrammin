 

class MultithreadedArray
 	@@amountOfThreads = 4

    def initialize(array)
        @arr = array
    end  
 
    def map(&fn)
        do_multithreaded {|arr| arr.map(&fn)} .flatten
    end
 
    def select(&fn)
        do_multithreaded {|arr| arr.select(&fn)} .flatten
    end
 
    def all?(&fn)
        do_multithreaded {|arr| arr.all?(&fn)} .reduce(true) {|acc, el| acc && el}
       
    end
 
    def any?(&fn)
        do_multithreaded {|arr| arr.any?(&fn)} .reduce(false) {|acc, el| acc || el}
    end
 
    def do_multithreaded()
        (0...@@amountOfThreads).map { |i|
            Thread.new { 
            	yield @arr.slice(
            		i*@arr.length/@@amountOfThreads, 
            		@arr.length/@@amountOfThreads
            	) 
            }
        }.map(&:value)
    end
end
 
 
arr = (0..64).to_a
myarr = MultithreadedArray.new(arr)

puts("map(*2)")
puts(myarr.map { |a| a * 2 })
puts("select(%2)")
puts(myarr.select { |a| a % 2 == 0 })
puts("any(a<0)")
puts(myarr.any? { |a| a < 0 })
 