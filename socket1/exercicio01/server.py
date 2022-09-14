import json
import socket

BACKLOG = 5

class BaseServer:

    def __init__(self, port, max_size, handler):
        self.port = port
        self.max_size = max_size
        self.handler = handler
    
    def start_server(self):
        host = '0.0.0.0'

        server_socket = socket.socket()
        server_socket.bind((host, self.port))

        print(f"Server started on port {self.port}")

        server_socket.listen(BACKLOG)

        while True:
            connection, address = server_socket.accept()
            self.new_client(connection, address)


    def new_client(self, connection, address):
        while True:
            print(f"Incoming request from host {address}")
            data = connection.recv(self.max_size).decode()
            if not data:
                break
            message = self.handler(data)
            connection.send(message.encode())

        connection.close()

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

server = BaseServer(3001,1024, handler)
server.start_server()