package secondHomework;

//��ɫ��ö����
enum Color {
	RED("����"), ORANGE("����"), YELLOW("����"), GREEN("����"), CYAN("����"), BLUE("��ɫ"), PURPLE("��ɫ");
	private String color;

	private Color(String color) {
		this.color = color;
	}

	public String toString() {
		return this.color;
	}
};

//���е�ö����
enum Rank {
	ONE("����"), TWO("����"), THREE("����"), FOUR("����"), FIVE("����"), SIX("����"), SEVEN("����");
	private String rank;

	private Rank(String rank) {
		this.rank = rank;
	}

	public String toString() {
		return this.rank;
	}
};

//��«���ֵ���
public class CalabashBrothers {
	// ��«�޸���
	private final static int NUM = 7, COLOR = 0, RANK = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = { 1, 0, 3, 6, 2, 5, 4 };
		CalabashBrothers c1 = new CalabashBrothers(a1);
		c1.binarySort();

		int a2[] = { 3, 6, 1, 5, 4, 2, 0 };
		CalabashBrothers c2 = new CalabashBrothers(a2);
		c2.bubbleSort();
	}

	// ��«����
	private class Calabash {
		private Color color;
		private Rank rank;

		protected Calabash(int index) {
			// TODO Auto-generated constructor stub
			this.color = Color.values()[index];
			this.rank = Rank.values()[index];
		}

		protected Color getColor() {
			return this.color;
		}

		protected Rank getRank() {
			return this.rank;
		}
	}

	// ��«������
	private Calabash calabashBrothers[] = new Calabash[NUM];

	public CalabashBrothers(int[] array) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < NUM; i++) {
			Calabash calabash = new Calabash(array[i]);
			calabashBrothers[i] = calabash;
		}
	}

	// ��ð�ݷ����ո�����������
	public void bubbleSort() {
		System.out.println("��ð�ݷ����ո�����������");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 - i; j++) {
				if (calabashBrothers[j].getRank().ordinal() > calabashBrothers[j + 1].getRank().ordinal()) {
					// λ�ô�0����
					System.out.println(swapProcess(calabashBrothers[j], j, j + 1, RANK));
					System.out.println(swapProcess(calabashBrothers[j + 1], j + 1, j, RANK));
					Calabash temp = calabashBrothers[j];
					calabashBrothers[j] = calabashBrothers[j + 1];
					calabashBrothers[j + 1] = temp;

				}
			}
		}
		for (int i = 0; i < NUM; i++) {
			System.out.print(calabashBrothers[i].rank.toString() + " ");
		}
		System.out.println("\n");
	}

	// �����ַ����ո�����ɫ����
	public void binarySort() {
		System.out.println("�����ַ����ո�����ɫ����");
		Calabash temp = null;
		for (int i = 1; i < NUM; i++) {
			temp = calabashBrothers[i];
			int left = 0, right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (calabashBrothers[mid].getColor().ordinal() > temp.getColor().ordinal())
					right = mid - 1;
				else
					left = mid + 1;
			}
			for (int j = i - 1; j > right; j--) {
				calabashBrothers[j + 1] = calabashBrothers[j];
				System.out.println(swapProcess(calabashBrothers[j], j, j + 1, COLOR));
			}
			calabashBrothers[right + 1] = temp;
			System.out.println(swapProcess(temp, i, right + 1, COLOR));
		}
		for (int i = 0; i < NUM; i++) {
			System.out.print(calabashBrothers[i].color.toString() + " ");
		}
		System.out.println("\n");
	}

	// ���ؽ������̵��ַ���
	private String swapProcess(Calabash calabash, int i, int j, int func) {
		String temp = null;
		switch (func) {
		case COLOR:
			temp = calabash.getColor().toString() + "��" + i + "->" + j;
			break;
		case RANK:
			temp = calabash.getRank().toString() + "��" + i + "->" + j;
			break;
		default:
			break;
		}
		return temp;
	}

}
