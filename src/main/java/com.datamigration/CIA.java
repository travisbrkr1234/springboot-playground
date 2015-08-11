/* 
* @Author: Jeremiah Marks
* @Date:   2015-08-10 23:22:52
* @Last Modified 2015-08-11
* @Last Modified time: 2015-08-11 02:19:09
*/
package com.datamigration;

/*
Hello and welcome to the CIA. 
I will get to say those lines at some point. 

This is the main processor for the CSV and API endpoints. 

We are going to start with only the XMLRPC library, and then
will later integrate the CSV library.

Note: ./Imports.java is probably a model file, but since it does not deal
with the web, does it matter?

*/

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
import java.io.*;

public class CIA{
    private String appname;
    private String apikey;
    private URL serverAddress;
    private XmlRpcClient connection;
    private XmlRpcClientConfigImpl config;
    private Contact contact;
    private List dataToPass;
    private ArrayList<Map> simplereturn1;

    public CIA(String appname, String apikey) throws MalformedURLException, XmlRpcException {
        this.appname = appname;
        this.apikey = apikey;
        this.serverAddress = new URL("https://" + this.appname + ".infusionsoft.com:443/api/xmlrpc");
        this.config = new XmlRpcClientConfigImpl();
        this.config.setServerURL(this.serverAddress);
        this.connection = new XmlRpcClient();
        this.connection.setConfig(config);
        this.contact = new Contact();
    }
    public CIA(){
        this.appname="";
        this.apikey="";
    }

    public ArrayList<Map> getAllContacts(){
        /*
        This will be written specifically in such a manner
        to get the data that we need right now, 
        */
        return simplereturn1;
    }

}