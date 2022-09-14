import Pyro4
import json

from socket1.exercicio01.server import DEVELOPER

OPERATOR = 0.18
DEVELOPER = 0.20

@Pyro4.expose
class Server:
        
    def handle(self, data):
        request = json.loads(data)

        def new_salary(request, fee):
            return request.get('salary') + (request.get('salary') * fee)

        if request.get('role') == 'OPERATOR':
            return json.dumps({ 'new_salary': new_salary(request, OPERATOR), 'name': request.get('name') })
        elif request.get('role') == 'DEVELOPER':
            return json.dumps({ 'new_salary': new_salary(request, DEVELOPER), 'name': request.get('name') })

Pyro4.Daemon.serveSimple({
    Server: 'Server',
}, host="0.0.0.0", port=9090, ns=False, verbose=True) 