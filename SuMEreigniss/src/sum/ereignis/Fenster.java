/*     */ package sum.ereignis;
/*     */ 
/*     */ public class Fenster extends Bildschirm
/*     */ {
/*     */   public Fenster()
/*     */   {
/*  26 */     super(0, 0, -1, -1, "SuM-Fenster " + (zFensternummer + 1), false);
/*     */   }
/*     */ 
/*     */   public Fenster(String pName)
/*     */   {
/*  36 */     super(0, 0, -1, -1, pName, false);
/*     */   }
/*     */ 
/*     */   public Fenster(boolean pMitDoubleBuffering)
/*     */   {
/*  46 */     super(0, 0, -1, -1, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   public Fenster(String pName, boolean pMitDoubleBuffering)
/*     */   {
/*  57 */     super(0, 0, -1, -1, pName, pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   public Fenster(int pBreite, int pHoehe)
/*     */   {
/*  69 */     super(0, 0, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
/*     */   }
/*     */ 
/*     */   public Fenster(int pBreite, int pHoehe, String pName)
/*     */   {
/*  82 */     super(0, 0, pBreite, pHoehe, pName, false);
/*     */   }
/*     */ 
/*     */   public Fenster(int pBreite, int pHoehe, String pName, boolean pMitDoubleBuffering)
/*     */   {
/*  96 */     super(0, 0, pBreite, pHoehe, pName, pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   public Fenster(int pBreite, int pHoehe, boolean pMitDoubleBuffering)
/*     */   {
/* 109 */     super(0, 0, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   public Fenster(int pLinks, int pOben, int pBreite, int pHoehe, String pName)
/*     */   {
/* 125 */     super(pLinks, pOben, pBreite, pHoehe, pName, false);
/*     */   }
/*     */ 
/*     */   public Fenster(int pLinks, int pOben, int pBreite, int pHoehe)
/*     */   {
/* 139 */     super(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
/*     */   }
/*     */ 
/*     */   public Fenster(int pLinks, int pOben, int pBreite, int pHoehe, String pName, boolean pMitDoubleBuffering)
/*     */   {
/* 155 */     super(pLinks, pOben, pBreite, pHoehe, pName, false);
/*     */   }
/*     */ 
/*     */   public Fenster(int pLinks, int pOben, int pBreite, int pHoehe, boolean pMitDoubleBuffering)
/*     */   {
/* 170 */     super(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
/*     */   }
/*     */ }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Fenster
 * JD-Core Version:    0.6.0
 */