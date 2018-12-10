# 표준 모듈
import sys
print( sys.path )
print( sys.version_info )
print( sys.version_info.major, ".", sys.version_info.minor )
for i in sys.argv :
    print( i )
    
# logging 모듈
import os, platform, logging
# print( platform.platform() )
if platform.platform().startswith("Window") :
    logfile = os.path.join(os.getenv("HOMEDRIVE"), os.getenv("HOMEPATH"), "test.log" )
else :
    logfile = os.path.join(os.getenv("HOME"), "test.log" )
print( logfile )
logging.basicConfig(
    level=logging.ERROR,
    format="%(asctime)s : %(levelname)s : %(message)s",
    filename = logfile, 
    filemode = "w"
    )
logging.debug( "Start Program" )
logging.info( "Doing" )
logging.warning( "Warning" )
logging.error( "Error" )

# CRITICAL    50
# ERROR       40
# WARNING     30
# INFO        20
# DEBUG       10
# NOTSET      0








    
    