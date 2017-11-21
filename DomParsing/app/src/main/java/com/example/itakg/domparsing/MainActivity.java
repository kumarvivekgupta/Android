package com.example.itakg.domparsing;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    PlaceHolderFragement fragement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            fragement = new PlaceHolderFragement();
            getSupportFragmentManager().beginTransaction().add(fragement, "MyFragment");
        } else {
            fragement = (PlaceHolderFragement) getSupportFragmentManager().findFragmentByTag("MyFragment");
        }
        fragement.startTask();
    }

    public static class PlaceHolderFragement extends Fragment {
        TechCrunchTask downloadTask;

        public PlaceHolderFragement() {
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setRetainInstance(true);
        }

        public void startTask() {
            if (downloadTask != null)
                downloadTask.cancel(true);
            else {
                downloadTask = new TechCrunchTask();
                downloadTask.execute();
            }
        }
    }

    public static class TechCrunchTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            String downloadURL = "http://feeds.feedburner.com/techcrunch/android?format=xml";
            try {
                URL url = new URL(downloadURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                InputStream stream = httpURLConnection.getInputStream();
                processXML(stream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public void processXML(InputStream stream) throws Exception {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(stream);
            Element root = xmlDocument.getDocumentElement();
//            Log.i("Root", "" + root.getTagName());
            NodeList nodeList = root.getElementsByTagName("item");
            NodeList itemChildren;
            Node currentItem;
            Node currentChildren;
            int count = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                currentItem = nodeList.item(i);
                // Log.i("ITEMS", "" + currentItem.getNodeName());
                itemChildren = currentItem.getChildNodes();
                for (int j = 0; j < itemChildren.getLength(); j++) {
                    currentChildren = itemChildren.item(j);
                    //  Log.i("CHILD", "" + currentChildren.getNodeName());
                    if (currentChildren.getNodeName().equalsIgnoreCase("title")) {
                        // Log.i("Title", "" + currentChildren.getTextContent());
                    }
                    if (currentChildren.getNodeName().equalsIgnoreCase("media:thumbnail")) {
                        count++;
//                        attributes = currentChildren.getAttributes();
//                        for (int k = 0; k < attributes.getLength(); k++) {
//                            currentAttribute = attributes.item(k);
//                            if (currentAttribute.getNodeName().equalsIgnoreCase("url")) {
//                                Log.i("URL", "" + currentAttribute.getTextContent());
//                            }
//                        }
//                        Log.i("url", "" + currentChildren.getAttributes().item(0).getTextContent());
//                        Log.i("Count", "" + count);
                        if (count == 1) {
                            Log.i("url", "" + currentChildren.getAttributes().item(0).getTextContent());
                        }

                    }
                }
                count = 0;

            }
        }
    }
}
