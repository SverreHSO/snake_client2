package sdk;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by sverreostgaard on 25.11.15.
 */
public class ServerConnect {

    String host;
    int port;


    public ServerConnect()
    {
        this.host = "http://localhost";
        this.port = 8888;
    }


    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    public String get(String path)
    {

        Client client = Client.create();
        WebResource webResource = client.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        String message = response.getEntity(String.class);

        if (response != null)
        {
            return message;
        }
        return "";

    }

    public String post(String json, String path)
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        if (response != null)
        {
            return response.getEntity(String.class);
        }

        return "";
    }

    public String put(String json, String path)
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        if (response != null)
        {
            return response.getEntity(String.class);
        }
        return "";
    }

    public String delete(String path)
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        return response.getEntity(String.class);
    }

    public String stringMessageParser(String json)
    {
        JSONParser jsonParser = new JSONParser();

        String message = "";
        try
        {
            Object obj = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            message = ((String) jsonObject.get("message"));

        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return message;

    }



}
