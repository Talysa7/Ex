import csv, codecs
filename = "test.csv"
write = codecs.open( filename, "w", encoding="utf-8" )
writer = csv.writer( write, delimiter=",")
writer.writerow(["아이디", "이름", "가격"])
writer.writerow(["1000", "SD카드", 30000])
writer.writerow(["1001", "그래픽카드", 300000])
writer.writerow(["1002", "키보드", 5000])
writer.writerow(["1003", "마우스", 3000])
writer.writerow(["1004", "스피커", 2000])
print( "파일생성 완료" )

write.close()

readcsv = codecs.open( filename, "r", encoding="utf-8" ).read()
data = []
rows = readcsv.split("\r\n" )
for row in rows :
    if row == "" :
        continue
    cells = row.split(",")
    data.append( cells )

for d in data :
    print( d[0] + "\t" + d[1] + "\t" + d[2] )    

print( "파일입력 완료" )











