package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagLongArray extends NBTTag<long[]>
{
	public NBTTagLongArray(String name, long[] value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.LONG_ARRAY;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeInt(this.value.length);
		for (int i = 0; i < this.value.length; i++) {
			outputStream.writeLong(this.value[i]);
		}
	}
}
