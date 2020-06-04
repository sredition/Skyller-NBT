package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagLong extends NBTTag<Long>
{

	public NBTTagLong(String name, Long value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.LONG;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeLong(this.value);
	}
}
