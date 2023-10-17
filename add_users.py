import boto3, json

lambda_client = boto3.client('lambda')
test_event = {
    "firstName": "Josh",
    "userName": "pianoMan",
    "password": "p1an0"
}
response = lambda_client.invoke(
  FunctionName='manipulateData',
  Payload=json.dumps(test_event),
)


print(response['Payload'].read().decode("utf-8"))
