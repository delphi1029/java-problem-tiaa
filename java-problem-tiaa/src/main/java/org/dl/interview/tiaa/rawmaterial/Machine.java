package org.dl.interview.tiaa.rawmaterial;

public class Machine implements RawMaterial{

	@Override
	public RawMaterialType getType() {
		return RawMaterialType.MACHINE;
	}

}
