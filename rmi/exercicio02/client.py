import Pyro4

import json

ipAddressServer = "0.0.0.0"

server = Pyro4.core.Proxy('PYRO:Server@' + ipAddressServer + ':9090')
print(server.handle(json.dumps({ 'age': 19, 'name': 'Mozaniel', 'gender': 'M'})))
print(server.handle(json.dumps({ 'age': 19, 'name': 'Igor', 'gender': 'M'})))