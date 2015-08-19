/*
* @Author: Jeremiah Marks
* @Date:   2015-08-18 21:38:43
* @Last Modified 2015-08-19
* @Last Modified time: 2015-08-19 02:24:21
*/
package com.datamigration.business.entities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class CustomField {
    private String dataType = null;
    private String defaultValue = null;
    private String formId = null;
    private String groupId = null;
    private String id = null;
    private String label = null;
    private String listRows = null;
    private String name = null;
    private String values = null;
    private final String[] columns = {"DataType", "DefaultValue", "FormId", "GroupId", "Id", "Label", "ListRows", "Name", "Values"};


    public CustomField() {
        /*Why do I do this?*/
        super();
    }

    public void setDataType(String dataType){
        this.dataType = dataType;
    }
    public void setDefaultValue(String defaultValue){
        this.defaultValue = defaultValue;
    }
    public void setFormId(String formId){
        this.formId = formId;
    }
    public void setGroupId(String groupId){
        this.groupId = groupId;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setLabel(String label){
        this.label = label;
    }
    public void setListRows(String listRows){
        this.listRows = listRows;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setValues(String values){
        this.values = values;
    }

    public String getDataType(){
        return this.dataType;
    }
    public String getDefaultValue(){
        return this.defaultValue;
    }
    public String getFormId(){
        return this.formId;
    }
    public String getGroupId(){
        return this.groupId;
    }
    public String getId(){
        return this.id;
    }
    public String getLabel(){
        return this.label;
    }
    public String getListRows(){
        return this.listRows;
    }
    public String getName(){
        return this.name;
    }
    public String getValues(){
        return this.values;
    }

    public String[] getCols(){
        return this.columns;
    }
}



// tables["DataFormField"] = ["DataType", "DefaultValue", "FormId", "GroupId", "Id", "Label", "ListRows", "Name", "Values"]

