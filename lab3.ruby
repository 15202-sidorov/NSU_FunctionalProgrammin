
TARGET_REGEXP = /^\[.*Oct.*\] "(GET|OPTIONS|POST|DELETE|PUT) \/api\/accounts.*" 200.*$/;

def requestDoesMatch (line)
	if line.match(TARGET_REGEXP)
		puts line
	end
end


File.foreach('./examplelog') { |line| requestDoesMatch(line) } 
