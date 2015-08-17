package com.datamigration;

import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.*;

import org.apache.commons.csv.*;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


import org.springframework.web.multipart.MultipartFile;

public class ImportIntegration {

    private String appName = null;
    private String apiKey = null;
    private String name;
    private MultipartFile file;
    private boolean fileuploaded;
    private XmlRpcClient connection;
    private XmlRpcClientConfigImpl config;
    private URL serverAddress;
    private ArrayList dataToPass;
    private HashMap submitData;
    private int results;
    private boolean connected = false;
    private int numExistingContacts=0;
          
    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }


    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFile(MultipartFile file){
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                this.fileuploaded=true;
            } catch (Exception e) {
                this.fileuploaded=false;
            }
        }
    public void createConnection() throws MalformedURLException{
        try{
            this.serverAddress = new URL("https://" + this.appName + ".infusionsoft.com:443/api/xmlrpc");
            this.config = new XmlRpcClientConfigImpl();
            this.config.setServerURL(this.serverAddress);
            this.connection = new XmlRpcClient();
            this.connection.setConfig(config);
            this.connected=true;
        }catch (MalformedURLException e){
            this.connected=false;
        }
    }
    public void connect() throws XmlRpcException, MalformedURLException{
        this.submitData= new HashMap();
        this.connected=false;
        try {
            this.createConnection();
            this.dataToPass = new ArrayList();
            this.dataToPass.add(this.apiKey);
            this.dataToPass.add("Contact");
            this.dataToPass.add(this.submitData);
            this.results =  (int)this.connection.execute("DataService.count", this.dataToPass);
            this.connected=true;
        }catch (XmlRpcException e) {
          this.connected=false;
      }
    }
    public int getNumExistingContacts() throws XmlRpcException{
        this.submitData= new HashMap();
        this.dataToPass = new ArrayList();
        this.dataToPass.add(this.apiKey);
        this.dataToPass.add("Contact");
        this.dataToPass.add(this.submitData);
        if (this.connected){
            try {
                this.numExistingContacts = (int) this.connection.execute("DataService.count", this.dataToPass);
            }catch (XmlRpcException e){}
        }
        return this.numExistingContacts;
    }
    public boolean getConnected(){
        try{
            this.connect();
        }catch(XmlRpcException|MalformedURLException e){}
        return this.connected;
    }
}