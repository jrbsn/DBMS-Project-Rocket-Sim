#----- Sign up ------# (use this to connect front end sign up to backend)

import boto3, json

from PyVariMod import variablepasser
username, password = variablepasser()

lambda_client = boto3.client('lambda')
test_event = {
    "username": username,
    "password": password
}
response = lambda_client.invoke(
  FunctionName='Login_Signup',
  Payload=json.dumps(test_event),
)


print(response['Payload'].read().decode("utf-8"))
