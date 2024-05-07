from django.db import models

# Create your models here.
from django.db import models

class Event(models.Model):
    fullname = models.CharField(max_length=100)
    email = models.EmailField()
    phone = models.CharField(max_length=15)
    message = models.TextField()

    def str(self):
        return self.fullname