/*     */ package sum.ereignis;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class EBAnwendung extends Ereignisanwendung
/*     */ {
/*  15 */   private Vector hatEreignisbearbeiterListe = null;
/*     */ 
/*     */   public EBAnwendung()
/*     */   {
/*  23 */     this.hatEreignisbearbeiterListe = new Vector();
/*     */   }
/*     */ 
/*     */   public EBAnwendung(boolean pMitDoubleBuffering)
/*     */   {
/*  32 */     super(pMitDoubleBuffering);
/*  33 */     this.hatEreignisbearbeiterListe = new Vector();
/*     */   }
/*     */ 
/*     */   public EBAnwendung(int pBreite, int pHoehe)
/*     */   {
/*  44 */     super(pBreite, pHoehe);
/*  45 */     this.hatEreignisbearbeiterListe = new Vector();
/*     */   }
/*     */ 
/*     */   public EBAnwendung(int pBreite, int pHoehe, boolean pMitDoubleBuffering)
/*     */   {
/*  57 */     super(pBreite, pHoehe, pMitDoubleBuffering);
/*  58 */     this.hatEreignisbearbeiterListe = new Vector();
/*     */   }
/*     */ 
/*     */   public EBAnwendung(int pLinks, int pOben, int pBreite, int pHoehe)
/*     */   {
/*  72 */     super(pLinks, pOben, pBreite, pHoehe);
/*  73 */     this.hatEreignisbearbeiterListe = new Vector();
/*     */   }
/*     */ 
/*     */   public EBAnwendung(int pLinks, int pOben, int pBreite, int pHoehe, boolean pMitDoubleBuffering)
/*     */   {
/*  88 */     super(pLinks, pOben, pBreite, pHoehe, pMitDoubleBuffering);
/*  89 */     this.hatEreignisbearbeiterListe = new Vector();
/*     */   }
/*     */ 
/*     */   public void meldeAn(Ereignisbearbeiter pEreignisbearbeiter)
/*     */   {
/*  99 */     this.hatEreignisbearbeiterListe.addElement(pEreignisbearbeiter);
/*     */   }
/*     */ 
/*     */   public void bearbeiteTaste(char pZeichen)
/*     */   {
/* 110 */     if (this.hatEreignisbearbeiterListe != null)
/* 111 */       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
/*     */       {
/* 113 */         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
/*     */ 
/* 115 */         aktueller.bearbeiteTaste(pZeichen);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void bearbeiteMausDruck(int pWoH, int pWoV)
/*     */   {
/* 128 */     if (this.hatEreignisbearbeiterListe != null)
/* 129 */       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
/*     */       {
/* 131 */         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
/*     */ 
/* 133 */         aktueller.bearbeiteMausDruck(pWoH, pWoV);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void bearbeiteMausLos(int pWoH, int pWoV)
/*     */   {
/* 146 */     if (this.hatEreignisbearbeiterListe != null)
/* 147 */       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
/*     */       {
/* 149 */         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
/*     */ 
/* 151 */         aktueller.bearbeiteMausLos(pWoH, pWoV);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void bearbeiteMausBewegt(int pWohinH, int pWohinV)
/*     */   {
/* 164 */     if (this.hatEreignisbearbeiterListe != null)
/* 165 */       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
/*     */       {
/* 167 */         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
/*     */ 
/* 169 */         aktueller.bearbeiteMausBewegt(pWohinH, pWohinV);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void bearbeiteDoppelKlick(int pWoH, int pWoV)
/*     */   {
/* 182 */     if (this.hatEreignisbearbeiterListe != null)
/* 183 */       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
/*     */       {
/* 185 */         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
/*     */ 
/* 187 */         aktueller.bearbeiteDoppelKlick(pWoH, pWoV);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void bearbeiteLeerlauf()
/*     */   {
/* 198 */     if (this.hatEreignisbearbeiterListe != null)
/* 199 */       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
/*     */       {
/* 201 */         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
/*     */ 
/* 203 */         aktueller.bearbeiteLeerlauf();
/*     */       }
/*     */   }
/*     */ 
/*     */   public void bearbeiteUpdate()
/*     */   {
/* 214 */     if (this.hatEreignisbearbeiterListe != null)
/* 215 */       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
/*     */       {
/* 217 */         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
/*     */ 
/* 219 */         aktueller.bearbeiteUpdate();
/*     */       }
/*     */   }
/*     */ 
/*     */   public void bearbeiteFokusErhalten()
/*     */   {
/* 230 */     if (this.hatEreignisbearbeiterListe != null)
/* 231 */       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
/*     */       {
/* 233 */         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
/*     */ 
/* 235 */         aktueller.bearbeiteFokusErhalten();
/*     */       }
/*     */   }
/*     */ 
/*     */   public void bearbeiteFokusVerloren()
/*     */   {
/* 246 */     if (this.hatEreignisbearbeiterListe != null)
/* 247 */       for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); i++)
/*     */       {
/* 249 */         Ereignisbearbeiter aktueller = (Ereignisbearbeiter)this.hatEreignisbearbeiterListe.elementAt(i);
/*     */ 
/* 251 */         aktueller.bearbeiteFokusVerloren();
/*     */       }
/*     */   }
/*     */ }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.EBAnwendung
 * JD-Core Version:    0.6.0
 */