from django.db import models

# Create your models here.
class Tstu(models.Model):
    id = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=255, blank=True, null=True)
    age = models.IntegerField(blank=True, null=True)
    email = models.CharField(max_length=255, blank=True, null=True)
    def __str__(self):
        return "编号：{}，姓名：{}，年龄：{}，邮箱：{}".format(self.id,self.name,self.age,self.email)
    class Meta:
        managed = False
        db_table = 'tstu'
