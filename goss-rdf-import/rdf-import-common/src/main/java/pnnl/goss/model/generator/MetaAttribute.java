package pnnl.goss.model.generator;

public class MetaAttribute {

	private String documentation;
	private String attributeName;
	private MetaDataType dataType;
	private String initialValue;
	private String setterFunctionName;
	private String getterFunctionName;
	private String dataTypePackage;
	
	public String getDataTypePackage() {
		return dataTypePackage;
	}

	public void setDataTypePackage(String dataTypePackage) {
		this.dataTypePackage = dataTypePackage;
	}
	
	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
		String baseName = attributeName.substring(0, 1).toUpperCase()+
				attributeName.substring(1);
		this.setterFunctionName = "set"+baseName;
		this.getterFunctionName = "get"+baseName;
	}

	public MetaDataType getDataType() {
		return dataType;
	}

	public void setDataType(MetaDataType dataType) {
		this.dataType = dataType;
	}

	public String getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}

	public String getAttributeDeclaration(){
		StringBuffer buf = new StringBuffer();		
		
		if (documentation != null){
			buf.append("/**\n* " + documentation+ "\n*/\n");
		}
		if (dataType.getValueType() != null && dataType.getValueType().length() > 0){
			buf.append("private "+dataType.getValueType()+" "+ attributeName+ ";\n");
		}
		else{
			buf.append("private "+dataType.getDataTypeName()+" "+ attributeName+ ";\n");
		}
		
		return buf.toString();
	}
	
	public String getFunctionDefinitions(){
		StringBuffer buf = new StringBuffer();
		
		buf.append("public void ");
		if (dataType.getValueType() != null && dataType.getValueType().length() > 0){
			buf.append(setterFunctionName+"("+dataType.getValueType()+" "+attributeName+") {\n\t");
		}
		else{
			buf.append(setterFunctionName+"("+dataType.getDataTypeName()+" "+attributeName+") {\n\t");
		}
		buf.append("this."+attributeName+" = "+attributeName+";\n}\n\n");
		
		if (dataType.getValueType() != null && dataType.getValueType().length() > 0){
			buf.append("public "+dataType.getValueType()+" ");
		}
		else{
			buf.append("public "+dataType.getDataTypeName()+" ");
		}
		buf.append(getterFunctionName+"() {\n\t"); 
		buf.append("return this."+attributeName+";\n}\n\n");

		return buf.toString();
	}
	
	@Override
	public String toString(){
		
		if (dataType != null){
			return "Attribute: "+attributeName+" "+dataType.toString();
		}
		else{
			return "Attribute: "+attributeName+" ";
		}
	}
		
	

}