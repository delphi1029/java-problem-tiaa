package org.dl.interview.tiaa.rawmaterial;

public class Bolt implements RawMaterial{

	@Override
	public RawMaterialType getType() {
		return RawMaterialType.BOLT;
	}
	
}
