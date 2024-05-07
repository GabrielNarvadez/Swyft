from django.http import HttpResponse
from django.shortcuts import render
import requests
import json
from django.http import JsonResponse, HttpResponse
import requests
from django.http import JsonResponse
from .models import Event
from .serializers import EventSerializer
from django.views.decorators.csrf import csrf_exempt
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.shortcuts import render

# Create your views here.
def home_screen_view(request):

    context = {}
    return render(request, "personal/home.html", context)
def about(request):
    return render(request, 'about.html')

def contact(request):
    return render(request, 'contact.html')

def events(request):
    return render(request, 'events.html')

@csrf_exempt
def event_details(request):
    if request.method == 'POST':
        # Extract form data from the request
        fullname = request.POST.get('fullname')
        email = request.POST.get('email')
        phone = request.POST.get('phone')
        user_message = request.POST.get('user_message')

        # Prepare the data to send to the Spring Boot endpoint
        url = "http://localhost:8080/api/attendees/create"  # Adjusted endpoint URL
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