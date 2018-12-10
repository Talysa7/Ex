# 함수 Function
def hello() :
    print( "Hello Function!!!" )
hello()

def hap( a, b ) :
    print( "합 : ", a+b )
hap( 5, 2 )
hap( 3, 7 )
hap( 5.5, 3.8 )
# hap( 3, 5, 7 )
# hap( 3 )

# 지역변수
a = 100 # 전역변수
b = 100
def disp( a ):         
    print( "a : ", a )   # 지역변수
    print( "b : ", b )
disp( 50 )      
print( "a : ", a )

# return
# C               함수                    int add( int a, int b ) { return a+b }
# Java            메서드                 public int add( int a, int b ) { return a+b }
# JavaScript      Function     funcion add( a, b ) { return a+b }
# Scala           Function     def add( a, b ) : Int = { a+b }
# Python          Function     def add( a, b ) :; return a, b, a+b

def add( x, y ) :
    return x, y, x+y
x, y, result = add( 5, 2 )
print( x, " + ", y, " = ", result )

def cha( x, y ) :
    return x-y
result = cha( 5, 2 )
print( "차 : %d"%result )        # %d 정수 %f 실수 %c 문자 %s 문자열
print( "차 : %s"%result )    
print( "차 : %c"%result )       
print( "차 : %f"%result )    

def gop( a=1, b=1 ) :
    return a*b
print( "곱 : ", gop( 5, 2 ) )
print( "곱 : ", gop( 5 ) )
print( "곱 : ", gop() )

print( "곱 : ", gop( b=10, a=5 ) )

def va( * args ) :          # 튜플
    print( args )
    for arg in args :
        print( arg )
va( 1, 2, 3 )
va( "A", "B", "C" )

def total(a, *b, **params ) :
    for p in params :
        print( params[p] )
total( 1, second=2, third=3 )    
 
# def div( a, b ) :
#     return a/b
# print( div( 5, 2 ) )

div = lambda a, b : a/b
print( div( 5, 2 ) )

print( (lambda a, b, c : a+b+c)(1, 2, 3 ) )

mm = [ "one", lambda a : a*a, "third" ]
print( mm[1](5) )













   
    
    
    
    
    
    
    