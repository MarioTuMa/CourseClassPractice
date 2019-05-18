class Node:

    def __init__(self, next, prev, val):
        self.val = val
        self.next = next
        self.prev = prev
    def swapNext(self,input):
        self.next = input
    def swapPrev(self,input):
        self.prev = input
    def hasNext(self):
        if self.next is None:
            return False
        return True
    def getVal(self):
        return self.val
class LinkedList:

    def __init__(self, firstVal):
        self.head = Node(None,None,firstVal)
        self.tail = self.head
        self.count = 1
    def pushHead(self,val):
        n = Node(self.head,None,val)
        self.head.swapPrev(n)
        self.head=n
        self.count+=1
    def pushTail(self,val):
        n = Node(None,self.tail,val)
        self.tail.swapNext(n)
        self.tail=n
        self.count+=1
    def toString(self):
        looper = self.head

        string = ""
        while(looper.hasNext()):
            #print("hi")
            string+=str(looper.getVal())+" "
            looper = looper.next

        string+=str(looper.getVal())
        return string
    def popTail(self):
        toReturn = self.tail.val
        print(toReturn)
        self.tail = self.tail.prev
        self.tail.next = None
        self.count-=1
        return(toReturn)
    def peakTail():
        return self.tail.val
    def popHead(self):
        toReturn = self.head.val
        self.head = self.head.next
        self.head.prev = None
        self.count-=1
        return toReturn
    def peakHead(self):
        return self.head.val
    def getSize(self):
        return self.count

class Stack:
    def __init__(self, firstData):
        self.data = LinkedList(firstData)
    def push(self,val):
        self.data.pushHead(val)
    def pop(self):
        return self.data.popHead()
    def peak(self):
        return self.data.peakHead()
    def toString(self):
        return self.data.toString()
    def reverse(self):
        newData = LinkedList(self.data.popHead())
        while(self.data.getSize()>1):
            newData.pushHead(self.data.popHead())
        newData.pushHead(self.data.peakHead())
        self.data = newData


LL = LinkedList(3)
print(LL.toString())
LL.pushHead(4)
LL.pushHead(5)
print(LL.toString())
LL.pushTail(6)
LL.pushTail(7)
print(LL.toString())
LL.popTail()
print(LL.toString())
print(LL.getSize())
s = Stack(3)
s.push(3)
s.push(4)
s.push(5)
s.push(13)
s.push(14)
s.push(15)
print(s.toString())
print(s.pop())
print(s.toString())
s.reverse()
print(s.toString())
