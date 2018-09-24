package code;
import java.util.Random;
/*enum Color{
	Red,Orange,Yellow,Green,Cyan,Blue,Purple
}*/
//��«����
class CalabashBrothers{
	static String[] RankName= {"�ϴ�","�϶�","����","����","����","����","����"};
	static String[] Color= {"��ɫ","��ɫ","��ɫ","��ɫ","��ɫ","��ɫ","��ɫ"};
	private int rank;		//int���͵�����(1~7)
	private String color;	//��ɫ
	private String nickname;//�º�,��"�ϴ�"��"�϶�"��
	CalabashBrothers(int r){	//���캯��
		rank=r+1;				
		color=Color[r];			
		nickname=RankName[r];	
	}
	//��ʾ��«�޵���Ϣ
	void ShowInfo() {			
		System.out.println(rank+" "+nickname+" "+color);
	}
	//������������Ϊ˽�б������ʽӿ�
	int get_rank() {
		return rank;
	}
	String get_color() {
		return color;
	}
	String get_nickname() {
		return nickname;
	}
	
	//�ж�һ����«���Ƿ����һ����«�����и���
	boolean rank_higher_than(CalabashBrothers another) {
		boolean result=rank<another.rank?true:false;
		return result;
	}
}
public class SortBrothers {
	static int numofBrothers=7;	//��«�޵�����
	//����[left,right]�����ظ��������
	static int[] get_random_series(int left,int right) {
		Random r=new Random();
		int size=right-left+1;
		int[] series=new int[size];			//�������������
		boolean[] flags=new boolean[size];	//��һ���������͵������������Ƿ��Ѿ�����
		for(int i=0;i<size;i++) {
			flags[i]=false;
		}
		int randint=0;
		//�������forѭ��Ϊ�������ĺ���
		for(int i=0;i<size;i++) {
			do {
				randint=r.nextInt(size)+left;
				
			}while(flags[randint]);	//���������Ѵ�������������
			flags[randint]=true;
			series[i]=randint;
		}
		return series;
	}
	//��rank����ð������,�����β�ΪCalabashBrothers���͵�����
	//Ϊ������������ֱ������,�ú���Ӧ�ö���Ϊstatic
	static void bubble_sort(CalabashBrothers[] cbs) {
		for(int i=cbs.length-1;i>=1;i--) {
			for(int j=0;j<i;j++) {
				if(cbs[j].get_rank()>cbs[j+1].get_rank()) {
					//��������н���λ���ƶ��ı���
					System.out.print(cbs[j].get_nickname()+": "+j+"->"+(j+1)+"  ");
					System.out.print(cbs[j+1].get_nickname()+": "+(j+1)+"->"+j+"  ");
					CalabashBrothers tmp=cbs[j];
					cbs[j]=cbs[j+1];
					cbs[j+1]=tmp;
				}
			}
		}
	}
	
	//�ö��ַ���������
	//�൱�ڲ�������ĸĽ�,���ö��ַ�������Ѳ���λ��
	static void binary_sort(CalabashBrothers[] cbs) {
		for(int i=0;i<cbs.length-1;i++) {		//����������в�����������
			//����������ʾ�������������еĿ�ʼ����β���м�
			int start=0,end=i,mid=(start+end)/2;
			CalabashBrothers tmp=cbs[i+1];
			
			while(start<=end) {
				mid=(start+end)/2;
				if(cbs[mid].get_rank()>tmp.get_rank()) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			for(int j=i;j>end;j--) {
				System.out.print(cbs[j].get_nickname()+": "+j+"->"+(j+1)+" ");
				cbs[j+1]=cbs[j];
			}
			if((i+1)!=(end+1)){
				System.out.print(tmp.get_nickname()+": "+(i+1)+"->"+(end+1)+" ");				
			}
			cbs[end+1]=tmp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������«���ֵܵ�����
		CalabashBrothers[] brothers=new CalabashBrothers [numofBrothers];
		int[] series=new int[numofBrothers];
		//�����������
		series=get_random_series(0,numofBrothers-1);
		//���ù��캯����������г�ʼ��
		for(int i=0;i<brothers.length;i++) {
			brothers[i]=new CalabashBrothers(series[i]);
		}
		System.out.println("��ʼ����:");
		//����
		for(int j=0;j<brothers.length;j++) {
			//brothers[j].ShowInfo();
			System.out.print(brothers[j].get_nickname()+" ");
		}
		//����
		bubble_sort(brothers);
		System.out.println("");
		System.out.println("ð���������:");
		for(int j=0;j<brothers.length;j++) {
			//brothers[j].ShowInfo();
			System.out.print(brothers[j].get_nickname()+" ");
		}
		
		//�ٴ������������
		series=get_random_series(0,numofBrothers-1);
		//int test[]= {6,4,3,5,2,1,0};
		for(int i=0;i<numofBrothers;i++) {
			brothers[i]=new CalabashBrothers(series[i]);
		}
		System.out.println("");
		System.out.println("�ٴ�����վ��:");
		for(int j=0;j<brothers.length;j++) {
			System.out.print(brothers[j].get_nickname()+" ");
		}
		System.out.println("");
		//���ַ���������
		binary_sort(brothers);
		System.out.println("");
		System.out.println("�������ɫ����:");
		for(int j=0;j<brothers.length;j++) {
			System.out.print(brothers[j].get_color()+" ");
		}
	}

}
