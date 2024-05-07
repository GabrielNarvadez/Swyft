from rest_framework import serializers
from .models import Event
from .models import Organizer
from .models import EventDisplay


class EventSerializer(serializers.ModelSerializer):
    class Meta:
        model = Event
        fields = ['id', 'fullname', 'email', 'phone', 'message']

class OrganizerSerializer(serializers.ModelSerializer):
    class Meta:
        model = Organizer
        fields = ['id', 'organizer_name', 'contact_info', 'event_organized']


class EventDisplaySerializer(serializers.ModelSerializer):
    class Meta:
        model = EventDisplay
        fields = ['event_title', 'date', 'details', 'location', 'event_venue_id', 'attendee_count']
