import pandas as pd
from sklearn import svm, metrics
from sklearn.model_selection._split import train_test_split
from hdfs import InsecureClient

client_hdfs = InsecureClient( "http://master:50070" )
with client_hdfs.read( "/input/iris.csv", encoding="utf-8") as reader :
    csv = pd.read_csv( reader, index_col=0 )            # DataFrame 
data = csv.ix[:, 0:3]               # 붓꽃의 길이
label = csv[ "Name" ]               # 붓꽃의 종류

train_data, test_data, train_label, test_label = train_test_split( data, label )
clf = svm.SVC()
clf.fit( train_data, train_label )
pre = clf.predict( test_data )
score = metrics.accuracy_score( pre, test_label )
print( score )










