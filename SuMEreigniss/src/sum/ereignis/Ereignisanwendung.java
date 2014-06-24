/*     */ package sum.ereignis;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class Ereignisanwendung
/*     */   implements Runnable, Serializable
/*     */ {
/*     */   public Bildschirm hatBildschirm;
/*     */   private Thread sumThread;
/*     */   public static Ereignisanwendung hatSuMPrivateAnwendung;
/*  22 */   private boolean zFuehrtAus = false;
/*     */ 
/*     */   public Ereignisanwendung()
/*     */   {
/*  30 */     hatSuMPrivateAnwendung = this;
/*     */     try
/*     */     {
/*  33 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  37 */       System.out.println(e.toString());
/*     */     }
/*  39 */     this.hatBildschirm = new Bildschirm();
/*     */   }
/*     */ 
/*     */   public Ereignisanwendung(boolean pMitDoubleBuffering)
/*     */   {
/*  49 */     hatSuMPrivateAnwendung = this;
/*     */     try
/*     */     {
/*  52 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  56 */       System.out.println(e.toString());
/*     */     }
/*  58 */     this.hatBildschirm = new Bildschirm(pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   public Ereignisanwendung(int pBreite, int pHoehe)
/*     */   {
/*  71 */     hatSuMPrivateAnwendung = this;
/*     */     try
/*     */     {
/*  74 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  78 */       System.out.println(e.toString());
/*     */     }
/*  80 */     this.hatBildschirm = new Bildschirm(pBreite, pHoehe);
/*     */   }
/*     */ 
/*     */   public Ereignisanwendung(int pBreite, int pHoehe, boolean pMitDoubleBuffering)
/*     */   {
/*  94 */     hatSuMPrivateAnwendung = this;
/*     */     try
/*     */     {
/*  97 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 101 */       System.out.println(e.toString());
/*     */     }
/* 103 */     this.hatBildschirm = new Bildschirm(pBreite, pHoehe, pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   public Ereignisanwendung(int pLinks, int pOben, int pBreite, int pHoehe)
/*     */   {
/* 118 */     hatSuMPrivateAnwendung = this;
/*     */     try
/*     */     {
/* 121 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 125 */       System.out.println(e.toString());
/*     */     }
/* 127 */     this.hatBildschirm = new Bildschirm(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster" + (Bildschirm.zFensternummer + 1), false);
/*     */   }
/*     */ 
/*     */   public Ereignisanwendung(int pLinks, int pOben, int pBreite, int pHoehe, boolean pMitDoubleBuffering)
/*     */   {
/* 143 */     hatSuMPrivateAnwendung = this;
/*     */     try
/*     */     {
/* 146 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 150 */       System.out.println(e.toString());
/*     */     }
/* 152 */     this.hatBildschirm = new Bildschirm(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster" + (Bildschirm.zFensternummer + 1), pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   protected void melde(String s)
/*     */   {
/* 160 */     System.out.println(s);
/*     */   }
/*     */ 
/*     */   public Bildschirm bildschirm()
/*     */   {
/* 169 */     return this.hatBildschirm;
/*     */   }
/*     */ 
/*     */   public void fuehreAus()
/*     */   {
/* 177 */     if (this.sumThread == null)
/*     */     {
/* 179 */       warte(500L);
/* 180 */       this.zFuehrtAus = true;
/* 181 */       this.sumThread = new Thread(this);
/* 182 */       this.sumThread.start();
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void halteAn()
/*     */   {
/* 191 */     this.zFuehrtAus = false;
/*     */   }
/*     */ 
/*     */   public void beenden()
/*     */   {
/* 199 */     halteAn();
/* 200 */     this.hatBildschirm.gibFrei();
/* 201 */     System.exit(0);
/*     */   }
/*     */ 
/*     */   protected boolean fuehrtAus()
/*     */   {
/* 209 */     return this.zFuehrtAus;
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 218 */     while (this.zFuehrtAus)
/*     */     {
/*     */       try
/*     */       {
/* 222 */         bearbeiteLeerlauf();
/* 223 */         Thread.sleep(30L);
/*     */       }
/*     */       catch (InterruptedException e)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void warte(long pMillisekunden)
/*     */   {
/* 236 */     long start = System.currentTimeMillis();
/* 237 */     while (System.currentTimeMillis() - start < pMillisekunden);
/*     */   }
/*     */ 
/*     */   public void bearbeiteTaste(char pZeichen)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void bearbeiteMausDruck(int pWoH, int pWoV)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void bearbeiteMausLos(int pWoH, int pWoV)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void bearbeiteMausBewegt(int pWohinH, int pWohinV)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void bearbeiteDoppelKlick(int pWoH, int pWoV)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void bearbeiteLeerlauf()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void bearbeiteUpdate()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void bearbeiteFokusErhalten()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void bearbeiteFokusVerloren()
/*     */   {
/*     */   }
/*     */ 
/*     */   public boolean besitztFokus()
/*     */   {
/* 328 */     return this.hatBildschirm.besitztFokus();
/*     */   }
/*     */ 
/*     */   public void setzeFokus()
/*     */   {
/* 336 */     this.hatBildschirm.requestFocus();
/*     */   }
/*     */ 
/*     */   public void gibFrei()
/*     */   {
/* 344 */     this.hatBildschirm.gibFrei();
/*     */   }
/*     */ }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Ereignisanwendung
 * JD-Core Version:    0.6.0
 */