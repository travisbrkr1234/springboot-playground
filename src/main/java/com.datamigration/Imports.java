/* 
* @Author: Jeremiah Marks
* @Date:   2015-08-10 23:33:00
* @Last Modified 2015-08-11
* @Last Modified time: 2015-08-11 01:33:38
*/
package com.datamigration;

import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.*;

import java.net.URL;
import java.net.MalformedURLException;

import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.*;


interface Imports {

    ArrayList<Map> getAllContacts();
    // Integer createContact(Map contactData);
    // ArrayList<Map> getContactsAndFK();

    // ArrayList<Map> getCSVData(String pathToCSV);
    // void saveCSVData(ArrayList<Map> datum);

}
