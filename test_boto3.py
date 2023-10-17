import boto3, json
from botocore.config import Config


lambda_client = boto3.client('lambda')
test_event = {
    "diameter": 4,
    "cd": 0.5,
    "mass": 4
}
response = lambda_client.invoke(
  FunctionName='simpleMathModel',
  Payload=json.dumps(test_event),
)
#print(response['Payload'])

apogee = float(response['Payload'].read().decode("utf-8"))
#print(response['Payload'].read().decode("utf-8"))

print("Altitude: %i ft" % apogee)
