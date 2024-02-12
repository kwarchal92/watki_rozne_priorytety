package watki_rozne_priorytety;

class Priorytet implements Runnable
{
    int licznik;
    Thread wtk;

    static boolean stop = false;
    static String biezaca_nazwa;

    //tworzenie nowego watku
    Priorytet(String nazwa)
    {
        wtk = new Thread(this, nazwa);
        licznik = 0;
        biezaca_nazwa = nazwa;
    }

    //poczatek wykonywania nowego watku
    @Override
    public void run()
    {
        System.out.println(wtk.getName() + " startuje.");
        do
        {
            licznik++;
            if (biezaca_nazwa != wtk.getName())
            {
                biezaca_nazwa = wtk.getName();
                System.out.println(biezaca_nazwa);
            }
        }while(stop == false && licznik < 1000);
        stop = true;

        System.out.println(wtk.getName() + " zakonczono.");
    }
}

public class Main {
    public static void main(String[] args)
    {
        Priorytet mw1 = new Priorytet("Wysoki priorytet");
        Priorytet mw2 = new Priorytet("Niski priorytet");

        //ustawienie priorytetów
        mw1.wtk.setPriority(Thread.NORM_PRIORITY+2);
        mw2.wtk.setPriority(Thread.NORM_PRIORITY-2);

        //uruchomienie watkow
        mw1.wtk.start();
        mw2.wtk.start();

        try
        {
            mw1.wtk.join();
            mw2.wtk.join();
        }
        catch (InterruptedException exc)
        {
            System.out.println("glowny watek zostal przerwany.");
        }

        System.out.println("Wysoki priorytet watku: stan licznika = " + mw1.licznik + ".");
        System.out.println("Wysoki priorytet watku: stan licznika = " + mw2.licznik + ".");
    }

}
