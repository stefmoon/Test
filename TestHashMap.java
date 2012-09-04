import java.util.*;
public class TestHashMap
{
	public static void main(String args[])throws Exception
	{
		HashMap<String,String> hashMap = new HashMap<String,String>();
		HashMap<String,String> hashMap2 = new HashMap<String,String>();
		hashMap.put("1","taobao");
		hashMap.put("2","alipay");
		hashMap2.put("1","taobao");
		System.in.read();
		System.out.println(hashMap.get("1"));
		System.out.println(hashMap.get("2"));
		System.out.println(hashMap2.get("1"));
	}

}
