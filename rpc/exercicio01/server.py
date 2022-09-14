from xmlrpc.server import SimpleXMLRPCServer
import json

OPERATOR = 0.18
DEVELOPER = 0.20

def handler(data):
    request = json.loads(data)

    def new_salary(request, fee):
        return request.get('salary') + (request.get('salary') * fee)

    if request.get('role') == 'OPERATOR':
        return json.dumps({ 'new_salary': new_salary(request, OPERATOR), 'name': request.get('name') })
    elif request.get('role') == 'DEVELOPER':
        return json.dumps({ 'new_salary': new_salary(request, DEVELOPER), 'name': request.get('name') })

server = SimpleXMLRPCServer(("localhost", 8000))
print("Listening on port 8000...")
server.register_function(handler, "consume")
server.serve_forever()