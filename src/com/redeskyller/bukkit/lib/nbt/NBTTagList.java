package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NBTTagList<Type extends NBTTag<?>> extends NBTTag<List<Type>>
{

	public NBTTagList(String name)
	{
		this(name, new ArrayList<>());
	}

	public NBTTagList(String name, List<Type> value)
	{
		super(name, value);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.LIST;
	}

	public NBTType getListType()
	{
		if (!this.value.isEmpty()) {
			return this.value.get(0).getType();
		}
		return NBTType.END;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		outputStream.writeByte(this.getListType().getTypeID());
		outputStream.writeInt(this.value.size());

		for (NBTTag<?> target : this.value) {
			target.writePayload(outputStream);
		}

	}
}
