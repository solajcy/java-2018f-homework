package hw2;
//��«���࣬������«�޵����Ժ͹��췽��
class CalabashBrother{
	private int number;
	private String name;
	private String color;
	public CalabashBrother(int i)
	{
		number=i;
		switch(number)
		{
		case 1:name="����";color="��ɫ";break;
		case 2:name="����";color="��ɫ";break;
		case 3:name="����";color="��ɫ";break;
		case 4:name="����";color="��ɫ";break;
		case 5:name="����";color="��ɫ";break;
		case 6:name="����";color="��ɫ";break;
		case 7:name="����";color="��ɫ";break;
		default:break;
		}
	}
	public int getNumber() {return number;}
	public String getName() {return name;}
	public String getColor() {return color;}
};
//��«�޶����࣬�����߸���«�޵Ķ��У��Լ����ҡ�����ķ���
class CalabashBrotherQueue
{
	//������洢�߸���«�ޣ�����֪����ǰλ��
	private CalabashBrother[] sevenCBS=new CalabashBrother[7];
	CalabashBrotherQueue()
	{
		for(int i=1;i<=7;i++) 
		{
			sevenCBS[i-1]=new CalabashBrother(i);
		}
	}
	//��ӡ��«������
	public void show()
	{
		for(int i=0;i<7;i++)
		{
			System.out.printf("%s ",sevenCBS[i].getName());
		}
		System.out.printf("\n");
	}
	//������ҷ���
	public void upset(int time)
	{	
		java.util.Random random=new java.util.Random();
		for(int j=0;j<time;j++)
		{
			for(int i=0;i<=6;i++)
			{
				int iRandom = random.nextInt(7);
				CalabashBrother temp=sevenCBS[iRandom];
				sevenCBS[iRandom]=sevenCBS[i];
				sevenCBS[i]=temp;
			}
		}
	}
	//ð�ݷ�������������
	public void sortByName()
	{
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<6-i;j++)
			{
				if(sevenCBS[j].getNumber()>sevenCBS[j+1].getNumber())
				{
					CalabashBrother temp=sevenCBS[j];
					System.out.printf("%s��%d->%d\n",sevenCBS[j+1].getName(),j+2,j+1);
					sevenCBS[j]=sevenCBS[j+1];
					System.out.printf("%s��%d->%d\n",temp.getName(),j+1,j+2);
					sevenCBS[j+1]=temp;
				}
			}
		}
	}
	//���ַ�������ɫ����
	public void sortByColor()
	{
		for (int i=0;i<7;i++)
		{
			CalabashBrother temp=sevenCBS[i];
			int left=0;
			int right=i-1;
			int middle=0;
			while(left <= right)
			{
				middle = (left + right)/2;
				if(temp.getNumber()<sevenCBS[middle].getNumber())
				{
					right = middle-1;
				}
				else
				{
					left = middle + 1;
				}
			}
			for(int j = i-1;j>=left;j--)
			{
				System.out.printf("%s��%d->%d\n",sevenCBS[j].getName(),j+1,j+2);
				sevenCBS[j+1] = sevenCBS[j];
			}
			if(left!=i)
			{
				System.out.printf("%s��%d->%d\n",temp.getName(),i+1,left+1);
				sevenCBS[left]=temp;
			}
		}
	}
};
//���࣬����main����
//һ��ʼ���������Ҳ������࣬������run configuration��������Main ClassΪhw2.CalabashBrotherSolve����
public class CalabashBrotherSolve {
	public static void main(String[] args)
	{
		CalabashBrotherQueue CBS = new CalabashBrotherQueue();
		System.out.println("��ʼ����");
		CBS.show();
		System.out.println("����������У�");
		CBS.upset(3);
		CBS.show();
		System.out.println("��������ð������");
		CBS.sortByName();
		CBS.show();
		System.out.println("�ٴδ��ң�");
		CBS.upset(3);
		CBS.show();
		System.out.println("������ɫ��������");
		CBS.sortByColor();
		CBS.show();
	}
}
