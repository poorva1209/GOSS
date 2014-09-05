package pnnl.goss.powergrid.topology;

public interface NodeBreakerDataType {
	
	public static final String MRID = "MRID";
	public static final String NAME = "NAME";
	public static final String ALIAS = "ALIAS";
	public static final String PATH = "PATH";
	public static final String DESCRIPTION = "DESCRIPTION";
	public static final String DATA_TYPE = "DATA_TYPE";
	
	public static final String ACCUMULATOR = "ACCUMULATOR";
	public static final String ACCUMULATOR_MRID = "ACCUMULATOR_MRID";
	
	public static final String ACLINESEGMENT = "ACLINESEGMENT";
	public static final String ACLINESEGMENT_MRID = "ACLINESEGMENT_MRID";
	
	public static final String ANALOG = "ANALOG";
	public static final String ANALOG_MRID = "ANALOG_MRID";
	
	public static final String ANALOG_LIMIT = "ANALOG_LIMIT";
	public static final String ANALOG_LIMIT_MRID = "ANALOG_LIMIT_MRID";
	
	public static final String ANALOG_LIMIT_SET = "ANALOG_LIMIT_SET";
	public static final String ANALOG_LIMIT_SET_MRID = "ANALOG_LIMIT_SET_MRID";
	
	public static final String BASE_VOLTAGE = "BASE_VOLTAGE";
	public static final String BASE_VOLTAGE_MRID = "BASE_VOLTAGE_MRID";
	
	public static final String BREAKER = "BREAKER";
	public static final String BREAKER_MRID = "BREAKER_MRID";
	
	public static final String BUS_BAR_SECTION = "BUS_BAR_SECTION";
	public static final String BUS_BAR_SECTION_MRID = "BUS_BAR_SECTION_MRID";
	
	public static final String CONDUCTING_EQUIPMENT = "CONDUCTING_EQUIPMENT";
	public static final String CONDUCTING_EQUIPMENT_MIRD = "CONDUCTING_EQUIPMENT_MIRD";
	
	public static final String CONNECTIVITY_NODE = "CONNECTIVITY_NODE";
	public static final String CONNECTIVITY_NODE_MIRD = "CONNECTIVITY_NODE_MIRD";
	
	public static final String GEOGRAPHICAL_REGION = "GEOGRAPHICAL_REGION";
	public static final String GEOGRAPHICAL_REGION_MRID = "GEOGRAPHICAL_REGION_MRID";
	
	public static final String LINE = "LINE";
	public static final String LINE_MRID = "LINE_MRID";	
	
	public static final String SUB_GEOGRAPHICAL_REGION = "SUB_GEOGRAPHICAL_REGION";
	public static final String SUB_GEOGRAPHICAL_REGION_MRID = "SUB_GEOGRAPHICAL_REGION_MRID";
	
	public static final String SUBSTATION = "SUBSTATION";
	public static final String SUBSTATION_MRID = "SUBSTATION_MRID";
	
	public static final String TERMINAL = "TERMINAL";
	public static final String TERMINAL_MRID = "TERMINAL_MRID";
	
	public static final String VOLTAGE_LEVEL = "VOLTAGE_LEVEL";
	public static final String VOLTAGE_LEVEL_MRID = "VOLTAGE_LEVEL_MRID";
	
	public static final String SYNCHRONOUES_MACHINE = "SYNCHRONOUES_MACHINE";
	
	public static final String MEASUREMENT_TYPE = "MEASUREMENT_TYPE";
	
	public String getDataType();
	
	public void setDataType(String dataType);

}
