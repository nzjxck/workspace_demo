package Test_Collection;

/**
 * 练习ArrayList底层实现
 * @author MXJ
 *
 */
public class MyArrayList {
	private int size;
	private Object[] element;
	public MyArrayList(){
		this(10);
	}
	public MyArrayList (int elementCapcity){
		if(elementCapcity<0){
				try {
					throw new Exception("不能创建一个空间小于0的容器");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		this.element = new Object[elementCapcity]; 
	}
	public  void add(Object obj){
		if(this.size>this.element.length-1){
			//扩容（拿一个新的比原来大的容器，然后把原来容器里的元素拷贝进新容器，最后拿新容器替换掉老容器）
			Object[] newlist = new Object[size*2+2];
			System.arraycopy(element, 0, newlist, 0, element.length);
			this.element = newlist;
		}
		this.element[size] = obj;
		size++;
	}
	public boolean isEmpty(){
		return this.size ==0;
	}
	public Object get(int index){
		if(index<0||index>this.size-1){
			try {
				throw new Exception("下标处于非法范围");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.element[index];
	}
	public void remove1(int index){
		if(index<0||index>this.size-1){
			try {
				throw new Exception("下标处于非法范围");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			int numMoved = size-index-1;
			System.arraycopy(element, index+1, element, index, numMoved);
			element[size-1]=null;
			size--;
		}
	}
	public void remove(Object obj){
		for(int index=0;index<this.size;index++){
			if(obj.equals(this.element[index])){
				this.remove1(index);
			}
				if(obj==null){
				try {
					throw new Exception("目标不存在");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void set(int index,Object obj){
		if(index<0||index>this.size-1){
			try {
				throw new Exception("下标处于非法范围");
			} catch (Exception e) {
				e.printStackTrace();
		}
		}	
		this.element[index]=obj;
	}
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(3);
		list.add("000");
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		list.add("555");
		list.add("666");
		System.out.println(list.size);
		System.out.println(list.element.length);
		System.out.println(list.isEmpty());
		System.out.println(list.get(6));
		list.remove(2);
		list.remove("000");
		System.out.println(list.get(5));
		System.out.println(list.get(0));
		list.set(1, "123");
		System.out.println(list.get(1));
	}
}
