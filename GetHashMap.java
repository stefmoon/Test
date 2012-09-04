import java.io.*;
import java.util.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.tools.*;
import sun.jvm.hotspot.utilities.*;

public class GetHashMap extends Tool {
	public void run() {
		ObjectHeap heap = VM.getVM().getObjectHeap();
		InstanceKlass hashmapKlass =
						 SystemDictionaryHelper.findInstanceKlass("java.util.HashMap");
		final IntField sizeField = (IntField) hashmapKlass.findField("size", "I");

		heap.iterateObjectsOfKlass(new DefaultHeapVisitor() {
		    public boolean doObj(Oop oop) {
				 OopHandle handle = oop.getHandle();
				 int size = sizeField.getValue(oop);
				 if(size > 10000)
				 {
				 	 System.out.println("size is "+size);
					 System.out.println("The address is: "+handle.toString());
				 }
				 return false;
			}
		},hashmapKlass, false);
	}

	public static void main(String args[])
	{
		GetHashMap tool = new GetHashMap();
		tool.start(args);
		tool.stop();
	}
}
