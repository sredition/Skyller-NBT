package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagFloat extends NBTTag<Float>
{

	public NBTTagFloat(String name, Float value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.FLOAT;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeFloat(this.value);
	}
}
