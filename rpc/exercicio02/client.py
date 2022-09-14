import xmlrpc.client
import json

proxy = xmlrpc.client.ServerProxy("http://localhost:8000/")

message = proxy.consume(json.dumps({ 'age': 19, 'name': 'Mozaniel', 'gender': 'M'}))
print(message)
message = proxy.consume(json.dumps({ 'age': 19, 'name': 'Igor', 'gender': 'M'}))
print(message)
message = proxy.consume(json.dumps({ 'age': 17, 'name': 'Andrey', 'gender': 'F'}))
print(message)
message = proxy.consume(json.dumps({ 'age': 21, 'name': 'Gabriella', 'gender': 'F'}))
print(message)