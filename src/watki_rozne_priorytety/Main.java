package watki_rozne_priorytety;

class Priorytety implements Runnable
{
    int licznik;
    Thread wtk;

    static boolean stop = false;
    static String bierzaca_nazwa;

    //tworzenie nowego watku
    Priorytet(String nazwa)
    {
        wtk = new Thread(this, nazwa);
        licznik = 0;
        bierzaca_nazwa = nazwa;
    }

    //poczatek wykonywania nowego watku
    @Override
    public void run()
    {
        System.out.println(wtk.getName() + " startuje.");
        do
        {
            licznik++;
            if (bierzaca_nazwa != wtk.getName())
            {
                System.out.println(bierzaca_nazwa);
            }
        }while(stop == false && licznik < 1000);
        stop = true;

        System.out.println(wtk.getName() + " zakonczono.");
    }
}

public class Main {
    public static void main(String[] args)
    {
        
    }

}
