package com.bhishiapplication.exception;



public class ResourceNotFoundException extends RuntimeException {

	
	
	private static final long serialVersionUID = 1L;
	String resourceName;
	String resourceField;
	long fieldValue;
	
	
	
	public ResourceNotFoundException(String resourceName, String resourceField, long fieldValue) {
		super(String.format("%s not found %s :%s",resourceName,resourceField,fieldValue));
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.fieldValue = fieldValue;
	}
	
	public ResourceNotFoundException() {
		super();
		
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceField() {
		return resourceField;
	}

	public void setResourceField(String resourceField) {
		this.resourceField = resourceField;
	}

	public long getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}


	
	
	
	
	
}
