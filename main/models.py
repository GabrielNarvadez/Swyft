# Create your models here.
from django.db import models

class Event(models.Model):
    fullname = models.CharField(max_length=100)
    email = models.EmailField()
    phone = models.CharField(max_length=15)
    message = models.TextField()

    def str(self):
        return self.fullname
<<<<<<< Updated upstream
class EventDisplay(models.Model):
    event_title = models.CharField(max_length=100)
    date = models.DateField()
    details = models.TextField()
    location = models.CharField(max_length=100)
    event_venue_id = models.IntegerField()
    attendee_count = models.IntegerField()

    def __str__(self):
        return self.event_title
=======
    
class Organizer(models.Model):
    organizer_name = models.CharField(max_length=100)
    contact_info = models.EmailField()
    event_organized = models.CharField(max_length=100)

    def __str__(self):
        return self.organizer_name
>>>>>>> Stashed changes
