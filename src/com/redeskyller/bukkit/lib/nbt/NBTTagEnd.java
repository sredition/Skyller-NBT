package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;

public class NBTTagEnd extends NBTTag<Object>
{
	public NBTTagEnd()
	{
		super(null, null);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.END;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream)
	{
		// NOTHING
	}
}
