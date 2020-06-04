package com.redeskyller.bukkit.lib.nbt;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class NBTOutputStream implements Closeable
{

	private final DataOutputStream dataOutputStream;

	public NBTOutputStream(final OutputStream outputStream) throws IOException
	{
		this.dataOutputStream = new DataOutputStream(new GZIPOutputStream(outputStream));
	}

	public void write(NBTTag<?> namedBinaryTag) throws IOException
	{
		namedBinaryTag.write(this.dataOutputStream);
	}

	@Override
	public void close() throws IOException
	{
		this.dataOutputStream.close();
	}

}
