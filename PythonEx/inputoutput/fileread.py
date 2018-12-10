# f = open("c:/ExpertJava/Python/PythonEx/inputoutput/a.txt", "rt")
# while True :
#     line = f.readline()
#     if len(line) == 0 :
#         break
#     print( line )
# f.close()

f0 = open("c:/ExpertJava/Python/PythonEx/inputoutput/b.txt", "wt")
with open("c:/ExpertJava/Python/PythonEx/inputoutput/a.txt", "rt") as f1 :
    while True :
        line = f1.readline()
        if len(line) == 0 :
            break
        f0.write( line )
        print( line )
        
        
        
        







