package com.redeskyller.bukkit.lib.nbt;

public enum NBTType
{

	END(0), BYTE(1), SHORT(2), INT(3), LONG(4), FLOAT(5), DOUBLE(6), BYTE_ARRAY(7), STRING(8), LIST(9), COMPOUND(10),
	INT_ARRAY(11), LONG_ARRAY(12);

	private int typeID;

	private NBTType(int typeID)
	{
		this.typeID = typeID;
	}

	public int getTypeID()
	{
		return this.typeID;
	}

	public static NBTType valueOf(int typeID)
	{
		for(NBTType type : NBTType.values()){
			if(type.getTypeID() == typeID){
				return type;
			}
		}
		return null;
	}
}
