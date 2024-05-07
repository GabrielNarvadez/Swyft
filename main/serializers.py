from rest_framework import serializers
from .models import Event
from .models import EventDisplay


class EventSerializer(serializers.ModelSerializer):
    class Meta:
        model = Event
        fields = ['id', 'fullname', 'email', 'phone', 'message']

class EventDisplaySerializer(serializers.ModelSerializer):
    class Meta:
        model = EventDisplay
        fields = ['event_title', 'date', 'details', 'location', 'event_venue_id', 'attendee_count']
