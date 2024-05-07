from .base_service import BaseService

class EventService(BaseService):
    def process_data(self, data):
        """
        Specific implementation for processing event data.
        """
        print(f"Processing data for event: {data}")

    def execute_action(self):
        """
        Specific actions to execute for event management.
        """
        print("Executing event-specific action.")
