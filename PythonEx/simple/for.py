# i = 0
# while i < 10 :
#     i+=1
#     print( i )
# else :
#     print( i )    
#  
# i=0
# sum_all=0
# sum_odd=0
# sum_even=0
# while i < 100 :
#     i+=1
#     sum_all += i
#     if i%2 == 0 : 
#         sum_even += i
#     else :
#         sum_odd += i
# else :
#     print( "전체합 : ", sum_all )
#     print( "짝수합 : ", sum_even )
#     print( "홀수합 : ", sum_odd )

# for i in range(10) :
#     print( i )    

# for i in range(1, 10) :
#     print(i)

# for i in range(1, 11, 2 ) :
#     print( i )

# 배열
# m = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
# for i in m :
#     print( i )
# print( m[5] )    

# 딕셔너리
w = {"a":1, "b":2, "c":3}
for key in w :
    print( key, " : ", w[key] )
print( "a : ", w["a"] )

# 튜플    
y = [(1,"2"),(3,4.5),(5,"ABC")]
for (a, b) in y :
    print( a, " : ", b )

# 리스트 축약
aa = [ 1, 2, 3, 4, 5, 6, 7, 8, 9 ]
bb = [ i*2 for i in aa if i > 5]
cc = [ i*2 for i in aa ]
print( aa )
print( bb )
print( cc )

# enumerate()
strs = ["이순신", "김유신", "홍길동"]
for i in range( len(strs) ) :
    print( i, " : ", strs[i] )

for i in enumerate( strs, 100 ) :
    print( i )






    
    


    
    
    
    
    
    