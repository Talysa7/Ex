# 실행 시 매개변수 전달
#!/usr/bin/env python3      #./download_args.py 109 형식으로 실행
                            # python3 download_args.py 109

import sys
import urllib.request as req
import urllib.parse as ps
if __name__ == '__main__':
    if len( sys.argv ) <= 1 :
        print( "download_args <지역번호>" )
        sys.exit()
    number = sys.argv[1]  
    url = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"
    values = {
        "stnid" : number
    }  
    params = ps.urlencode( values )
    url = url + "?" + params
    print( url )
    data = req.urlopen( url ).read()
    txt = data.decode( "utf-8" )
    print( txt )
    
    
    
    
    
    
    
    
    
    
    