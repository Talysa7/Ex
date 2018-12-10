# 예외처리
class InputException(Exception):
    def __init__(self, length ) :
        Exception.__init__(self)
        self.length = length
        print( "입력받은 길이 : ", length )
class NumberException(Exception) :
    def __init__(self):
        print( "문자만 입력하세요" )

try :
    msg = input( "입력 : " )
    if len(msg) < 3 or len( msg ) > 10 :
        raise InputException( len(msg) )
    if msg.isdigit() :
        raise NumberException()
except InputException :
    print( "InputException 발생 " )
except NumberException :
    print( "NumberException 발생" )            
else :
    print( msg )
finally :
    print( "프로그램 끝" )    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
