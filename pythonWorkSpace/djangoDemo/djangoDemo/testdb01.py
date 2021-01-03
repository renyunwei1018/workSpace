from django.http import HttpResponse
from Tstu.models import Tstu


def addStu(request):
    stu = Tstu(id=5,name='马超',age=23,email='machao@sanguo.com')
    stu.save()
    return HttpResponse("<p>君侯云长添加成功</p>")

def queryAll(request):
    rsp=""
    list = Tstu.objects.all()
    for var in list:
        rsp=str(var)+rsp+"\r\n"
        print(rsp)
    return HttpResponse(rsp)

def queryById(request):
    rsp=""
    list = Tstu.objects.filter(id=2)
    for var in list:
        rsp = str(var) + rsp + "\r\n"
        print(rsp)
    return HttpResponse(rsp)