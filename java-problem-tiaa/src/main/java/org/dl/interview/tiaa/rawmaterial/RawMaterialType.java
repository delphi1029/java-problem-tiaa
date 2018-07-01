package org.dl.interview.tiaa.rawmaterial;

public enum RawMaterialType {
	
	BOLT("Bolt") ,
	MACHINE("Machine");
	
	private String name;
	
	private RawMaterialType (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
