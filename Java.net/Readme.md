The java.net package in Java provides a set of classes for working with network resources. Here's a summary of the main classes in this package:

URL: Represents a Uniform Resource Locator, which is a reference to a resource on the internet, such as a webpage or a file.

URLConnection: An abstract class that represents a communication link between the application and a URL resource. Provides methods to connect, read and write to the resource.

HttpURLConnection: A subclass of URLConnection that provides support for HTTP-specific features such as HTTP methods (GET, POST, PUT, DELETE), request headers, and response codes.

Socket: Represents a client-side endpoint of a two-way communication link between an application and a server on the internet.

ServerSocket: Represents a server-side endpoint of a two-way communication link between an application and a client on the internet.

DatagramSocket: Provides a datagram-oriented socket, which is used for sending and receiving datagram packets over the internet.

InetAddress: Represents an internet address, which can be either an IPv4 or IPv6 address.

In addition to these classes, the java.net package also provides various utility classes and exceptions related to networking.

The most commonly used classes in this package are URL and HttpURLConnection, which provide the basic functionality for connecting to and retrieving data from web resources. With these classes, you can perform HTTP requests, send data to servers, and receive responses.

You can also use Socket and ServerSocket classes to create network connections between applications and servers, and exchange data over the network.

Overall, the java.net package provides a powerful set of tools for working with network resources in Java, allowing you to build applications that can communicate with servers and exchange data over the internet.


Example 1: Retrieving data from a URL using HttpURLConnection

     import java.net.*;
     import java.io.*;

     public class WebClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
    }
    
    
  This code retrieves the content of a webpage located at "https://www.example.com" using the HttpURLConnection class. The setRequestMethod() method is used to set the request method to "GET", indicating that the application wants to retrieve data from the server. The content of the webpage is then read from the input stream returned by the getInputStream() method of the connection.
   
   Example 2: Creating a server using ServerSocket
   
      import java.net.*;
     import java.io.*;

    public class SimpleServer {
     public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000);

        while (true) {
            Socket client = server.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write("Received: " + line + "\n");
                writer.flush();
            }

            reader.close();
            writer.close();
            client.close();
        }
    }
      }


This code creates a simple server that listens for connections on port 8000 using the ServerSocket class. When a client connects, the server creates a new Socket object for the client and uses it to exchange data. In this example, the server simply reads data from the client using a BufferedReader and writes a response back using a BufferedWriter.

Example 3: Resolving a domain name to an IP address using InetAddress

    import java.net.*;
  
     public class DNSLookup {
      public static void main(String[] args) throws Exception {
        InetAddress[] addresses = InetAddress.getAllByName("www.example.com");

        for (InetAddress address : addresses) {
            System.out.println(address.getHostAddress());
        }
    }
    }
    
  This code uses the InetAddress class to resolve the domain name "www.example.com" to an IP address. The getAllByName() method returns an array of all IP addresses associated with the domain name. In this example, we simply print out the IP addresses to the console.
  
  

