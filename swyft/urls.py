"""
URL configuration for swyft project.

The `urlpatterns` list routes URLs to  For more information please see:
    https://docs.djangoproject.com/en/4.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from django.conf import settings
from django.conf.urls.static import static
from main.views import (
    home_screen_view,
    about,
    contact,
    event_details,
    events,
    faq,
    event_delete,
    login,
)

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', home_screen_view, name='index'),
    path('about/', about, name='about'),
    path('contact/', contact, name='contact'),
    path('events/', events, name='events'),
    path('event-details/', event_details, name='event_details'),
    path('faq/', faq, name='faq'),
    path('event-delete/', event_delete, name='event_delete'),
    path('login/', login, name='login')
]+ static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)
