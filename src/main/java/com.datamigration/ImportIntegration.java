/*
* @Author: Jeremiah Marks
* @Date:   2015-08-18 20:36:11
* @Last Modified 2015-08-19
* @Last Modified time: 2015-08-19 22:12:15
*/

/*"Plans for the night"
18August2015:
    Check if 'FK' exists as a custom field.
    Create if it does not.
    Do search for contactID and FK
    Open file
*/
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
import java.util.Arrays;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


import org.springframework.web.multipart.MultipartFile;

public class ImportIntegration {

    private ArrayList defaultTemplate;
    /*  This will hold the default data for an API call*/

    /*      I wonder how feasiable it would be to just have a
            series of defaulttemplates available to make needed
            calls from.  Seems like the right thing to do.
    */
    private ArrayList dataToPass;
    private boolean connected = false;
    /*This tracks whether the app name and apikey have been validated*/
    private boolean fileuploaded;
    private HashMap submitData;
    private int numExistingContacts=0;
    private int results;
    private MultipartFile file;
    private String apiKey = null;
    private String appName = null;
    private String uniqueIDField = null;
    /*These are set to null so that I can use them to display
    appropriate areas of the site.*/
    private String name;
    private URL serverAddress;
    private XmlRpcClient connection;
    private XmlRpcClientConfigImpl config;
    private ArrayList customFields;



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
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(this.name)));
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
        } finally {
            if(this.connected){
                this.connected=this.connected;
            }
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
        }catch (XmlRpcException|MalformedURLException e) {
          this.connected=false;
      } finally{}
    }

    public int getNumExistingContacts() throws XmlRpcException{
        int numofRecords=-1;
        try{
            numofRecords=(int)this.getRecordsOnTable("Contact");
        }catch(XmlRpcException e){}
        finally{
            return numofRecords;
        }
    }
    public int getRecordsOnTable(String tableName) throws XmlRpcException{
        /*This is intended to allow a user to see how many records they are about to pull*/
        /*so that they can make appropriate room for them.*/
        int records=-1;
        this.submitData= new HashMap();
        this.dataToPass = new ArrayList();
        this.dataToPass.add(this.apiKey);
        this.dataToPass.add(tableName);
        this.dataToPass.add(this.submitData);
        if (this.connected){
            try {
                records = (int) this.connection.execute("DataService.count", this.dataToPass);
            }catch (XmlRpcException e){}
        }
        return records;
    }

    public boolean getConnected(){
        try{
            this.connect();
        }catch(XmlRpcException|MalformedURLException e){}
        return this.connected;
    }

    public boolean checkForCustomField(String fieldName){
        /*This should probably be set up in such a way*/
        /*that is has some sort of @ decarator to help*/
        /*ensure it can only be ran after it connected*/
        boolean thisResult = false;
        this.submitData= new HashMap();
        this.submitData.put("Name", "_FK");
        this.dataToPass = new ArrayList();
        this.dataToPass.add(this.apiKey);
        this.dataToPass.add("DataFormField");
        this.dataToPass.add(this.submitData);

        int results = 0;
        try{
            results = (int) this.connection.execute("DataService.count", this.dataToPass);
        } catch(XmlRpcException e){}
        finally{
            if(results>0){
                thisResult = true;
            }
            return thisResult;
        }
    }

}
