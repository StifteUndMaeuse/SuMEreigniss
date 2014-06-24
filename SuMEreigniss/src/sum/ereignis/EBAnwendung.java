 package sum.ereignis;
 
 import java.util.Vector;
 
 public class EBAnwendung extends Ereignisanwendung
 {
   private Vector hatEreignisbearbeiterListe = null;
 
   public EBAnwendung()
   {
     this.hatEreignisbearbeiterListe = new Vector();
   }
 
   public EBAnwendung(boolean pMitDoubleBuffering)
   {
     super(pMitDoubleBuffering);
     this.hatEreignisbearbeiterListe = new Vector();
   }
 
   public EBAnwendung(int pBreite, int pHoehe)
   {
     super(pBreite, pHoehe);
     this.hatEreignisbearbeiterListe = new Vector();
   }
 
   public EBAnwendung(int pBreite, int pHoehe, boolean pMitDoubleBuffering)
   {
     super(pBreite, pHoehe, pMitDoubleBuffering);
     this.hatEreignisbearbeiterListe = new Vector();
   }
 
   public EBAnwendung(int pLinks, int pOben, int pBreite, int pHoehe)
   {
     super(pLinks, pOben, pBreite, pHoehe);
     this.hatEreignisbearbeiterListe = new Vector();
   }
 
   public EBAnwendung(int pLinks, int pOben, int pBreite, int pHoehe, boolean pMitDoubleBuffering)
   {
     super(pLinks, pOben, pBreite, pHoehe, pMitDoubleBuffering);
     this.hatEreignisbearbeiterListe = new Vector();
   }
 
   public void meldeAn(Ereignisbearbeiter pEreignisbearbeiter)
   {
     this.hatEreignisbearbeiterListe.addElement(pEreignisbearbeiter);
   }
 
   public void bearbeiteTaste(char pZeichen)
   {
     if (this.hatEreignisbearbeiterListe != null)
       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
       {
         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
 
         aktueller.bearbeiteTaste(pZeichen);
       }
   }
 
   public void bearbeiteMausDruck(int pWoH, int pWoV)
   {
     if (this.hatEreignisbearbeiterListe != null)
       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
       {
         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
 
         aktueller.bearbeiteMausDruck(pWoH, pWoV);
       }
   }
 
   public void bearbeiteMausLos(int pWoH, int pWoV)
   {
     if (this.hatEreignisbearbeiterListe != null)
       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
       {
         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
 
         aktueller.bearbeiteMausLos(pWoH, pWoV);
       }
   }
 
   public void bearbeiteMausBewegt(int pWohinH, int pWohinV)
   {
     if (this.hatEreignisbearbeiterListe != null)
       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
       {
         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
 
         aktueller.bearbeiteMausBewegt(pWohinH, pWohinV);
       }
   }
 
   public void bearbeiteDoppelKlick(int pWoH, int pWoV)
   {
     if (this.hatEreignisbearbeiterListe != null)
       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
       {
         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
 
         aktueller.bearbeiteDoppelKlick(pWoH, pWoV);
       }
   }
 
   public void bearbeiteLeerlauf()
   {
     if (this.hatEreignisbearbeiterListe != null)
       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
       {
         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
 
         aktueller.bearbeiteLeerlauf();
       }
   }
 
   public void bearbeiteUpdate()
   {
     if (this.hatEreignisbearbeiterListe != null)
       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
       {
         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
 
         aktueller.bearbeiteUpdate();
       }
   }
 
   public void bearbeiteFokusErhalten()
   {
     if (this.hatEreignisbearbeiterListe != null)
       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
       {
         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
 
         aktueller.bearbeiteFokusErhalten();
       }
   }
 
   public void bearbeiteFokusVerloren()
   {
     if (this.hatEreignisbearbeiterListe != null)
       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
       {
         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
 
         aktueller.bearbeiteFokusVerloren();
       }
   }
 }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.EBAnwendung
 * JD-Core Version:    0.6.0
 */