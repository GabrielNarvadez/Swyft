from django.http import HttpResponse
from django.shortcuts import render
import requests
import json
from django.http import JsonResponse, HttpResponse
import requests
from django.http import JsonResponse
from .models import Event
from .models import Organizer
from .serializers import EventSerializer
from .serializers import OrganizerSerializer
from django.views.decorators.csrf import csrf_exempt
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.shortcuts import render
from rest_framework import generics
from .models import Event
from .serializers import EventDisplay
from django.shortcuts import redirect
from django.http import HttpResponseBadRequest
from .services.event_service import EventService

from django.http import JsonResponse

# Create your views here.
def home_screen_view(request):

    context = {}
    return render(request, "personal/home.html", context)
def about(request):
    return render(request, 'about.html')

def contact(request):
    return render(request, 'contact.html')


def events(request):
    # Make a GET request to the REST API endpoint
    api_url = 'http://localhost:8080/api/event/get'
    response = requests.get(api_url)
    
    # Check if the request was successful (status code 200)
    if response.status_code == 200:
        events_data = response.json()
        
        # Pass the data to the template
        return render(request, 'events.html', {'events_data': events_data})
    else:
        # If the request was not successful, handle the error
        error_message = f"Failed to fetch events from API: {response.status_code}"
        return render(request, 'events.html', {'error_message': error_message})  


@csrf_exempt
def event_details(request):
    if request.method == 'POST':
        # Extract form data from the request
        fullname = request.POST.get('fullname')
        email = request.POST.get('email')
        phone = request.POST.get('phone')
        user_message = request.POST.get('user_message')

        # Prepare the data to send to the Spring Boot endpoint
        url = "http://localhost:8080/api/attendees/create" 
        # Adjusted endpoint URL
        headers = {'Content-Type': 'application/json'}  # Set content type to JSON

        # Convert form data to JSON
        data = json.dumps({
            'fullname': fullname,
            'email': email,
            'phone': phone,
            'user_message': user_message
        })

        # Send the JSON data to the Spring Boot endpoint
        response = requests.post(url, data=data, headers=headers)

#Return the response from the endpoint you posted to
        return JsonResponse(response.json())

    elif request.method == 'GET':
        # Handle GET requests by rendering the event-details.html template
        return render(request, 'event-details.html')

def faq(request):
    return render(request, 'faq.html')

def event_delete(request):
    return render(request, 'event-delete.html')

def login(request):
    return render(request, 'login.html')

def event_reg(request):
    return render(request, 'event-reg.html')

@csrf_exempt
def attendance(request, attendees_id):
    if request.method == 'GET':
        # Prepare the URL with the attendees_id
        url = f'http://localhost:8080/api/attendees/mark/attendance={attendees_id}'
        

        # Send the PUT request using requests library
        response = requests.put(url, json={})

        # Check the response status code
        if response.status_code == 200:
            return HttpResponse('PUT request sent successfully')
        else:
            return HttpResponseBadRequest('Failed to send PUT request')
    else:
        return HttpResponseBadRequest('Method not allowed')

@csrf_exempt
def organizers(request):
    if request.method == 'POST':
        # Extract form data from the request
        organizer_name = request.POST.get('organizer_name')
        contact_info = request.POST.get('contact_info')
        events_organized = request.POST.get('events_organized')

        # Prepare the data to send to the Spring Boot endpoint
        url = "http://localhost:8080/api/organizer/create"  # Adjusted endpoint URL
        headers = {'Content-Type': 'application/json'}  # Set content type to JSON

        # Convert form data to JSON
        data = json.dumps({
            'organizer_name': organizer_name,
            'contact_info': contact_info,
            'events_organized': events_organized,
        })

        # Send the JSON data to the Spring Boot endpoint
        response = requests.post(url, data=data, headers=headers)

        #Return the response from the endpoint you posted to
        return render(request, 'organizers.html')
    
    elif request.method == 'GET':
        return render(request, 'organizers.html')
    
        
def organizerView(request):
    api_url = 'http://localhost:8080/api/organizer/get'
    get_response = requests.get(api_url)

    if get_response.status_code == 200:
        organizer_data = get_response.json()
        return render(request, 'organizerView.html', {'organizer_data': organizer_data})
    
    else:
        # If the request was not successful, handle the error
        error_message = f"Failed to fetch events from API: {get_response.status_code}"
        return render(request, 'error.html', {'error_message': error_message})


