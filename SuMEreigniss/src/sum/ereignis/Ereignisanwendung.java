 package sum.ereignis;
 
 import java.io.PrintStream;
 import java.io.Serializable;
 import javax.swing.UIManager;
 
 public class Ereignisanwendung
   implements Runnable, Serializable
 {
   public Bildschirm hatBildschirm;
   private Thread sumThread;
   public static Ereignisanwendung hatSuMPrivateAnwendung;
   private boolean zFuehrtAus = false;
 
   public Ereignisanwendung()
   {
     hatSuMPrivateAnwendung = this;
     try
     {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     }
     catch (Exception e)
     {
       System.out.println(e.toString());
     }
     this.hatBildschirm = new Bildschirm();
   }
 
   public Ereignisanwendung(boolean pMitDoubleBuffering)
   {
     hatSuMPrivateAnwendung = this;
     try
     {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     }
     catch (Exception e)
     {
       System.out.println(e.toString());
     }
     this.hatBildschirm = new Bildschirm(pMitDoubleBuffering);
   }
 
   public Ereignisanwendung(int pBreite, int pHoehe)
   {
     hatSuMPrivateAnwendung = this;
     try
     {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     }
     catch (Exception e)
     {
       System.out.println(e.toString());
     }
     this.hatBildschirm = new Bildschirm(pBreite, pHoehe);
   }
 
   public Ereignisanwendung(int pBreite, int pHoehe, boolean pMitDoubleBuffering)
   {
     hatSuMPrivateAnwendung = this;
     try
     {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     }
     catch (Exception e)
     {
       System.out.println(e.toString());
     }
     this.hatBildschirm = new Bildschirm(pBreite, pHoehe, pMitDoubleBuffering);
   }
 
   public Ereignisanwendung(int pLinks, int pOben, int pBreite, int pHoehe)
   {
     hatSuMPrivateAnwendung = this;
     try
     {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     }
     catch (Exception e)
     {
       System.out.println(e.toString());
     }
     this.hatBildschirm = new Bildschirm(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster" + (Bildschirm.zFensternummer + 1), false);
   }
 
   public Ereignisanwendung(int pLinks, int pOben, int pBreite, int pHoehe, boolean pMitDoubleBuffering)
   {
     hatSuMPrivateAnwendung = this;
     try
     {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     }
     catch (Exception e)
     {
       System.out.println(e.toString());
     }
     this.hatBildschirm = new Bildschirm(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster" + (Bildschirm.zFensternummer + 1), pMitDoubleBuffering);
   }
 
   protected void melde(String s)
   {
     System.out.println(s);
   }
 
   public Bildschirm bildschirm()
   {
     return this.hatBildschirm;
   }
 
   public void fuehreAus()
   {
     if (this.sumThread == null)
     {
       warte(500L);
       this.zFuehrtAus = true;
       this.sumThread = new Thread(this);
       this.sumThread.start();
     }
   }
 
   protected void halteAn()
   {
     this.zFuehrtAus = false;
   }
 
   public void beenden()
   {
     halteAn();
     this.hatBildschirm.gibFrei();
     System.exit(0);
   }
 
   protected boolean fuehrtAus()
   {
     return this.zFuehrtAus;
   }
 
   public void run()
   {
     while (this.zFuehrtAus)
     {
       try
       {
         bearbeiteLeerlauf();
         Thread.sleep(30L);
       }
       catch (InterruptedException e)
       {
       }
     }
   }
 
   protected void warte(long pMillisekunden)
   {
     long start = System.currentTimeMillis();
     while (System.currentTimeMillis() - start < pMillisekunden);
   }
 
   public void bearbeiteTaste(char pZeichen)
   {
   }
 
   public void bearbeiteMausDruck(int pWoH, int pWoV)
   {
   }
 
   public void bearbeiteMausLos(int pWoH, int pWoV)
   {
   }
 
   public void bearbeiteMausBewegt(int pWohinH, int pWohinV)
   {
   }
 
   public void bearbeiteDoppelKlick(int pWoH, int pWoV)
   {
   }
 
   public void bearbeiteLeerlauf()
   {
   }
 
   public void bearbeiteUpdate()
   {
   }
 
   public void bearbeiteFokusErhalten()
   {
   }
 
   public void bearbeiteFokusVerloren()
   {
   }
 
   public boolean besitztFokus()
   {
     return this.hatBildschirm.besitztFokus();
   }
 
   public void setzeFokus()
   {
     this.hatBildschirm.requestFocus();
   }
 
   public void gibFrei()
   {
     this.hatBildschirm.gibFrei();
   }
 }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Ereignisanwendung
 * JD-Core Version:    0.6.0
 */