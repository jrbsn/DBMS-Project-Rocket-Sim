#------ Login ------#

import boto3, json

from PyVariMod import variablepasser
type, username, password = variablepasser() # type: 0 for signup, 1 for login

lambda_client = boto3.client('lambda')
test_event = {
    "type": type,
    "username": username,
    "password": password
}
response = lambda_client.invoke(
  FunctionName='Login_Signup',
  Payload=json.dumps(test_event),
)


print(response['Payload'].read().decode("utf-8"))
