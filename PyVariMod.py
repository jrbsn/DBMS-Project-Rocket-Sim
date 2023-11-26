# python test script for passing variables
import sys, boto3, json
from botocore.config import Config

def variableapasser():
    if len(sys.argv) == 4: # Checking if 3 arguments are passed (sys.argv[0] is the script name itself)
        # AHHHHH I FIGURED OUT THE LIBRARY THING
        mass = float(sys.argv[1])
        drag = float(sys.argv[2])
        diameter = float(sys.argv[3])
        # test values for variable passing check{
        print(f"Mass: {mass}")
        print(f"Drag: {drag}")
        print(f"Diameter: {diameter}")
        # }
        return mass, drag, diameter
    else:
        print("Expected 3 arguments: mass, drag, and diameter.")
        return 0


mass, drag, diameter = variableapasser()

lambda_client = boto3.client('lambda')
test_event = {
    "diameter": diameter,
    "cd": drag,
    "mass": mass
}
response = lambda_client.invoke(
  FunctionName='simpleMathModel',
  Payload=json.dumps(test_event),
)
#print(response['Payload'])

apogee = float(response['Payload'].read().decode("utf-8"))
#print(response['Payload'].read().decode("utf-8"))

print("Altitude: %i ft" % apogee)