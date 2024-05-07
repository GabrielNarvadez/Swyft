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
class EventDisplay(models.Model):
    event_title = models.CharField(max_length=100)
    date = models.DateField()
    details = models.TextField()
    location = models.CharField(max_length=100)
    event_venue_id = models.IntegerField()
    attendee_count = models.IntegerField()

    def __str__(self):
        return self.event_title