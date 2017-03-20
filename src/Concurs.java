import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MariusDK on 19.03.2017.
 */
public class Concurs {
        ArrayList<Integer> ordineParticipanti=new ArrayList<Integer>();
        ArrayList<String> ordineParticipantiFINAL=new ArrayList<String>();
    public boolean next(int k)
    {
            if (k<ordineParticipanti.size())
            {
                return true;
            }
            return false;
    }
    public boolean validare(int val,int poz)
    {


        if (poz >= ordineParticipanti.size())
        {
            return false;
        }
        /**
        if (ordineParticipanti.get(poz)>=ordineParticipanti.size())
        {
            return false;
        }
        */
        if (val==0)
        {
            return false;
        }
        for (int i=0;i<=poz;i++)
        {
            if (val==ordineParticipanti.get(i))
            {
                return false;
            }

        }
        return true;
    }
    public void initializare(int n)
    {
        for (int i=0;i<n;i++)
        {
            ordineParticipanti.add(i+1);
        }
    }
    public void backtraking(int n)
    {
        //boolean valid=false;
        //boolean succesor;
        int nivel=n-1;
        //int k=ordineParticipanti.get(nivel-1);;

        while(nivel>-1)
        {
         int i=1;

            while ((next(ordineParticipanti.get(nivel))==true))
            {
                //System.out.println(nivel);
                int j=0;

                if (validare(ordineParticipanti.get(nivel)+i,nivel))
                {
                    j=ordineParticipanti.get(nivel)+i;
                    //System.out.println(j);
                    if (j>ordineParticipanti.size())
                    {
                        break;
                    }
                    ordineParticipanti.set(nivel,j);

                    i=0;
                    if (nivel<ordineParticipanti.size()-1)
                    {

                        nivel++;
                        ordineParticipanti.set(nivel,0);

                    }
                    //System.out.println(ordineParticipanti);
                }
                else {
                    i++;
                }


            }
            if (validareSol()==true) {
                //System.out.println(ordineParticipanti);
                addVal();
        }
            nivel--;
        }



    }
    public  boolean validareSol() {
        /**
        for (int i = 0; i < ordineParticipanti.size(); i++) {
            for (int j = 0; j < ordineParticipanti.size(); j++) {
                if ((ordineParticipanti.get(i) == ordineParticipanti.get(j)) && (i != j)) {
                    return false;
                }
                if (ordineParticipanti.get(i) == 0) {
                    return false;
                }
            }
        }
        for (int i = 0; i < ordineParticipanti.size(); i++) {
            if ((ordineParticipanti.get(i)<=0)&&(ordineParticipanti.get(i)>ordineParticipanti.size()))
            {
                return false;
            }
        }
         */
        int k;
        k=3;
        int ok1=0;
        int ok2=0;
        if (ordineParticipanti.size()<3)
        {
            k=ordineParticipanti.size();
        }
        for (int i=0;i<k;i++)
        {
            if (ordineParticipanti.get(i)==1)
            {
                ok1++;
            }
        }
        if (ordineParticipanti.size()>1) {
            for (int j = ordineParticipanti.size() - 2; j < ordineParticipanti.size(); j++) {
                if (ordineParticipanti.get(j) == 2) {
                    ok2++;
                }
            }
        }
        if ((ok1==1)&&(ok2==1))
        {
            return true;
        }
        return false;
    }
    public void addVal()
    {
        String val="";
        for (int i=0;i<ordineParticipanti.size();i++)
        {
            val=val+" C"+ordineParticipanti.get(i);

        }
        if (!ordineParticipantiFINAL.contains(val))
        {
            ordineParticipantiFINAL.add(val);
        }
        //System.out.println(val);

    }
    public void afisare()
    {

            System.out.println(ordineParticipantiFINAL);

    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Dati lungimea sirului: ");
        int n=sc.nextInt();
        Concurs c=new Concurs();
        c.initializare(n);
        c.backtraking(n);
        c.afisare();
    }


}
