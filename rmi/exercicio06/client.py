import Pyro4

import json

ipAddressServer = "0.0.0.0"

server = Pyro4.core.Proxy('PYRO:Server@' + ipAddressServer + ':9090')
print(server.handle(json.dumps({ 'name': 'Mozaniel', 'salary': 4000.00, 'level': 'A', 'dependents': 0 })))