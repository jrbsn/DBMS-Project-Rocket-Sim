import sys

def main():
    if len(sys.argv) == 3:  # Expecting username and password
        username = sys.argv[1]
        password = sys.argv[2]
        
        # Here you can add logic to process the username and password
        # For this example, I'm just printing them
        print(f"Username: {username}")
        print(f"Password: {password}")

        # Add your logic for authentication or any other process
        # ...
    else:
        print("Expected 2 arguments: username and password.")

if __name__ == "__main__":
    main()