# 사용자 정의 모듈

# import module.mymodule
# module.mymodule.hello()
# module.mymodule.bye()
# print( module.mymodule.__version__ )
#  
# from module import mymodule
# mymodule.hello()
# mymodule.bye()
# print( mymodule.__version__ )
# 
# from module.mymodule import hello, bye, __version__
# hello()
# bye()
# print( __version__ )
# 
# from module.mymodule import *
# hello()
# bye()

# import sys
# sys.path.insert(0, "/module/mymodule.py")
# import mymodule
# mymodule.hello()
# mymodule.bye()
# print( mymodule.__version__ )

from simple import yourmodule
yourmodule.hello()
yourmodule.bye()
print( yourmodule.__version__ )














