package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagDouble extends NBTTag<Double>
{

	public NBTTagDouble(String name, Double value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.DOUBLE;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeDouble(this.value);
	}
}
