package com.redeskyller.bukkit.lib.nbt;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class NBTTag<V>
{
	public static final Charset CHARSET = Charset.forName("UTF-8");

	public final String name;
	public V value;

	public NBTTag(final String name, V value)
	{
		this.name = (name != null ? name : "");
		this.value = value;
	}

	public abstract NBTType getType();

	@Override
	public String toString()
	{
		return this.value.toString();
	}

	protected void write(final DataOutputStream outputStream) throws IOException
	{
		this.writeHead(outputStream);
		this.writePayload(outputStream);
	}

	protected void writeHead(final DataOutputStream outputStream) throws IOException
	{
		outputStream.writeByte(this.getType().getTypeID());
		outputStream.writeShort(this.name.length());
		outputStream.write(this.name.getBytes(NBTTag.CHARSET));
	}

	protected abstract void writePayload(final DataOutputStream outputStream) throws IOException;

}
