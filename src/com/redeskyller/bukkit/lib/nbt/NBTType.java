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
		switch (typeID) {
		case 0:
			return END;
		case 1:
			return BYTE;
		case 2:
			return SHORT;
		case 3:
			return INT;
		case 4:
			return LONG;
		case 5:
			return FLOAT;
		case 6:
			return DOUBLE;
		case 7:
			return BYTE_ARRAY;
		case 8:
			return STRING;
		case 9:
			return LIST;
		case 10:
			return COMPOUND;
		case 11:
			return INT_ARRAY;
		case 12:
			return LONG_ARRAY;
		}
		return null;
	}
}
