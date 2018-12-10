name = "홍길동"
age = 30
print( "이름 : \t 나이 : ", name, age )
print( "이름 :", name, "\t", "나이 :", age )
print( "이름 : {0} \t 나이 : {1}".format( name, age ) )
print( "나이 : {1} \t 이름 : {0}".format( name, age ) )
print( "이름 : {} \t 나이 : {}".format( name, age ) )
print( "이름 :" + name + "\t" + "나이 :" + str(age) )

a = 10
b = 3
print( a/b )
print( format( a/b ) )
print( "{0:0.3f}".format( a/b ) )
print( "{0:10.3f}".format( a/b ) )
print( "{0:10d}".format( a ) )
print( "{0:010d}".format( a ) )

print( "{0:^11s}".format( "Hello" ) )
print( "{0:_^11s}".format( "Hello" ) )
print( "이름 : {name} \t 나이 : {age}".format(name="홍길동", age=30 ) )

















