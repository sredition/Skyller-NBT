package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagInt extends NBTTag<Integer>
{

	public NBTTagInt(String name, Integer value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.INT;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeInt(this.value);
	}
}
