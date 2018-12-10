from sklearn import svm, metrics
clf = svm.SVC()
data = [ [0,0], [1,0], [0,1], [1,1] ]
label = [ 0, 1, 1, 0 ]

# 학습
clf.fit( data, label )
          
# 예측
examdata = [ [0,1], [1,0] ]
# examlabel = [ 1, 0 ]              # 정답률 0.5
examlabel = [ 1, 1 ]                # 정답률 1.0
result = clf.predict( examdata )
print( result )
# result = clf.predict( [ [1,1] ] )
# print( result )

# 정답률
score = metrics.accuracy_score( examlabel, result )
print( score )











