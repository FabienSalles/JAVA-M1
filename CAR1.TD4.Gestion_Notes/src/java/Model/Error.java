/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author fasalles
 */
public class Error {
    
    private Hashtable<String, String> errors;
    private Set<String> globalErrors;

    public Error()
    {
    }

    public Error(String[] properties)
    {
        this.errors = new Hashtable<String, String>();
        this.addProperties(properties);
        this.globalErrors = new HashSet<String>();
    }
    
    public void addProperties(String[] properties)
    {
        for( String prop: properties)
            this.addProperty(prop);
    }
    
    public void addProperty(String prop)
    {
        this.errors.put(prop, "");
    }
    
    public void addError(String key, String val)
    {
        this.errors.remove(key);
        this.errors.put(key, val);
    }
    
    public boolean hasErrors()
    {
        if(this.hasPropertiesErrors())
            return true;
        
        if(this.hasGlobalErrors())
            return true;
        
        return false;
    }
    
    public boolean hasPropertiesErrors()
    {
        for(Entry<String, String> entry: this.errors.entrySet()){
            if(!entry.getValue().equals(""))
                return true;
        }
        return false;
        
    }
    public boolean hasGlobalErrors()
    {
        return !this.globalErrors.isEmpty();
    }
    
    public void addGlobalError(String error)
    {
        this.globalErrors.add(error);
    }
    
    public void resetErrors()
    {
        if(this.hasGlobalErrors())
            this.globalErrors.removeAll(this.globalErrors);
        
        if(this.hasPropertiesErrors()){
            for(Entry<String, String> entry: this.errors.entrySet()){
                if(!entry.getValue().equals("")){
                    this.errors.remove(entry.getKey());
                    this.errors.put(entry.getKey(), entry.getValue());
                }
            }
        }

    }
    public String renderError(String property)
    {
        if(this.errors.get(property).equals(""))
            return "";
        
        return "<p class='text-error'>"+this.errors.get(property)+"</p>";
    }
    
    public String renderGlobalErrors()
    {
        String errors = "";
        
        if(this.hasGlobalErrors()){
            errors += "<ul class='unstyled text-error'>";
            for(String error: this.globalErrors)
                errors += "<li>"+error+"</li>";
            errors += "</ul>";
        }
        
        return errors;
    }
    
}
