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

def event_details(request):
    return render(request, 'event-details.html')

def faq(request):
    return render(request, 'faq.html')
