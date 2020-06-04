package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagByte extends NBTTag<Byte>
{
	public NBTTagByte(String name, Byte value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.BYTE;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeByte(this.value);
	}

}
