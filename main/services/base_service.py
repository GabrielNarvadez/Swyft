class BaseService:
    def process_data(self, data):
        """
        Process data in a generic way, which can be overridden by subclasses.
        This method does nothing by default and is meant to be overridden.
        """
        pass

    def execute_action(self):
        """
        Execute an action, to be defined in subclasses.
        This method does nothing by default and is meant to be overridden.
        """
        pass
