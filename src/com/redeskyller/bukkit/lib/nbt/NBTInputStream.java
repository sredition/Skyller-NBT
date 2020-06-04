package com.redeskyller.bukkit.lib.nbt;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class NBTInputStream implements Closeable
{

	private final DataInputStream dataInputStream;

	public NBTInputStream(final InputStream inputStream) throws IOException
	{
		this.dataInputStream = new DataInputStream(new GZIPInputStream(inputStream));
	}

	public NBTTag<?> read() throws IOException
	{
		NBTType tagType = NBTType.valueOf(this.dataInputStream.readByte());
		byte[] tagName = new byte[this.dataInputStream.readShort()];

		this.dataInputStream.readFully(tagName);

		return this.readPayload(new String(tagName, NBTTag.CHARSET), tagType);
	}

	private NBTTag<?> readPayload(String name, NBTType type) throws IOException
	{
		switch (type) {
		
		case BYTE:
			return new NBTTagByte(name, this.dataInputStream.readByte());

		case BYTE_ARRAY:
			byte[] byteArray = new byte[this.dataInputStream.readInt()];
			this.dataInputStream.readFully(byteArray);
			return new NBTTagByteArray(name, byteArray);

		case DOUBLE:
			return new NBTTagDouble(name, this.dataInputStream.readDouble());

		case FLOAT:
			return new NBTTagFloat(name, this.dataInputStream.readFloat());

		case INT:
			return new NBTTagInt(name, this.dataInputStream.readInt());

		case LONG:
			return new NBTTagLong(name, this.dataInputStream.readLong());

		case SHORT:
			return new NBTTagShort(name, this.dataInputStream.readShort());

		case STRING:
			byte[] stringBytes = new byte[this.dataInputStream.readShort()];
			this.dataInputStream.readFully(stringBytes);
			return new NBTTagString(name, new String(stringBytes, NBTTag.CHARSET));

		case LIST:
			NBTType listType = NBTType.valueOf(this.dataInputStream.readByte());

			NBTTag<?>[] list = new NBTTag<?>[this.dataInputStream.readInt()];

			for (int i = 0; i < list.length; i++) {
				list[i] = this.readPayload(name, listType);
			}
			return new NBTTagList<>(name, Arrays.asList(list));

		case COMPOUND:
			Map<String, NBTTag<?>> compoundMap = new HashMap<>();

			while (true) {

				NBTType compoundTagType = NBTType.valueOf(this.dataInputStream.readByte());
				if (compoundTagType == NBTType.END) {
					break;
				}

				byte[] compoundTagNameBytes = new byte[this.dataInputStream.readShort()];
				this.dataInputStream.readFully(compoundTagNameBytes);
				String compoundTagName = new String(compoundTagNameBytes, NBTTag.CHARSET);

				NBTTag<?> compoundTag = this.readPayload(compoundTagName, compoundTagType);

				compoundMap.put(compoundTagName, compoundTag);
			}
			return new NBTTagCompound(name, compoundMap);

		case INT_ARRAY:
			int[] intArray = new int[this.dataInputStream.readInt()];
			for (int i = 0; i < intArray.length; i++) {
				intArray[i] = this.dataInputStream.readInt();
			}
			return new NBTTagIntArray(name, intArray);
		case LONG_ARRAY:
			long[] longArray = new long[this.dataInputStream.readInt()];
			for (int i = 0; i < longArray.length; i++) {
				longArray[i] = this.dataInputStream.readLong();
			}
			return new NBTTagLongArray(name, longArray);

		case END:
			return new NBTTagEnd();
		}

		return new NBTTagEnd();
	}

	@Override
	public void close() throws IOException
	{
		this.dataInputStream.close();
	}

}
