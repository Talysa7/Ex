from sklearn import svm, metrics
import os.path, glob
import matplotlib.pyplot as plt
import pandas as pd
def load_txt( path ) :
    files = glob.glob( path )
    data = []
    label = []
    for filename in files :
        file = os.path.basename( filename )
        lang = file.split( "-" )
        langfile = open( filename, "r", encoding="utf-8" ).read()
        langtext = langfile.lower()
        code_a = ord("a")
        code_z = ord("z")
        count = [ n for n in range(0, 26) ]
        for char in langtext :
            charcode = ord( char )
            if code_a <= charcode <= code_z :
                count[charcode - code_a] += 1
        total = sum( count )
        count = list( map( lambda n : n/total, count ) )
        data.append( count )
        label.append( lang[0] )
    return data, label    
train_data, train_label = load_txt( "./lang/train/*.txt" )
test_data, test_label = load_txt( "./lang/test/*.txt" )
clf = svm.SVC()
clf.fit( train_data, train_label )
predict = clf.predict( test_data )
score = metrics.accuracy_score( test_label, predict )
print( "score : ", score )
graph_dict = {}
for i in range( 0, len( train_label ) ) :
    label = train_label[i]
    data = train_data[i]
    if not label in graph_dict :
        graph_dict[label] = data
asclist = [ [chr(n) for n in range(97, 97+26)] ]
df = pd.DataFrame( graph_dict, index=asclist )
plt.style.use( "ggplot" )
df.plot( kind="bar", subplots=True, ylim=(0, 0.15) )   
plt.show()     
plt.savefig( "lang-plt.png" )
