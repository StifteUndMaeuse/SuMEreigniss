 package sum.ereignis;
 
 public class Fenster extends Bildschirm
 {
   public Fenster()
   {
     super(0, 0, -1, -1, "SuM-Fenster " + (zFensternummer + 1), false);
   }
 
   public Fenster(String pName)
   {
     super(0, 0, -1, -1, pName, false);
   }
 
   public Fenster(boolean pMitDoubleBuffering)
   {
     super(0, 0, -1, -1, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
   }
 
   public Fenster(String pName, boolean pMitDoubleBuffering)
   {
     super(0, 0, -1, -1, pName, pMitDoubleBuffering);
   }
 
   public Fenster(int pBreite, int pHoehe)
   {
     super(0, 0, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
   }
 
   public Fenster(int pBreite, int pHoehe, String pName)
   {
     super(0, 0, pBreite, pHoehe, pName, false);
   }
 
   public Fenster(int pBreite, int pHoehe, String pName, boolean pMitDoubleBuffering)
   {
     super(0, 0, pBreite, pHoehe, pName, pMitDoubleBuffering);
   }
 
   public Fenster(int pBreite, int pHoehe, boolean pMitDoubleBuffering)
   {
     super(0, 0, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
   }
 
   public Fenster(int pLinks, int pOben, int pBreite, int pHoehe, String pName)
   {
     super(pLinks, pOben, pBreite, pHoehe, pName, false);
   }
 
   public Fenster(int pLinks, int pOben, int pBreite, int pHoehe)
   {
     super(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
   }
 
   public Fenster(int pLinks, int pOben, int pBreite, int pHoehe, String pName, boolean pMitDoubleBuffering)
   {
     super(pLinks, pOben, pBreite, pHoehe, pName, false);
   }
 
   public Fenster(int pLinks, int pOben, int pBreite, int pHoehe, boolean pMitDoubleBuffering)
   {
     super(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
   }
 }
