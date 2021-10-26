package com.example.program6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity2 extends AppCompatActivity {
    TextView xml,json;
    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        xml = (TextView)findViewById(R.id.xml);
        json = (TextView)findViewById(R.id.json);
        mode=getIntent().getIntExtra("mode",0);
        if(mode==1)
            parsexml();
        else
            parsejson();
    }
    public String parsexml()
    {
        InputStream inputStream;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Element element, element2;
        Document document;
        NodeList nList;
        Node node;

        try {
            inputStream = getAssets().open("city.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(inputStream);
            element = document.getDocumentElement();
            element.normalize();
            nList = document.getElementsByTagName("city");
            for (int i=0; i<nList.getLength(); i++) {
                node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    element2 = (Element) node;
                    xml.setText("City Name : " + getValue("Name", element2)+"\n");
                    xml.append("Latitude : " + getValue("Latitude", element2)+"\n");
                    xml.append("Longitude : " + getValue("Longitude", element2)+"\n");
                    xml.append("Temperature : " + getValue("Temperature", element2)+"\n");
                    xml.append("Humidity : " + getValue("Humidity", element2)+"\n");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    public void parsejson()
    {
        InputStream inputStream;
        JSONObject jsonObject, jsonObject1;

        try {
            inputStream=getAssets().open("city.json");
            byte[] data=new byte[inputStream.available()];
            inputStream.read(data);

            String readData=new String(data);
            jsonObject=new JSONObject(readData);
            jsonObject1=jsonObject.getJSONObject("city");
            json.setText("City Name : "+jsonObject1.getString("Name")+"\n");
            json.append("Latitude : "+jsonObject1.getString("Latitude")+"\n");
            json.append("Longitude : "+jsonObject1.getString("Longitude")+"\n");
            json.append("Temperature : "+jsonObject1.getInt("Temperature")+"\n");
            json.append("Humidity : "+jsonObject1.getString("Humidity")+"\n");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}