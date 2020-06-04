package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagIntArray extends NBTTag<int[]>
{
	public NBTTagIntArray(String name, int[] value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.INT_ARRAY;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeInt(this.value.length);
		for (int i = 0; i < this.value.length; i++) {
			outputStream.writeInt(this.value[i]);
		}
	}
}
