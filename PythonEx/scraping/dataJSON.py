import urllib.request as req
import os.path, random
import json
url = "https://api.github.com/repositories"
filename = "repo.json"
if not os.path.exists( filename ) :
    req.urlretrieve( url, filename )
items = json.load( open( filename, "rt", encoding="utf-8" ) )
for item in items :
    print( item["name"] + " - " + item["owner"]["login"] )    
    