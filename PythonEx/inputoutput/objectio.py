import pickle
f0 = open("c:/ExpertJava/Python/PythonEx/inputoutput/list.data", "wb")
shoplist = ["apple", "garlic", "onion", "tomato", "banana"]
pickle.dump( shoplist, f0 )
f0.close()
 
f1 = open("c:/ExpertJava/Python/PythonEx/inputoutput/list.data", "rb")
storedlist = pickle.load(f1)
print( storedlist )
f1.close()
