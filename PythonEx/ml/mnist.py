# 다운로드
import urllib.request as req
import gzip, os, os.path
path = "./MNIST"
url = "http://yann.lecun.com/exdb/mnist"
files = [ "t10k-images-idx3-ubyte.gz", "t10k-labels-idx1-ubyte.gz",
          "train-images-idx3-ubyte.gz", "train-labels-idx1-ubyte.gz" ]

if not os.path.exists( path ) :
    os.mkdir( path )
for f in files :
    furl = url + "/" + f
    fpath = path + "/" + f
    print( "다운로드중 : " + furl )
    if not os.path.exists( fpath ) :
        req.urlretrieve( furl, fpath )
print( "다운로드 완료" )

# 압축해제
for f in files :
    gzfile = path + "/" + f
    savefile = path + "/" + f.replace(".gz", "")
    with gzip.open( gzfile, "rb" ) as fp :
        body = fp.read()
        with open(savefile, "wb") as w :
            w.write( body )
print( "압축해제 완료" )

import struct
def to_csv( name, maxdata ) :
    imagefile = open("./MNIST/" + name + "-images-idx3-ubyte", "rb" )
    labelfile = open("./MNIST/" + name + "-labels-idx1-ubyte", "rb" )
    csvfile = open("./MNIST/" + name + ".csv", "w", encoding="utf-8" )
    # 파일 헤더 정보 읽기
    mag, imagecount = struct.unpack( ">II", imagefile.read(8) )
    mag, labelcount = struct.unpack( ">II", labelfile.read(8) )
    rows, cols = struct.unpack( ">II", imagefile.read(8) )
    pixels = rows * cols
    # 이미지를 CSV로 저장
    for i in range( labelcount ) :
        if i > maxdata :
            break;
        label = struct.unpack( "B", labelfile.read(1))[0]
        data = imagefile.read( pixels )
        sdata = list( map( lambda n: str(n), data ) )
        csvfile.write( str(label) + "," )
        csvfile.write( ",".join(sdata) + "\r\n" )
    imagefile.close()
    labelfile.close()
    csvfile.close()
    
to_csv( "train", 5000 )             # "train-images-idx3-ubyte", "train-labels-idx1-ubyte"
to_csv( "t10k", 1000 )               # "t10k-images-idx3-ubyte", "t10k-labels-idx1-ubyte"
print( "CSV 변환  완료" )

# CSV 가공
def load_csv( csvfile ) :
    labels = []
    images = []
    with open( csvfile, "r") as f :
        for line in f :
            cols = line.split(",")
            if len( cols ) < 2 :
                continue
            labels.append( int( cols.pop(0) ) )
            vals = list( map( lambda n : int(n)/256, cols ) )
            images.append(vals)
    return {"labels": labels, "images" : images}            

traindata = load_csv( "./MNIST/train.csv" )
validdata = load_csv( "./MNIST/t10k.csv" )

# 학습
from sklearn import svm, metrics
clf = svm.SVC()
clf.fit( traindata["images"], traindata["labels"])
predict = clf.predict( validdata["images"] )
score = metrics.accuracy_score( validdata["labels"], predict )
report = metrics.classification_report( validdata["labels"], predict )
print( "정답률 : ", score )
print( "리포트 : ", report )

# pandas
import pandas
traincsv = pandas.read_csv( "./MNIST/train.csv", header=None )
tkcsv = pandas.read_csv( "./MNIST/t10k.csv", header=None )
 
def change( n ) :
    output = []
    for i in n :
        output.append( float(i) / 256 )
    return output
train_data = list( map( change, traincsv.iloc[:, 1:].values ) )
train_label = traincsv[0].values
tk_data = list( map( change, tkcsv.iloc[:, 1:].values ) )
tk_label = tkcsv[0].values
clf = svm.SVC()
clf.fit( train_data, train_label )
predict = clf.predict( tk_data )
score = metrics.accuracy_score( tk_label, predict )
print( "정답률 : ", score )
print()

point = [[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,93,164,211,250,250,194,15,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,20,176,253,237,180,180,243,254,214,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,204,236,135,18,0,0,40,242,252,126,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,69,253,167,0,0,0,0,0,130,254,223,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,74,217,79,0,0,0,0,0,46,254,231,14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,10,0,0,0,0,0,0,39,254,254,104,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,212,254,141,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,207,254,141,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,215,254,128,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,39,254,254,56,0,0,20,67,124,39,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,35,98,254,254,208,157,207,225,254,241,160,0,0,0,0,0,0,0,0,0,0,9,31,82,137,203,203,212,254,254,254,254,251,223,223,127,52,33,0,0,0,0,0,0,0,0,0,9,137,214,254,254,254,254,240,228,250,254,254,154,50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,185,254,247,179,146,67,60,28,0,216,254,220,12,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,255,222,49,0,0,0,0,4,137,244,232,50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,254,206,4,0,0,0,8,179,254,247,64,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,216,254,158,177,130,96,213,252,199,49,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,131,247,249,249,249,171,72,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]]
pre = clf.predict( list( map( change, point ) ) )
print( pre )    
    
    















        
             