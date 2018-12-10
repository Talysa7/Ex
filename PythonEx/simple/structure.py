# 자료구조
# 열거형       배열 리스트 튜플 문자열 딕셔너리

# 배열
m = ["apple", "banana", "orange", "mango", "melon"]
# for i in m :
#     print( i )
# print( m[0] )   
# print( m[-1] )   
# for i in range(-1, -6, -1) :
#     print( m[i] )   
# print( m[0:2] )
# print( m[2:] )
# print( m[3:len(m)] )
# print( m[3:-1] ) 
# print( m[3:0] ) 
# print( m[-1:-3] )
# print( m[:-1] )
# print( m[:] )

# 문자열
# for i in range( len(m) ) :
#     for  j in range( len(m[i] ) ) :
#         print( m[i][j] ) 
        
# msg = "hello python HAHA!!!"
# print( msg.swapcase() )
# print( msg.title() )
# print( msg.capitalize() )
# print( msg.count( "!" ) )
# print( msg.find( "o" ) )
# print( msg.find( "i" ) )
# print( msg.index( "o" ) )
# # print( msg.index( "i" ) )
# print( msg.join( "##" ) )
# print( msg.join( "#$" ) )
# 
# msgs = "     a   a    a        "
# print( msgs )
# print( msgs.strip() )
# 
# msgss = "a, b, c, d, e, f"
# print( msgss.split(",") )
# 
# digit = "a1b2c3d4"
# print( digit.isalnum( ) )
# print( digit.isalpha() )
# print( digit.isdecimal() )
# print( digit.isdigit() )

# 튜플
# zoo = ("dog", "cat", "pig", "lion", "tiger")
# print( len(zoo) )
# print( zoo )
# print( zoo[0] )
# print( zoo[0][0] )
# print( zoo.index( "lion" ) )


# 리스트
# country = ["korea", "china", "japan", "france", "india"]
# print( country )
# print( len(country) )
# country.append( "swiss" )
# print( country )
# print( country.count( "korea" ) )
# country.sort()
# print( country )
# country.remove( "japan" )
# print( country )
# country.insert( len(country), "japan" )
# print( country )
# country.reverse()
# print( country )
# print( country.pop() )
# print( country )

# 사전 Dictionary
# kim = {
#         "name" : "김유신",
#         "age" : 30,
#         "tel" : "1111-2222",
#         "address" : "서울시"
#     }
# print( kim )
# print( kim["name"] )
# print( len( kim ) )
# print( kim.keys() )
# print( kim.values() )
# for value in kim.values() :
#     print( value )
# for key in kim.keys() :
#     print( kim.get( key ) )
# 
# kim['age']= 40
# print( kim["age"] )
# 
# for (key, value) in kim.items() :
#     print( key, " : ", value )


# 집합 Set
bg = set(["red", "blue", "green", "yellow", "pink"])
fg = set(["pink", "magenta", "cyan", "black", "red"])
print( bg - fg )
print( bg.difference( fg ) )
print( bg & fg )
print( bg.intersection( fg ) )
print( bg | fg )
print( bg.union(fg) )
print( bg.symmetric_difference( fg ) )





















