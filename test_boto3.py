import boto3, json
from botocore.config import Config
from PyVariMod import variablepasser
mass, drag, diameter = variablepasser()
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
