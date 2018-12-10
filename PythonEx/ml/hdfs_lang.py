from sklearn import svm, metrics
import matplotlib.pyplot as plt
import pandas as pd
from hdfs import InsecureClient
client_hdfs = InsecureClient( "http://master:50070" )
def load_txt( path ) :    
    data = []
    label = []
    for filename in client_hdfs.list( path ) :
        lang = filename.split( "-" )
        with client_hdfs.read( path+filename, encoding="utf-8" ) as reader :
            langfile = reader.read()
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
train_data, train_label = load_txt( "/input/lang/train/" )
test_data, test_label = load_txt( "/input/lang/test/" )
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
