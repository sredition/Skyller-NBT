package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;

public class NBTTagByteArray extends NBTTag<byte[]>
{
	public NBTTagByteArray(String name, byte[] value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.BYTE_ARRAY;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeInt(this.value.length);
		for (int i = 0; i < this.value.length; i++) {
			outputStream.writeByte(this.value[i]);
		}
	}
}
