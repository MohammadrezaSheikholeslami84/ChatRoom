
# Chat Room

Chat Room is a simple multithreaded chat server written in Java. It allows multiple clients to connect to the server, exchange messages, and broadcast messages to all connected clients using Jave Socket

## Features

- Multi-client support
- Nickname assignment
- Broadcast messages to all clients
- Graceful shutdown

## Prerequisites

- Java Development Kit (JDK) 8 or higher

## Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/yourusername/chat-server.git
    cd chat-server
    ```

2. **Compile the project**:

    ```bash
    javac Server.java Client.java
    ```

## Usage

### Starting the Server

1. **Start the server**:

    ```bash
    java Server
    ```

   The server will start running on port 9999.

### Connecting a Client

1. **Start a client**:

    ```bash
    java Client
    ```

2. **Interaction**:

   - When a client connects, they will be prompted to enter their name.
   - Clients can send messages that will be broadcast to all connected clients.
   - To quit the chat, type `/quit`.

## Example

### Starting the Server

```bash
java Server
```

Output:
```
Chat Server is running on port 1234
```

### Connecting with a Client

1. **Start the client**:

    ```bash
    java Client
    ```

2. **Enter your nickname and start chatting**:

    ```
    Please Enter your Name :
    John
    John Connected!
    ```

3. **Chat messages**:

    ```
    John: Hello, everyone!
    ```
    
## Demo

### Server :
![image](https://github.com/MohammadrezaSheikholeslami84/ChatRoom/assets/166950228/8bbee7c0-3fdd-4e9f-8a26-3bea1ff25f54)

### Clients : 
![image](https://github.com/MohammadrezaSheikholeslami84/ChatRoom/assets/166950228/09790dca-4083-46b5-8d4b-83bc802ed6ea) ![image](https://github.com/MohammadrezaSheikholeslami84/ChatRoom/assets/166950228/9189bf80-0ff9-4cc8-9662-8a2e3c20f701) ![image](https://github.com/MohammadrezaSheikholeslami84/ChatRoom/assets/166950228/08d066a6-90fc-4052-9a40-2af423f2b2c4)


## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a pull request

