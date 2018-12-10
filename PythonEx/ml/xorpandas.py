import pandas as pd
from sklearn import svm, metrics
inputdata = [ 
    [0, 0, 0], 
    [0, 1, 1], 
    [1, 0, 1], 
    [1, 1, 0] ]

df = pd.DataFrame( inputdata )
data = df.ix[:, 0:1]        # [ [0, 0], [0, 1], [1, 0], [1, 1] ]
label = df.ix[:, 2]         # [ 0, 1, 1, 0]

clf = svm.SVC()
clf.fit( data, label )

examdata = df.ix[0:1, 0:1]  # [ [0, 0], [0, 1] ]
examlabel = df.ix[0:1, 2]   # [ 0, 1 ]
pre = clf.predict( examdata )

score = metrics.accuracy_score( examlabel, pre )
print( score )






















