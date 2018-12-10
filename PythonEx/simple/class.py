# 클래스
# class Person :
#     __name = "홍길동"
#     age = 30
#     def getName(self) :
#         return self.__name
#     def getAge(self) :
#         return self.age
# hong = Person()
# # print( hong.__name )  
# print( hong.getName() )  
# print( hong.age )
from abc import abstractmethod

# class Person :
#     def __init__(self, name="noname", age=0 ) :
#         self.__name = name
#         self.age = age
#     def getName(self) :
#         return self.__name
#     def getAge(self) :
#         return self.age
#     def __del__(self) :
#         print( "소멸자" )        
#              
# hong = Person( "홍길동", 30 )
# print( hong.getName() )  
# print( hong.age )
# del hong
#  
# kim = Person()
# print( kim.getName() )  
# print( kim.age )


# 상속
class Animal :
    def __init__(self, age ) :
        self.age = age
    def getAge(self) : 
        return self.age
    @abstractmethod
    def heart(self) :
        return "Animal"         
    
class Pet :
    def __init__(self, name ) :
        self.name = name
    def getName(self) : 
        return self.name    

class Dog (Animal, Pet) :
    def __init__(self, age, name, sound ) :
        Animal.__init__(self, age)
        Pet.__init__(self, name)
        self.sound = sound
    def getSound(self) :
        return self.sound
    @abstractmethod
    def heart(self):
        return Animal.heart(self)

class Cat (Animal, Pet):
    def __init__(self, age, name, sound ) :
        Animal.__init__(self, age)
        Pet.__init__(self, name)
        self.sound = sound
    def getSound(self) :
        return self.sound  
    @abstractmethod
    def heart(self):
        return "Cat"
      
class Pig (Animal):
    def __init__(self, age, sound ) :
        Animal.__init__(self, age)
        self.sound = sound
    def getSound(self) :
        return self.sound
    @abstractmethod
    def heart(self):
        return "Pig"

# 상속 다중상속 다형성
lucky = Dog( 5, "럭키", "왈왈 왈왈" )
print( lucky.getAge() )
print( lucky.getName() )
print( lucky.getSound() )
print( lucky.heart() )

navi = Cat( 3, "나비", "야옹 야옹" )
print( navi.getAge() )
print( navi.getName() )
print( navi.getSound() )

pork = Pig( 10, "꿀꿀 꿀꿀" )
print( pork.getAge() )
print( pork.getSound() )










