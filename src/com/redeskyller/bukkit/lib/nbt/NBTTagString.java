package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagString extends NBTTag<String>
{

	public NBTTagString(String name, String value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.STRING;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeShort(this.value.toString().length());
		outputStream.write(this.value.toString().getBytes(NBTTag.CHARSET));
	}
}
