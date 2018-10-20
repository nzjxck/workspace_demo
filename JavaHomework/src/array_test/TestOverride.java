package array_test;

public class TestOverride {
	class Animal {
		protected String eyes;
		protected String nose;
		protected String mouth;

		public Animal(String eyes, String nose, String mouth) {
			this.eyes = eyes;
			this.nose = nose;
			this.mouth = mouth;
		}

		public void run() {
			System.out.println("动物会跑~");
		}
	}

	class Cat extends Animal {
		protected String tail;

		public Cat(String eyes, String nose, String mouth, String tail) {
			super(eyes, nose, mouth);
			this.tail = tail;
		}

		@Override
		public void run() {
			System.out.println("猫脚下有肉垫，猫步无声~");
		}
	}

	public static void main(String[] args) {
		TestOverride.Animal cat = new TestOverride().new Cat("blue", "small", "tiny", "short");
		cat.run();
	}
}
