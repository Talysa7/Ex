# encoding=utf-8
import io
f = io.open("abc.txt", "wt", encoding="utf-8")
f.write("우리나라 대한민국\n")
f.write(u"우리나라 대한민국\n")
f.close()

f = io.open("abc.txt", "rt", encoding="utf-8")
text = f.read()
print(text)
