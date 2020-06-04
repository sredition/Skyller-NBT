package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagShort extends NBTTag<Short>
{

	public NBTTagShort(String name, Short value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.SHORT;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeShort(this.value);
	}
}
