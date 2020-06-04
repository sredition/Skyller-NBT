package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NBTTagCompound extends NBTTag<Map<String, NBTTag<?>>>
{
	public NBTTagCompound()
	{
		this("");
	}

	public NBTTagCompound(String name)
	{
		this(name, new HashMap<>());
	}

	public NBTTagCompound(String name, Map<String, NBTTag<?>> value)
	{
		super(name, value);
	}

	public void set(NBTTag<?> tag)
	{
		if (tag != null) {
			this.value.put(tag.name, tag);
		}
	}

	public NBTTag<?> get(String name)
	{
		return this.value.get(name);
	}

	@SuppressWarnings("unchecked")
	public <Type extends NBTTag<?>> Type get(String name, Class<Type> classType)
	{
		try {
			return (Type) this.get(name);
		} catch (Exception exception) {
			return null;
		}
	}

	public boolean contains(String name)
	{
		return this.get(name) != null;
	}

	public void setByte(String name, byte value)
	{

		this.set(new NBTTagByte(name, value));
	}

	public byte getByte(String name)
	{
		return this.get(name, NBTTagByte.class).value;
	}

	public void setByteArray(String name, byte[] byteArray)
	{
		this.set(new NBTTagByteArray(name, byteArray));
	}

	public byte[] getByteArray(String name)
	{
		return this.get(name, NBTTagByteArray.class).value;
	}

	public void setIntArray(String name, int[] byteArray)
	{
		this.set(new NBTTagIntArray(name, byteArray));
	}

	public int[] getIntArray(String name)
	{
		return this.get(name, NBTTagIntArray.class).value;
	}

	public void setLongArray(String name, long[] byteArray)
	{
		this.set(new NBTTagLongArray(name, byteArray));
	}

	public long[] getLongArray(String name)
	{
		return this.get(name, NBTTagLongArray.class).value;
	}

	public void setDouble(String name, double value)
	{
		this.set(new NBTTagDouble(name, value));
	}

	public double getDouble(String name)
	{
		return this.get(name, NBTTagDouble.class).value;
	}

	public void setFloat(String name, float value)
	{
		this.set(new NBTTagFloat(name, value));
	}

	public float getFloat(String name)
	{
		return this.get(name, NBTTagFloat.class).value;
	}

	public void setInt(String name, int value)
	{
		this.set(new NBTTagInt(name, value));
	}

	public int getInt(String name)
	{
		return this.get(name, NBTTagInt.class).value;
	}

	public void setLong(String name, long value)
	{
		this.set(new NBTTagLong(name, value));
	}

	public long getLong(String name)
	{
		return this.get(name, NBTTagLong.class).value;
	}

	public void setShort(String name, short value)
	{
		this.set(new NBTTagShort(name, value));
	}

	public short getShort(String name)
	{
		return this.get(name, NBTTagShort.class).value;
	}

	public void setString(String name, String value)
	{
		this.set(new NBTTagString(name, value));
	}

	public String getString(String name)
	{
		return this.get(name, NBTTagString.class).value;
	}

	public NBTTagCompound getNBTTagCompound(String name)
	{
		return this.get(name, NBTTagCompound.class);
	}

	@Override
	public NBTType getType()
	{
		return NBTType.COMPOUND;
	}

	@Override
	protected void writePayload(DataOutputStream outputStream) throws IOException
	{
		for (Entry<String, NBTTag<?>> entry : this.value.entrySet()) {
			entry.getValue().write(outputStream);
		}
		outputStream.writeByte(NBTType.END.getTypeID());
	}

}
