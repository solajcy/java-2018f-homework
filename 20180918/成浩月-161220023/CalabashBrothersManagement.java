import java.util.Random;

enum Color{
	RED("��ɫ"),ORANGE("��ɫ"),YELLOW("��ɫ"),GREEN("��ɫ"),CYAN("��ɫ"),BLUE("��ɫ"),PURPLE("��ɫ");
	String color;
	Color(String color){
		this.color=color;
	}
	public String toString() {
		return color;
	}
}

enum Status{
	FIRST("�ϴ�"),SECOND("�϶�"),THIRD("����"),FOURTH("����"),FIFTH("����"),SIXTH("����"),SEVENTH("����");
	String status;
	Status(String status){
		this.status=status;
	}
	public String toString() {
		return status;
	}
}

class CalabashBrothers{
	private Status status;
	private Color color;
	CalabashBrothers(int number){
		switch(number) {
			case 1:color=Color.RED;status=Status.FIRST;break;
			case 2:color=Color.ORANGE;status=Status.SECOND;break;
			case 3:color=Color.YELLOW;status=Status.THIRD;break;
			case 4:color=Color.GREEN;status=Status.FOURTH;break;
			case 5:color=Color.CYAN;status=Status.FIFTH;break;
			case 6:color=Color.BLUE;status=Status.SIXTH;break;
			case 7:color=Color.PURPLE;status=Status.SEVENTH;break;
			default:System.out.println("nonexistent");
		}
	}
	String statusstring() {
		return status.toString();
	}
	String colorstring() {
		return color.toString();
	}
	int statusnumber() {
		return status.ordinal();
	}
	int colornumber() {
		return color.ordinal();
	}
}

class Management {
	CalabashBrothers[] cala=new CalabashBrothers[7];
	Management(){
		for(int i=0;i<7;i++)
			cala[i]=new CalabashBrothers(i+1);
	}
	public void randomize() {
		Random random=new Random();
		for(int i=0;i<20;i++) {
			int x=random.nextInt(6);
			int y=random.nextInt(6);
			if(x!=y) {
				//��xλ�ú�yλ�õĺ�«�޽���
				CalabashBrothers temp = cala[x];
				cala[x]=cala[y];
				cala[y]=temp;
			}
		}
	}
	public void countoff(int name) {
		switch(name) {
			case 1:{//�������б���
				for(int i=0;i<7;i++)
					System.out.print(cala[i].statusstring());
			}break;
			case 2:{//������ɫ����
				for(int i=0;i<7;i++)
					System.out.print(cala[i].colorstring());
			}break;
			default:System.out.print("nonexistent");
		}
		System.out.println("");
	}
	private void tellstatuschange(int number,int x,int y) {
		System.out.println(cala[number].statusstring()+":"+x+"->"+y);
	}
	private void tellcolorchange(int number,int x,int y) {
		System.out.println(cala[number].colorstring()+":"+x+"->"+y);
	}
	public void sortbystatus() {
		System.out.println("ð�ݷ�������������");
		int i,j;
		boolean exchange;
		for(i=0;i<6;i++) {
			exchange=false;
			for(j=6;j>i;j--) {
				if(cala[j].statusnumber()<cala[j-1].statusnumber()) {
					CalabashBrothers temp=cala[j];
					cala[j]=cala[j-1];
					cala[j-1]=temp;
					exchange=true;
					tellstatuschange(j,j,j+1);
					tellstatuschange(j-1,j+1,j);
				}
			}
			if(!exchange)
				break;
		}
	}
	public void sortbycolor() {
		System.out.println("���ַ�������ɫ����");
		int i;
		for(i=1;i<7;i++) {
			int left=0,right=i-1;
			while(left<=right) {
				int middle=(right+left)/2;
				if(cala[i].colornumber()<cala[middle].colornumber())
					right=middle-1;
				else
					left=middle+1;
			}
			//�嵽leftλ��
			if(i!=left) {
				//��left��i-1֮���������������
				CalabashBrothers temp=cala[i];
				for(int j=i;j>=left+1;j--) {
					cala[j]=cala[j-1];
					tellcolorchange(j,j,j+1);
				}
				cala[left]=temp;
				tellcolorchange(left,i+1,left+1);
			}
		}
	}
}

public class CalabashBrothersManagement{
	public static void main(String[] args) {
		Management m=new Management();
		m.randomize();
		System.out.print("��������: ");
		m.countoff(1);
		m.sortbystatus();
		System.out.print("������: ");
		m.countoff(1);
		m.randomize();
		System.out.print("��������: ");
		m.countoff(2);
		m.sortbycolor();
		System.out.print("������: ");
		m.countoff(2);
	}
}